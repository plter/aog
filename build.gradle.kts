import org.panteleyev.jpackage.ImageType

val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.2.0"
    id("application")
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.panteleyev.jpackageplugin") version "1.7.6"
    id("io.ktor.plugin") version "3.2.3"
}

group = "top.yunp"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.graalvm.polyglot:polyglot:24.2.2")
    implementation("org.graalvm.polyglot:js:24.2.2")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-websockets")
    implementation("io.ktor:ktor-server-host-common")
    implementation("io.ktor:ktor-server-netty")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("MainKt")
}

tasks.jpackage {
    dependsOn(tasks.clean, tasks.installDist)
    input.set(projectDir.resolve("build").resolve("install").resolve(project.name).resolve("lib"))
    mainClass.set(application.mainClass.get())
    destination.set(projectDir.resolve("build").resolve("jpackage"))
    appName.set(project.name)
    mainJar.set(tasks.jar.get().archiveFileName.get())
    type.set(ImageType.APP_IMAGE)

    windows {
        winConsole.set(true)
    }
}

tasks.test {
    useJUnitPlatform()
}