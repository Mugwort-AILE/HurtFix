package net.github.mugwort.api.mconfig.builder.utils;
import java.io.File;

public class DataUtils {
    private static final String MainFile = System.getProperty("user.dir");

    public static String getDataFloder() {
        return MainFile + "/" + "config" + "/" + "HurtFix";
    }

}