package com.sudaotech.core.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sudaotech.core.Session;
import com.sudaotech.core.SessionAware;
import com.sudaotech.core.annotation.RequirePermission;
import com.sudaotech.core.annotation.RequirePolicy;
import com.sudaotech.exception.PermissionException;

public class RequirePermissionInterceptor implements MethodInterceptor {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        RequirePermission requirePermission = method.getAnnotation(RequirePermission.class);
        
        String[] required = requirePermission.value();
        RequirePolicy policy = requirePermission.policy();

        // no authorization required
        if (ArrayUtils.isEmpty(required)) {
            return invocation.proceed();
        }
        
        Session session = null;
        Object this1 = invocation.getThis();
        if (this1 instanceof SessionAware) {
            session = ((SessionAware) this1).getSession();
        } else {
            for (Object obj : invocation.getArguments()) {
                if (obj instanceof Session) {
                    session = (Session) obj;
                    break;
                }
            }
        }

        List<String> having = session == null ? null : session.getPermissions();
        
        if (!CollectionUtils.isEmpty(having)) {
            int n = required.length;
            for (String a : required) {
                for (String b : having) {
                	if (StringUtils.equals(a,b)) {
                        --n;
                        break; // break having
                    }
                	// * 表示管理员角色
                	if (StringUtils.endsWith(b, "::*")) {
                		// 验证是否同一个模块, 如:MANUFACTURE::
                		if(StringUtils.startsWith(a, b.substring(0,b.length() - 1))) {
                			--n;
                            break; // break having
                		}
                	}
                }
            }

            if ((policy == RequirePolicy.ALL && n == 0) 
                    || (policy == RequirePolicy.ANY && n < required.length)) {
                return invocation.proceed();
            }

            
        }
        throw new PermissionException("Required: " + ArrayUtils.toString(required) + ", but: " + ArrayUtils.toString(having));
    }
    
}
