package com.sudaotech.image.compressor;

import java.io.File;
import java.io.IOException;

import com.sudaotech.image.ImageSize;

public interface ImageCompressor {

	public abstract void compressImageToVague(File srcFile, File targetFile) throws IOException;
	
    public abstract void compressImage(File srcFile, File targetFile, ImageSize imageSize) throws IOException;
    
    public abstract void compressImage(File srcFile, File targetFile) throws IOException;

}