val jvmTargetVersion = "1.8"

plugins {
    kotlin("jvm") version "1.4.0"
}

group = "me.why"

version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = jvmTargetVersion
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = jvmTargetVersion
    }
}