package com.sudaotech.core.dao.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

/**
 * 此拦截器用于防止程序使用SQL delete物理删除数据。
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class DeleteDisabledInterceptor extends AbstractInterceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 禁止 SQL delete操作
        Object[] args = invocation.getArgs();
        if (args[0] instanceof MappedStatement) {
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            Object parameter = invocation.getArgs()[1];
            mappedStatement.getSqlSource().getBoundSql(parameter);
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);
            if (SqlCommandType.DELETE.equals(mappedStatement.getSqlCommandType())) {
                throw new UnsupportedOperationException("SQL DELETE NOT SUPPORTED: " + boundSql.getSql());
            }
        }
        
        return invocation.proceed();
    }
}
