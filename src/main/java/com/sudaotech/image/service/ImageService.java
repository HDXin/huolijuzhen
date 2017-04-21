package com.sudaotech.image.service;

import java.io.IOException;
import java.io.InputStream;

import com.sudaotech.core.Session;
import com.sudaotech.core.service.BaseService;
import com.sudaotech.image.ImageSize;

public interface ImageService extends BaseService {

    InputStream read(String path) throws IOException;

    String save(String name, InputStream inputStream, Session session) throws IOException;
    
    public String saveToVague(String name, InputStream inputStream, Session session) throws IOException;
    
    ImageSize getImageSize(String imageUri) throws IOException;
    
    String downloadImageFromUri(String imageUri, Session session);

}
