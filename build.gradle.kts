plugins {
    kotlin("jvm") version "2.2.0"
}

group = "top.yunp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.graalvm.polyglot:polyglot:25.0.0")
    implementation("org.graalvm.polyglot:js:25.0.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}