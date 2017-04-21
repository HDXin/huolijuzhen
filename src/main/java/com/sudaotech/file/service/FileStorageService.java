package com.sudaotech.file.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.sudaotech.core.Session;
import com.sudaotech.core.service.BaseService;

public interface FileStorageService extends BaseService {

    InputStream read(String path) throws IOException;
    
    File getFile(String path);

    String save(String name, InputStream inputStream, Session session) throws IOException;

    /**
     * 保存到指定的路径
     * @param path
     * @param inputStream
     * @param append
     * @param timestamp 
     * @return
     * @throws IOException
     */
    String write(String path, InputStream inputStream, boolean append, boolean timestamp) throws IOException;

    List<String> list(String path, Session session);

}
