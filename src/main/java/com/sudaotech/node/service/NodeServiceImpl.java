package com.sudaotech.node.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.core.Cachable;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.node.dao.NodeEntity;
import com.sudaotech.node.dao.NodeEntityExample;
import com.sudaotech.node.dao.NodeEntityMapper;
import com.sudaotech.util.BeanUtils;

public class NodeServiceImpl extends BaseServiceImpl implements NodeService {

    @Inject
    private NodeEntityMapper nodeEntityMapper;
    
	@Override
	public Node getByNodeId(Long nodeId) {
		NodeEntity entity = this.nodeEntityMapper.selectByPrimaryKey(nodeId);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Node.class);
		}
		
		return null;
	}

	@Override
	public Long create(Node obj) {
		obj.setNodeId(this.getSequenceService().nextLong());
		
		NodeEntity entity = BeanUtils.copyProperties(obj, NodeEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(new Date());
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
		this.nodeEntityMapper.insertSelective(entity);
		
		return obj.getNodeId();
	}

	@Override
	public void update(Node obj) {
        logger.debug("Updating Node: {}", obj);
        
		NodeEntity entity = BeanUtils.copyProperties(obj, NodeEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
		this.nodeEntityMapper.updateByPrimaryKeySelective(entity);
		
		logger.info("Updated Node: {}", obj);
	}

	@Override
	public Node findNodeByTypeAndCode(final Integer nodeType, final String code) {
		Cachable<Node> cache = new Cachable<NodeService.Node>() {
			@Override
			public Object getKey() {
				return "node::" + nodeType + "::" + code;
			}
			@Override
			public Node getValue() {
		        NodeEntityExample example = new NodeEntityExample();
		        example.createCriteria()
			        .andNodeTypeEqualTo(nodeType)
			        .andCodeEqualTo(code)
			        .andStatusEqualTo(Status.NORMAL);
		        List<NodeEntity> entityList = nodeEntityMapper.selectByExample(example);
		        if (!CollectionUtils.isEmpty(entityList)) {
		        	if (entityList.size() > 1) {
		        		logger.warn("Found {} nodes by nodeType={}, code={}", entityList.size(), nodeType, code);
		        	}
		        	return BeanUtils.copyProperties(entityList.get(0), Node.class); 
		        }
				return null;
			}
		};
		
		return this.getCacheService().cache(cache);
	}

	@Override
	public List<Node> findNodesByTypeAndParent(final Integer nodeType, final String parent) {
        NodeEntityExample example = new NodeEntityExample();
        example.createCriteria()
            .andNodeTypeEqualTo(nodeType)
            .andParentEqualTo(parent)
            .andStatusEqualTo(Status.NORMAL);
        List<NodeEntity> entityList = nodeEntityMapper.selectByExample(example);
        
        return BeanUtils.copyListProperties(entityList, Node.class);
	}

    @Override
    public void removeNodesByTypeAndParent(final Integer nodeType, final String parent) {
        NodeEntityExample example = new NodeEntityExample();
        example.createCriteria()
            .andNodeTypeEqualTo(nodeType)
            .andParentEqualTo(parent)
            .andStatusEqualTo(Status.NORMAL);
        NodeEntity record = new NodeEntity();
        record.setStatus(Status.DELETED);
        nodeEntityMapper.updateByExampleSelective(record, example);
    }

    @Override
    public Node findNodeByTypeAndCodeAndParent(Integer nodeType, String code, String parent) {
        NodeEntityExample example = new NodeEntityExample();
        example.createCriteria()
            .andNodeTypeEqualTo(nodeType)
            .andCodeEqualTo(code)
            .andParentEqualTo(parent)
            .andStatusEqualTo(Status.NORMAL);
        List<NodeEntity> entityList = nodeEntityMapper.selectByExample(example);
        example.setOrderByClause("displayOrder DESC, nodeId DESC");
        if (!CollectionUtils.isEmpty(entityList)) {
            if (entityList.size() > 1) {
                logger.warn("Found {} nodes by nodeType={}, code={}", entityList.size(), nodeType, code);
            }
            return BeanUtils.copyProperties(entityList.get(0), Node.class); 
        }
        return null;
    }
}
