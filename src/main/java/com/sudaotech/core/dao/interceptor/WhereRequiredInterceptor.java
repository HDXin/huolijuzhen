package com.sudaotech.core.dao.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * SQL 语句在查询、更新、删除时需要指定where条件
 */
@Intercepts({ 
    @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
    @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) 
})
public class WhereRequiredInterceptor extends AbstractInterceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        if (args[0] instanceof MappedStatement) {
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            Object parameter = invocation.getArgs()[1];
            mappedStatement.getSqlSource().getBoundSql(parameter);
            SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
            
            if (!SqlCommandType.INSERT.equals(sqlCommandType)) {
                BoundSql boundSql = mappedStatement.getBoundSql(parameter);
                String sql = boundSql.getSql().toUpperCase();
                if (SqlCommandType.SELECT.equals(sqlCommandType) && sql.indexOf("LAST_INSERT_ID") > 0) {
                    // don't check
                } else if (sql.indexOf("WHERE") < 0) {
                    throw new UnsupportedOperationException("SQL missing where_condition: " + boundSql.getSql());
                }
            }
        }
        
        return invocation.proceed();
    }

}
