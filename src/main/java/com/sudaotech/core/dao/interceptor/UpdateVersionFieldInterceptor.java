package com.sudaotech.core.dao.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

/**
 * 模拟JPA实现乐观锁。（待完善）
 * 简单策略：若实体声明version属性，则update操作将为其附加指定version参数；并拒绝外部更新version。
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class UpdateVersionFieldInterceptor extends AbstractInterceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (isUpdateMethod(invocation)) {
            return processInvocation(invocation);
        }
        return invocation.proceed();
    }

    private Object processInvocation(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        mappedStatement.getSqlSource().getBoundSql(parameter);
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        String sql = boundSql.getSql();
        String newSql = buildSqlWithVersionField(sql, parameter);
        invocation.getArgs()[0] = getMappedStatement(mappedStatement, boundSql, newSql == null ? sql : newSql);
        
        return invocation.proceed();
    }

    /**
     * Build SQL statement on version support entity
     * @param sql
     * @param parameter
     * @return the update SQL or null if entity has no version
     */
    private String buildSqlWithVersionField(final String sql, Object parameter) {
        String newSql = null;
        int i = checkSqlWhere(sql);

        if (this.existField("version", parameter)) {
            int versionIndex = sql.indexOf("version");
            if (versionIndex > 0) {
                int j = sql.indexOf("?", versionIndex); // j MUST > 0
                newSql = sql.substring(0, j) + "version+1" + sql.substring(j+1);
            } else {
                newSql = sql.substring(0, i) + ", version=version+1 " + sql.substring(i);
            }
            newSql += " AND (version = ?)";
            this.logger.debug("SQL(version added): {}", sql);
        }
        
        return newSql;
    }

    private int checkSqlWhere(final String sql) {
        int i = sql.indexOf("WHERE");
        if (i < 0) {
            throw new RuntimeException("Unsafe SQL: " + sql);
        }
        return i;
    }

    private boolean isUpdateMethod(Invocation invocation) {
        Object[] args = invocation.getArgs();
        if (args[0] instanceof MappedStatement) {
            MappedStatement mappedStatement = (MappedStatement) args[0];
            return SqlCommandType.UPDATE.equals(mappedStatement.getSqlCommandType());
        }
        return false;
    }
}
