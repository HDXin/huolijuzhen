package com.sudaotech.event.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.event.EventConfig;
import com.sudaotech.event.NotifyEvent;
import com.sudaotech.event.NotifyEventListener;
import com.sudaotech.redis.service.RedisService;
import com.sudaotech.util.JsonUtil;

public class NotifyServiceAsyncImpl extends BaseServiceImpl implements NotifyService {
    private static final String NOTIFY_EVENT = "NotifyEvent";

    public static class NotifyEventWrapper {
        private Class<?> type;
        private String data;
        
        public NotifyEventWrapper() {
        }
        public NotifyEventWrapper(NotifyEvent event) {
            this(event.getClass(), JsonUtil.toJson(event));
        }
        public NotifyEventWrapper(Class<?> type, String data) {
            super();
            this.type = type;
            this.data = data;
        }
        public Class<?> getType() {
            return type;
        }
        public void setType(Class<?> type) {
            this.type = type;
        }
        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
    }
    
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
    
    private final AtomicBoolean started = new AtomicBoolean(false);  
    
    private final Injector injector;
    private final RedisService redisService;
    private final EventConfig eventConfig = EventConfig.getInstance();
    
    @Inject
    public NotifyServiceAsyncImpl(RedisService redisService, Injector injector) {
        this.redisService = redisService;
        this.injector = injector;

        this.startNotifyListeners();
    }
    
    @Override
    public void dispatch(final NotifyEvent event) {
        Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    String json = JsonUtil.toJson(new NotifyEventWrapper(event));
                    redisService.rpush(NOTIFY_EVENT, json);
                } catch (Exception e) {
                    NotifyServiceAsyncImpl.this.logger.info("dispatch event error", e);
                }
            }
        };
        // 延迟 500ms
        scheduler.schedule(command, 500, TimeUnit.MILLISECONDS);
    }

    private void startNotifyListeners() {
        if (!eventConfig.isNotifyListenersEnabled()) {
            this.logger.warn("NotifyListeners disabled");
            return;
        }
        
        this.logger.info("Start listening on NotifyEvent");
        if (started.getAndSet(true)) {
            this.logger.warn("NotifyListeners already started");
            return;
        }
        
        List<String> list = this.eventConfig.getNotifyListeners();
        final List<NotifyEventListener> listeners = new ArrayList<NotifyEventListener>(list.size());
        for (String className : list) {
            try {
                Object instance = injector.getInstance(Class.forName(className));
                listeners.add((NotifyEventListener) instance);
            } catch (Exception e) {
                this.logger.error("Failed to load NotifyEventListener: {}", className, e);
            }
        }
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // blocking for receiving notify event
                    NotifyEvent notifyEvent = null;
                    try {
                        Map<String, String> map = redisService.blpop(NOTIFY_EVENT);
                        logger.info("Received event: {}", map);
                        
                        String data = map.get(NOTIFY_EVENT);
                        NotifyEventWrapper notifyEventData = JsonUtil.fromJson(data, NotifyEventWrapper.class);
                        notifyEvent = (NotifyEvent)JsonUtil.fromJson(notifyEventData.getData(), notifyEventData.getType());
                    } catch (Exception e) {
                        logger.error("Exception occured when waiting for notify event: {}", e.getMessage(), e);
                        continue;
                    }
                    
                    // notify the listeners
                    for (NotifyEventListener listener : listeners) {
                        try {
                            listener.onReceive(notifyEvent);
                        } catch (Exception e) {
                            logger.error("{}#onReceive error for notify event: {}", listener, e.getMessage(), e);        
                        }
                    }
                }
            }
        };
        
        new Thread(runnable).start();
    }
}
