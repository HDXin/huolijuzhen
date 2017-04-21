package com.sudaotech.event;

import java.util.List;

import com.sudaotech.core.config.ConfigLoader;

public class EventConfig {
    private static final EventConfig instance = ConfigLoader.loadYamlAs("event.yaml", EventConfig.class);

    private boolean notifyListenersEnabled;
    private List<String> notifyListeners;
    private List<String> timerTasks;

    public static EventConfig getInstance() {
        return instance;
    }
    
    public boolean isNotifyListenersEnabled() {
        return notifyListenersEnabled;
    }

    public void setNotifyListenersEnabled(boolean notifyListenersEnabled) {
        this.notifyListenersEnabled = notifyListenersEnabled;
    }

    public List<String> getNotifyListeners() {
        return notifyListeners;
    }

    public void setNotifyListeners(List<String> notifyListeners) {
        this.notifyListeners = notifyListeners;
    }

	public List<String> getTimerTasks() {
		return timerTasks;
	}

	public void setTimerTasks(List<String> timerTasks) {
		this.timerTasks = timerTasks;
	}
}
