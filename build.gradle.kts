import org.panteleyev.jpackage.ImageType

plugins {
    kotlin("jvm") version "2.2.0"
    id("application")
    id("org.panteleyev.jpackageplugin") version "1.7.6"
}

group = "top.yunp"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.graalvm.polyglot:polyglot:25.0.0")
    implementation("org.graalvm.polyglot:js:25.0.0")
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("Main")
}

tasks.jpackage {
    dependsOn(tasks.clean, tasks.installDist)
    input.set(projectDir.resolve("build").resolve("install").resolve(project.name).resolve("lib"))
    mainClass.set(application.mainClass.get())
    destination.set(projectDir.resolve("build").resolve("jpackage"))
    appName.set(project.name)
    mainJar.set("${project.name}-${project.version}.jar")
    type.set(ImageType.APP_IMAGE)
}

tasks.test {
    useJUnitPlatform()
}