import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.4.0"
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

group = "pl.funnyskaddon"
version = "2.2.0"

tasks.withType<ShadowJar> {
    classifier = ""

    relocate("org.bstats.bukkit", "pl.funnyskaddon.bstats")
    relocate("kotlin", "pl.funnyskaddon.libs.kotlin")
    relocate("org.intellij", "pl.funnyskaddon.libs.intellij")
    relocate("org.jetbrains", "pl.funnyskaddon.libs.jetbrains")
    relocate("eu.okaeri", "pl.funnyskaddon.libs.okaeri")
}

repositories {
    jcenter()
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/" )
    maven("https://oss.sonatype.org/content/repositories/snapshots/" )
    maven("https://repo.panda-lang.org/")
    maven("https://jitpack.io")
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://storehouse.okaeri.eu/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.bstats:bstats-bukkit:1.8")
    implementation("eu.okaeri:okaeri-configs-yaml-bukkit:2.5.2")
    compileOnly("commons-io:commons-io:2.8.0")
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    compileOnly("net.dzikoysk:funnyguilds:4.9.4")
    compileOnly("com.github.SkriptLang:Skript:2.4.1")
}
