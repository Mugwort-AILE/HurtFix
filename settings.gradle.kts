apply("forge")
apply("fabric")
apply("api")


val rootGroup = "com.github.mugwort"
val rootVersion = "3.0-DEV"


pluginManagement{
    repositories {
        gradlePluginPortal()
        maven ("https://maven.fabricmc.net/")

        maven("https://maven.minecraftforge.net/")
    }
}

fun apply(name: String) {
    File(rootDir, name).listFiles()?.filter { it.isDirectory }?.forEach {
        include("$name:${it.name}")
    }
}