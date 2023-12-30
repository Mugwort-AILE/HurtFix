package net.github.mugwort;


import net.github.mugwort.api.hurtfix.ConfigData;
import net.github.mugwort.api.hurtfix.Range;
import net.github.mugwort.api.mconfig.ServerConfig;
import net.github.mugwort.api.mconfig.builder.ServerConfigBuilder;
import net.github.mugwort.api.mconfig.builder.tools.ConfigType;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod("hurtfix")
public class HurtFix {


    public HurtFix(){
        ConfigData.global.save();
        ConfigData.settings.save();
        ConfigData.overWorld.save();
    }
}
