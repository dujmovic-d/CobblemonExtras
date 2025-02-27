plugins {
    id("java")
    id("dev.architectury.loom") version("1.3-SNAPSHOT")
    id("architectury-plugin") version("3.4-SNAPSHOT")
    kotlin("jvm") version ("1.7.10")
}

group = "dev.chasem.cobblemonextras"
version = "${project.property("mod_version")}+${project.property("mc_version")}"

val isSnapshot = project.property("snapshot")?.equals("true") ?: false
if (isSnapshot) {
    version = "$version-SNAPSHOT"
}
architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
    silentMojangMappingsLicense()

    mixin {
        defaultRefmapName.set("mixins.${project.name}.refmap.json")
    }
}
repositories {
    mavenCentral()
    maven("https://maven.impactdev.net/repository/development/")
}
dependencies {
    minecraft("com.mojang:minecraft:1.20.1")
    mappings("net.fabricmc:yarn:1.20.1+build.10")
    modImplementation("net.fabricmc:fabric-loader:0.14.22")

    modImplementation("ca.landonjw.gooeylibs:api:3.0.0-1.20.1-SNAPSHOT")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.88.1+1.20.1")
    modImplementation("com.cobblemon:fabric:1.4.0+1.20.1")


    modImplementation(fileTree("libs"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    //shadowCommon group: 'commons-io', name: 'commons-io', version: '2.6'


    compileOnly("net.luckperms:api:${rootProject.property("luckperms_version")}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}