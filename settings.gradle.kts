plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "jcon-si-structure"
include(
    "library",
    "web-app"
)
rootProject.children.forEach {
    it.projectDir = file("projects/${it.name}")
}