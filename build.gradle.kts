import org.panteleyev.jpackage.ImageType

plugins {
    kotlin("jvm") version "2.2.0"
    id("application")
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.panteleyev.jpackageplugin") version "1.7.6"
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