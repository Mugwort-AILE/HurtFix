plugins {
    java
    id("idea")
}

idea{
    module {
        excludeDirs = setOf(file(".gradle")) + listOf("artifacts").map { file(it) }
    }
}

subprojects {
    apply(plugin = "maven-publish")
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://repo.huaweicloud.com/repository/maven/")
        maven("https://jitpack.io")
    }
    tasks.withType<JavaCompile> {
         options.encoding = "UTF-8"
    }
    group = "com.github.mugwort"
    version = "3.0-DEV"
}

@Suppress("DEPRECATION") gradle.buildFinished { buildDir.deleteRecursively() }