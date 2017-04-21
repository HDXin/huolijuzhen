package com.sudaotech.note.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.note.dao.NoteEntity;

public interface NoteService extends BaseService {

    public Note getById(Long noteId);

    public Long create(Note obj);

    public void update(Note obj);

    public Page<Note> find(Query query);
    
    public static class Query extends Pagination {
    }
    
    public static class Note extends NoteEntity {
    }
}
