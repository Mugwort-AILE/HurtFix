package net.github.mugwort.api.mconfig.builder.tools;

public enum ConfigType {
    YAML(".yaml"),
    JSON(".json"),
    TOML(".toml");

    private final String extension;

    ConfigType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
