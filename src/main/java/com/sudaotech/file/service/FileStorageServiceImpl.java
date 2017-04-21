package com.sudaotech.file.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sudaotech.core.Session;
import com.sudaotech.core.service.BaseServiceImpl;

public class FileStorageServiceImpl extends BaseServiceImpl implements FileStorageService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private File root;
    private File named;

    @Inject
    public void setServers(@Named("filestorage.root") String root) {
        this.root = new File(root);
        this.named = new File(this.root, "named");
    }

    @Override
    public InputStream read(String path) throws IOException {
        File file = new File(this.root, path);
        if (file.isFile() && file.canRead()) {
            return new FileInputStream(file);
        }
        return null;
    }

    @Override
    public String save(String name, InputStream inputStream, Session session) throws IOException {
        String path = buildPath(name, session);
        File file = new File(this.root, path);
        file.getParentFile().mkdirs();
        OutputStream output = new FileOutputStream(file);
        IOUtils.copy(inputStream, output);
        IOUtils.closeQuietly(output);
        
        logger.info("Saved file: {}", file.getAbsolutePath());
        
        return path;
    }

    private String buildPath(String name, Session session) {
        String suffix = "";
        final Date date = new Date();
        if (name != null) {
            int i = name.lastIndexOf('.');
            if (i >= 0) {
                suffix = name.substring(i);
            }
        }

        Long userId = null;
        if (session != null) {
            userId = session.getUserId();
        }
        SimpleDateFormat format = new SimpleDateFormat("/yyyyMM/ddHH/mmss/");
        return "/" + userId.toString() + format.format(date) + UUID.randomUUID().toString() + suffix;
    }

    @Override
    public List<String> list(String path, Session session) {
        if (!path.endsWith("/")) {
            path += "/";
        }

        File dir = new File(this.root, path);
        if (dir.isDirectory()) {
            List<String> list = new ArrayList<String>();
            for (String s : dir.list()) {
                list.add(path + s);
            }
            return list;
        }

        return Collections.emptyList();
    }

    @Override
    public String write(String path, InputStream inputStream, boolean append, boolean timestamp) throws IOException {
        File file = new File(this.named, path);
        file.getParentFile().mkdirs();
        OutputStream output = null;
        try {
            output = new FileOutputStream(file, append);
            // 若需要时间戳
            if (timestamp) {
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                IOUtils.write("# " + date + "\n", output); //时间戳
            }
            IOUtils.copy(inputStream, output);
            IOUtils.write("\n", output); //换行符
        } finally {
            IOUtils.closeQuietly(output);
        }
        
        logger.info("{} file: {}", append? "append" : "override", file);
        
        return path;
    }

    @Override
    public File getFile(String path) {
        File file = new File(this.root, path);
        return file;
    }

}
