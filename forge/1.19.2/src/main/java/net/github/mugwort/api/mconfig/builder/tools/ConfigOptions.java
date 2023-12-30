package net.github.mugwort.api.mconfig.builder.tools;

public class ConfigOptions {
    private boolean autoReload = false;
    private boolean autoSave = false;

    public boolean isAutoReload() {
        return autoReload;
    }

    public boolean isAutoSave() {
        return autoSave;
    }

    public void setAutoReload(boolean autoReload) {
        this.autoReload = autoReload;
    }

    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }
}