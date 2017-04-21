package com.sudaotech.note.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.note.dao.NoteEntity;
import com.sudaotech.note.dao.NoteEntityExample;
import com.sudaotech.note.dao.NoteEntityExample.Criteria;
import com.sudaotech.note.dao.NoteEntityMapper;
import com.sudaotech.util.BeanUtils;

public class NoteServiceImpl extends BaseServiceImpl implements NoteService {
    private static final String TRACKING_TYPE = "Note";

    @Inject
    private NoteEntityMapper noteEntityMapper;

	@Override
	public Note getById(Long noteId) {
		NoteEntity entity = this.noteEntityMapper.selectByPrimaryKey(noteId);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Note.class);
		}
		
		return null;
	}

	@Override
	public Long create(Note obj) {
		logger.debug("Creating Note: {}", obj);

		obj.setNoteId(this.getSequenceService().nextLong());
		
		NoteEntity entity = BeanUtils.copyProperties(obj, NoteEntity.class);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setStatus(Status.NORMAL);

		this.noteEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getNoteId(), "create", entity);
		
		logger.info("Created Note: {}", obj);

		return obj.getNoteId();
	}

	@Override
	public void update(Note obj) {
		logger.debug("Updating Note: {}", obj);

		NoteEntity entity = BeanUtils.copyProperties(obj, NoteEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.noteEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getNoteId(), "update", entity);

		logger.info("Updated Note: {}", obj);
	}

	@Override
	public Page<Note> find(Query query) {
		Page<Note> page = new Page<Note>(query);
		NoteEntityExample example = new NoteEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("noteId DESC");
		page.setTotal(this.noteEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			PageHelper.startPage(query.getStartPage(), query.getLimit(), false);
			List<NoteEntity> list = this.noteEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Note.class));
		}
		
		return page;
	}
}
