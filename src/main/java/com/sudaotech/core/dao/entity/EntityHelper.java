package com.sudaotech.core.dao.entity;

import java.util.Date;

import com.sudaotech.core.Session;
import com.sudaotech.core.Updatable;
import com.sudaotech.core.enums.Status;


public abstract class EntityHelper {
    /**
     * Set the status and createXXX field
     * @param entity
     * @param status
     * @param session
     * @return the entity
     */
    public static <T extends Updatable> T setCreateStatusFields(T entity, Status status, Session session) {
        entity.setStatus(Status.NORMAL);
        return setCreateFields(entity, session);
    } 
    public static <T extends Updatable> T setCreateFields(T entity, Session session) {
        entity.setCreateBy((session == null ||session.getUserId() ==null)? 0 : session.getUserId());
        entity.setCreateTime(new Date());
        return entity;
    } 
    /**
     * Set the status and updateXXX filed
     * @param entity
     * @param status
     * @param session
     * @return the entity
     */
    public static <T extends Updatable> T setUpdateStatusFields(T entity, Status status, Session session) {
        entity.setStatus(status);
        return setUpdateFields(entity, session);
    } 
    public static <T extends Updatable> T setUpdateFields(T entity, Session session) {
        entity.setUpdateBy(session == null ? 0 : session.getUserId());
        entity.setUpdateTime(new Date());
        return entity;
    } 
}
