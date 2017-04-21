package com.sudaotech.core;

import java.util.List;


public interface Session {

	Long getCompanyId();

    Long getUserId();

    Long getUserType();
    
    Long getPlatformId();   
    
    Integer getPlatformSource();  

    List<String> getPermissions();
}
