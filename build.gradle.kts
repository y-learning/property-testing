val jvmTargetVersion = "1.8"
val kotestVersion = "4.2.0"

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

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-property-jvm:$kotestVersion")

}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = jvmTargetVersion
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = jvmTargetVersion
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
