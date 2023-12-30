package net.github.mugwort.api.mconfig;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.github.mugwort.api.mconfig.controller.ConfigCommentController;
import net.github.mugwort.api.mconfig.controller.ConfigValueController;


import java.io.File;
import java.util.ArrayList;

public abstract class ServerConfig {

    private static final ArrayList<FileConfig> configs = new ArrayList<>();
    public static ArrayList<String> getFiles() {
        ArrayList<String> names = new ArrayList<>();
        for (FileConfig config : configs) {
            names.add(config.getFile().getName());
        }
        return names;
    }

    public static ArrayList<String> getYamls() {
        ArrayList<String> names = new ArrayList<>();
        for (FileConfig config : configs) {
            if ("yaml".equals(getExtension(config.getFile()))) {
                names.add(config.getFile().getName());
            }
        }
        return names;
    }

    public static ArrayList<String> getTomls() {
        ArrayList<String> names = new ArrayList<>();
        for (FileConfig config : configs) {
            if ("toml".equals(getExtension(config.getFile()))) {
                names.add(config.getFile().getName());
            }
        }
        return names;
    }

    public static ArrayList<String> getJsons() {
        ArrayList<String> names = new ArrayList<>();
        for (FileConfig config : configs) {
            if ("json".equals(getExtension(config.getFile()))) {
                names.add(config.getFile().getName());
            }
        }
        return names;
    }

    private final FileConfig config;

    public ServerConfig(FileConfig config) {
        this.config = config;
        configs.add(config);
    }

    public ConfigValueController getValue() {
        return new ConfigValueController(config);
    }

    public void addValue(String path, Object value) {
        getValue().addValue(path, value);
    }

    public ConfigCommentController getComments() {
        return new ConfigCommentController(config);
    }

    public void save() {
        if (!config.getFile().exists()) {
            saveDefault();
        }
    }

    public void saveDefault() {
        setConfig();
        config.save();
    }

    @Override
    public String toString() {
        return config.getFile().getName();
    }

    private static String getExtension(File file){
        String extension = "";
        try {
            if (file != null && file.exists()) {
                String name = file.getName();
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        }
        return extension;
    }
    public abstract void setConfig();
}