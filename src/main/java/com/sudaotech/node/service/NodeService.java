package com.sudaotech.node.service;

import java.util.List;

import com.sudaotech.core.Updatable;
import com.sudaotech.core.service.BaseService;

public interface NodeService extends BaseService {

    public Node getByNodeId(Long nodeId);

    public Long create(Node obj);

    public void update(Node obj);

	Node findNodeByTypeAndCode(Integer nodeType, String code);
    Node findNodeByTypeAndCodeAndParent(Integer nodeType, String code, String parent);
	
    List<Node> findNodesByTypeAndParent(final Integer nodeType, final String parent);
    void removeNodesByTypeAndParent(final Integer nodeType, final String parent);

	public static class Node extends Updatable {
		private Long nodeId;

		private Integer nodeType;

		private String parent;

		private String code;

		private String name;

		private String content;

		private String image;

		private String note;

		private String attr;


		public Long getNodeId() {
			return nodeId;
		}

		public void setNodeId(Long id) {
			this.nodeId = id;
		}

		public Integer getNodeType() {
			return nodeType;
		}

		public void setNodeType(Integer nodeType) {
			this.nodeType = nodeType;
		}

		public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code == null ? null : code.trim();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name == null ? null : name.trim();
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content == null ? null : content.trim();
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image == null ? null : image.trim();
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note == null ? null : note.trim();
		}

		public String getAttr() {
			return attr;
		}

		public void setAttr(String attr) {
			this.attr = attr == null ? null : attr.trim();
		}

	}
}
