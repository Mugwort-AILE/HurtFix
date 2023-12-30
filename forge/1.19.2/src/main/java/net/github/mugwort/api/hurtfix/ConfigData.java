package net.github.mugwort.api.hurtfix;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.github.mugwort.api.mconfig.ServerConfig;
import net.github.mugwort.api.mconfig.builder.ServerConfigBuilder;
import net.github.mugwort.api.mconfig.builder.tools.ConfigType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigData {
    public static final ServerConfig settings = new ServerConfigBuilder("settings", ConfigType.TOML)
            .define("setting.AllowAbsorption",true)
            .comment("setting.AllowAbsorption","Whether or not to allow damage absorption to block true damage").build();
    public static final ServerConfig global = new ServerConfigBuilder("global", ConfigType.TOML)
            .define("global.playedDays",0)
            .comment("global.playedDays","Played Days")
            .define("global.magnification",50)
            .comment("global.magnification","Global magnification 0 ~ 100")
            .define("global.whiteList", new ArrayList<String>())
            .comment("global.whiteList","Global whitelist is added by entering the ID").build();
    public static final ServerConfig overWorld = new ServerConfigBuilder("/worlds/overworld", ConfigType.TOML)
            .define("WorldSettings.world","minecraft:overworld")
            .define("WorldSettings.magnification",true)
            .define("WorldSettings.whileList",new ArrayList<String>())
            .comment("WorldSettings.magnification","magnification 0 ~ 100")
            .comment("WorldSettings.whiteList","WhiteList")
            .build();




    public static Map<String,WorldSettings> config = new HashMap<>();

    public static ServerConfig FileAsConfig(File file){
        return new ServerConfig(FileConfig.builder(file).build()) {
            @Override
            public void setConfig() {

            }
        };
    }
    public static void getFiles(File file){
        File[] files = file.listFiles();
        if (files != null) {
            for (File _file : files) {
                if (file.isDirectory()) {
                    getFiles(new File(_file.getAbsolutePath()));
                }else {
                    var config_ = FileAsConfig(_file);
                    var world = config_.getValue().getString("WorldSettings.world");
                    var multi = config_.getValue().getDouble("WorldSettings.magnification");
                    var whiteList = config_.getValue().<String>getList("global.whiteList");
                    ConfigData.config.put(world, new WorldSettings(world,multi,whiteList));
                }
            }
        }
    }
}
