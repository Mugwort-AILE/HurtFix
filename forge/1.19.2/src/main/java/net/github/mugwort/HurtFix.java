package net.github.mugwort;


import net.github.mugwort.api.hurtfix.config.ConfigData;
import net.minecraftforge.fml.common.Mod;

@Mod("hurtfix")
public class HurtFix {


    public HurtFix(){
        ConfigData.global.save();
        ConfigData.settings.save();
        ConfigData.overWorld.save();
    }
}
