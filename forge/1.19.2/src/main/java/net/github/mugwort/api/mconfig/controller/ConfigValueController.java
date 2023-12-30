package net.github.mugwort.api.mconfig.controller;
import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.core.file.FileConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigValueController {

    private final FileConfig config;

    public ConfigValueController(FileConfig config) {
        this.config = config;
    }

    public Map<String, Object> getKeys(String path) {
        Map<String, Object> map = new HashMap<>();
        config.load();
        Config configValue = config.get(path);
        if (configValue instanceof Map<?, ?>) {
            ((Map<?, ?>) configValue).forEach((key, value) -> {
                if (value instanceof Config) {
                    map.putAll(getKeys(path + "." + key));
                } else {
                    map.put(path + "." + key, value);
                }
            });
        }
        config.close();
        return map;
    }

    public String getString(String path) {
        return config.get(path);
    }

    public Boolean getBoolean(String path) {
        return config.get(path);
    }

    public Integer getInt(String path) {
        return config.get(path);
    }
    public Double getDouble(String path) {
        return config.get(path);
    }

    public <T> ArrayList<T> getList(String path) {
        return config.get(path);
    }

    public <T> T get(String path) {
        config.load();
        T result = config.get(path);
        config.close();
        return result;
    }

    public void addValue(String path, Object value) {
        config.add(path, value);
    }

    public <T> void setValue(String path, T value) {
        config.set(path, value);
        config.save();
    }

    public void removeValue(String path) {
        config.load();
        config.remove(path);
        config.save();
    }
}