package com.sudaotech.huolijuzhen.task.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.task.dao.TaskExecutorEntity;

public interface TaskExecutorService extends BaseService {

    public TaskExecutor getById(Long id);

    public Long create(TaskExecutor obj);

    public void update(TaskExecutor obj);

    public Long save(TaskExecutor obj);

    public Page<TaskExecutor> find(Query query);
    
    public List<Long> findAllTaskByExecutorId(Long userId);
    
    public static class Query extends Pagination {
    }
    
    public static class TaskExecutor extends TaskExecutorEntity {
    }

	public List<Long> findAllTaskExecutorByTaskId(Long taskId);
	
	public List<Long> findAllExecutorByTaskId(Long taskId);

	
}
