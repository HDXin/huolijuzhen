package com.sudaotech.core.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.util.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.sudaotech.util.BeanUtils;

public abstract class ConfigLoader {
    private final static Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    private static final Yaml yaml = new Yaml();
    private static final Map<String, String> envProperties = new EnvConfigLoader().getProperties();
    
    /**
     * 通过指定路径名加载配置，支持通过环境变量（-D{pathname}={/path/to/file}）加载外部配置来覆盖全部或部分默认配置项。
     * @param pathname
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T loadYamlAs(String pathname, Class<T> clazz) {
        T obj = yaml.loadAs(ConfigLoader.load(pathname), clazz);
        
        String extFile = System.getProperty(pathname);
        if (!StringUtils.isBlank(extFile)) {
            logger.info("System property found: {}={}", pathname, extFile);
            T obj1 = yaml.loadAs(ConfigLoader.load(extFile), clazz);
            BeanUtils.copyProperties(obj1, obj, true);
        }
        
        return obj;
    }
    
    private static InputStream load(String path) {
        logger.debug("Loading config: {}", path);

        try {
            // try to load absolute file
            File file = new File(path);
            if (file.isFile()) {
                logger.info("Loaded config: {}", file.getAbsolutePath());
                return new FileInputStream(file);
            }
            
            // load from class path
            URL url = Loader.getResource(path, ConfigLoader.class.getClassLoader());
            if (url == null) {
                throw new FileNotFoundException("Not found file: " + path);
            }
            
            logger.info("Loaded config: {}", url.getPath());
            
            return url.openStream();
        } catch (Exception e) {
            throw new ConfigLoadException(e.getMessage(), e);
        }
    }
    
    /**
     * 获取环境相关变量配置
     * @return
     */
    public static Map<String, String> loadEnvConfig() {
        return envProperties;
    }
    
    private static final class EnvConfigLoader {
        private final Map<String, String> envProperties;

        public EnvConfigLoader() {
            try {
                Map<String, String> properties = loadConfig(getDefaultConfigFile());
                // 加载环境配置
                properties.putAll(loadConfig(getEnvConfigFile()));
                // 加载外部配置
                String extConfigFile = this.getExtConfigFile();
                if (extConfigFile != null) {
                    properties.putAll(loadConfig(extConfigFile));
                }
                envProperties = Collections.unmodifiableMap(properties);
                logger.info("Loaded environment config: {}", properties);
            } catch (IOException e) {
                throw new RuntimeException("Error loading environment config: " + e.getMessage(), e);
            }
        }

        public Map<String, String> getProperties() {
            return envProperties;
        }

        private Map<String, String> loadConfig(String path) throws IOException {
            Map<?, ?> map = yaml.loadAs(ConfigLoader.load(path), HashMap.class);
            Map<String, String> properties = new HashMap<String, String>();
            if (map != null) {
                for (Entry<?, ?> entry : map.entrySet()) {
                    properties.put(entry.getKey().toString(), entry.getValue().toString());
                }
            }
            return properties;
        }

        private String getDefaultConfigFile() {
            return "env/default.yaml";
        }

        private String getEnvConfigFile() {
            String env = System.getProperty("env");
            logger.info("System property: env={}", env);

            Type type = env == null ? Type.LOCAL : Type.valueOf(env.toUpperCase());
            
            return "env/" + type.value + ".yaml";
        }

        private String getExtConfigFile() {
            String envConfigFile = System.getProperty("env.configFile");
            logger.info("System property: env.configFile={}", envConfigFile);
            return envConfigFile;
        }

    }

    public static enum Type {
        LOCAL("local"), DEV("dev"), QA("qa"), STAGING("staging"), PROD("prod");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

}
