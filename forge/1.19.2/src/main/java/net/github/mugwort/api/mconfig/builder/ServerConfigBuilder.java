package net.github.mugwort.api.mconfig.builder;

import com.electronwill.nightconfig.core.file.FileConfig;
import com.electronwill.nightconfig.core.file.FileConfigBuilder;
import net.github.mugwort.api.mconfig.ServerConfig;
import net.github.mugwort.api.mconfig.builder.tools.ConfigOptions;
import net.github.mugwort.api.mconfig.builder.tools.ConfigType;
import net.github.mugwort.api.mconfig.builder.utils.DataUtils;


import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ServerConfigBuilder {

    private final String id;
    private final ConfigType type;
    private ConfigOptions options;
    private final Map<String, Object> defines;
    private final Map<String, Object> comments;

    public ServerConfigBuilder(String id, ConfigType type) {
        this.id = id;
        this.type = type;
        this.options = new ConfigOptions();
        this.defines = new HashMap<>();
        this.comments = new HashMap<>();
    }




    public ServerConfigBuilder define(String key, Object value) {
        defines.put(key, value);
        return this;
    }

    public ServerConfigBuilder comment(String path, String comment) {
        comments.put(path, comment);
        return this;
    }

    public ServerConfig build() {
        File file =  new File(DataUtils.getDataFloder() + "/" + id + type.getExtension());
        FileConfigBuilder builder = FileConfig.builder(file);
        if (options.isAutoSave()) {
            builder.autosave();
        }
        if (options.isAutoReload()) {
            builder.autoreload();
        }
        FileConfig config = builder.build();
        ServerConfig ret = new ServerConfig(config) {
            @Override
            public void setConfig() {
                defines.forEach(this::addValue);
                comments.forEach((key, value) -> getComments().addComment(key, value));
            }
        };
        ret.save();
        return ret;
    }

    public ServerConfigBuilder options(ConfigOptions options) {
        this.options = options;
        return this;
    }
}