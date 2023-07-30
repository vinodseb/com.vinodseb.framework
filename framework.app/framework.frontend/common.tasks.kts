tasks.register("npmClean") {
    doFirst {
        exec {
            workingDir("src/main/resources/static")
            executable("npm")
            args("ci")
        }
    }
    doLast {
        exec {
            workingDir("src/main/resources/static")
            executable("npm")
            args("run", "clean")
        }
    }
}

tasks.register("sass") {
    doFirst {
        exec {
            workingDir("src/main/resources/static")
            executable("npm")
            args("ci")
        }
    }
    doLast {
        exec {
            workingDir("src/main/resources/static")
            executable("npm")
            args("run", "sass")
        }
    }
}
