tasks.register("release") {
    val projectName = project.name
    doLast {
        println("This is release of '$projectName'")
    }
}
