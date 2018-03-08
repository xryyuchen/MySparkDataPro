package com.yc.myprj.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtil {
    private static final Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
    private static InputStream inputStream = null;
    private static Map<String, Map<String, String>> allParam = new HashMap<>();

    public static Properties loadProperty(String filename) {
        inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(filename);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("加载配置文件【" + filename + "】出错", e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.error("配置文件【" + filename + "】,关闭输入流失败", e);
            }
        }
        return properties;
    }

    /**
     * 缓存相关键值对
     *
     * @param fileName
     * @param key
     * @return
     */
    public static String getPropertiesByKey(String fileName, String key) {
        try {
            if (allParam.containsKey(fileName)) {
                return allParam.get(fileName).get(key);
            } else {
                logger.info("开始初始化配置文件【" + fileName + "】");
                Properties p = loadProperty(fileName);

                Set<Entry<Object, Object>> allKey = p.entrySet();
                Map<String, String> fPro = new HashMap<>(p.size());
                for (Entry<Object, Object> entry : allKey) {
                    fPro.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
                allParam.put(fileName, fPro);
                logger.info("成功初始化配置文件【" + fileName + "】");
                return allParam.get(fileName).get(key);
            }
        } catch (Exception e) {
            logger.error("初始化配置文件【" + fileName + "】出错");
            e.printStackTrace();
        }
        return null;
    }
}
