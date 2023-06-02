plugins {
    id("jcon.app-conventions")
}

dependencies {
    implementation(project(":library"))
    implementation(libs.groovy.nio)
    implementation(libs.groovy.json)
    implementation(libs.commons.lang3)
}

println("Groovy version is ${libs.versions.groovy.get()}")
