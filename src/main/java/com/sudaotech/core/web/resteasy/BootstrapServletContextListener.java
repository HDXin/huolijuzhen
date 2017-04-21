package com.sudaotech.core.web.resteasy;

import java.util.Map;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.sudaotech.core.service.BaseService;

public class BootstrapServletContextListener extends GuiceResteasyBootstrapServletContextListener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    protected void withInjector(final Injector injector) {
        super.withInjector(injector);
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startService(injector);
            }
        };
        new Thread(runnable).start();
    }

    private void startService(Injector injector) {
        Map<Key<?>, Binding<?>> allBindings = injector.getBindings();
        for (Binding<?> binding : allBindings.values()) {
            Object x = binding.getProvider().get();
            if (x instanceof BaseService) {
                try {
                    ((BaseService) x).init();
                } catch (Exception e) {
                    this.logger.error("service init error", e);
                }
            }
        }
    }
}
