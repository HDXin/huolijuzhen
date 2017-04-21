package com.sudaotech.image;

import java.io.IOException;
import java.util.List;

import com.sudaotech.core.config.ConfigLoader;


public class ImageConfig {
    /**
     * format: 80x80
     */
    private List<String> imageSizes;
    
    /**
     * 图片压缩质量
     */
    private float imageQuality = 0.6f;

    public static synchronized ImageConfig load() throws IOException {
        return ConfigLoader.loadYamlAs("image.yaml", ImageConfig.class);
    }

    public List<String> getImageSizes() {
        return imageSizes;
    }

    public void setImageSizes(List<String> imageSizes) {
        this.imageSizes = imageSizes;
    }

    public float getImageQuality() {
        return imageQuality;
    }

    public void setImageQuality(float imageQuality) {
        this.imageQuality = imageQuality;
    }
}
