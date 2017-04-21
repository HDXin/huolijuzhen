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
 * 此拦截器用于防止程序执行select时遗漏status参数，和增加Order By参数。
 * 通过日志分析和改进缺少的WHERE, Order by等，适用于开发阶段和测试环境，生产环境慎用。
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class SelectInterceptor extends AbstractInterceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        if (args[0] instanceof MappedStatement) {
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            Object[] objects = invocation.getArgs();
            Object parameter = objects[1];
            mappedStatement.getSqlSource().getBoundSql(parameter);
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);
            if (SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
                String sql = boundSql.getSql().toUpperCase();
                if (sql.indexOf("LAST_INSERT_ID") > 0) {
                    // Skip if SELECT LAST_INSERT_ID()
                    return invocation.proceed();
                }
                
                // check status where condition
                int i = sql.indexOf("WHERE");
                int j = -1;
                if (i > 0) {
                    j = sql.indexOf("STATUS", i);
                }
                String newSql = null;
                if (j < 0) {
                    newSql = boundSql.getSql();
                    // having where
                    if (i > 0) {
                        newSql += " AND";
                    } else {
                        newSql += " WHERE";
                    }
                    newSql += " (status != -1)";
                    
                    this.logger.debug("SQL SELECT missing status in where_condition.\n>>> OriginSQL: {} \n>>> ResetSQL: {}", boundSql.getSql(), newSql);
                }
                
                // check order by clause
                if (sql.indexOf(" ORDER BY ") < 0) {
                    if (newSql == null) {
                        newSql = boundSql.getSql();
                    }
                    newSql += " ORDER BY lastUpdate DESC";
                    this.logger.debug("SQL SELECT missing ORDER BY.\n>>> OriginSQL: {} \n>>> ResetSQL: {}", boundSql.getSql(), newSql);
                }
                
                if (newSql != null) {
                    invocation.getArgs()[0] = getMappedStatement(mappedStatement, boundSql, newSql);
                }
            }
        }
        
        return invocation.proceed();
    }

}
