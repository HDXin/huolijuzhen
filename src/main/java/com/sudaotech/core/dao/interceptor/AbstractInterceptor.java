package com.sudaotech.core.dao.interceptor;

import java.lang.reflect.Field;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractInterceptor implements Interceptor {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public abstract Object intercept(Invocation invocation) throws Throwable;

    public final boolean existField(final String fieldName, Object parameter) {
        Field[] fields = parameter.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }

        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }


    protected MappedStatement getMappedStatement(MappedStatement mappedStatement, BoundSql boundSql, String resetSql) {
        final BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), resetSql,
                boundSql.getParameterMappings(), boundSql.getParameterObject());

        Builder builder = new MappedStatement.Builder(mappedStatement.getConfiguration(), mappedStatement.getId(),
                new SqlSource() {
                    public BoundSql getBoundSql(Object parameterObject) {
                        return newBoundSql;
                    }
                }, mappedStatement.getSqlCommandType());

        builder.cache(mappedStatement.getCache());
        builder.fetchSize(mappedStatement.getFetchSize());
        builder.flushCacheRequired(mappedStatement.isFlushCacheRequired());
        builder.keyGenerator(mappedStatement.getKeyGenerator());
        String[] keyProperties = mappedStatement.getKeyProperties();
        builder.keyProperty(keyProperties[0]);
        builder.resource(mappedStatement.getResource());
        builder.resultMaps(mappedStatement.getResultMaps());
        builder.resultSetType(mappedStatement.getResultSetType());
        builder.statementType(mappedStatement.getStatementType());
        builder.timeout(mappedStatement.getTimeout());
        builder.useCache(mappedStatement.isUseCache());
        return builder.build();
    }
}
