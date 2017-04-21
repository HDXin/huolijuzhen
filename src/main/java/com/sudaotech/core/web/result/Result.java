package com.sudaotech.core.web.result;

import org.codehaus.jackson.map.annotate.JsonSerialize;


public class Result<T> {
    private String code;
    private String message;

    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL) 
    private T data;

    /**
     * Only used when 202 Created
     */
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL) 
    private String location;


    public Result(String code, String message) {
        this(code, message, null);
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultCode resultCode) {
        this(resultCode, null);
    }

    public Result(ResultCode resultCode, T data) {
        this(resultCode.getCode(), resultCode.getMessage(), data);
    }
    
    public void setResult(String code, String message){
    	this.code = code;
    	this.message = message;
    }
    
    public void setResult(ResultCode resultCode){
    	this.code = resultCode.getCode();
    	this.message = resultCode.getMessage();
    }
    public void setResult(ResultCode resultCode, T data){
    	this.code = resultCode.getCode();
    	this.message = resultCode.getMessage();
    	this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
