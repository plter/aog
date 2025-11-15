import org.panteleyev.jpackage.ImageType

plugins {
    id("org.panteleyev.jpackageplugin") version "1.7.6"
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
}

group = "top.yunp"
version = "1.0.0"

application {
    mainClass = "MainKt"
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

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.pebble)
    implementation(libs.ktor.server.websockets)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}
