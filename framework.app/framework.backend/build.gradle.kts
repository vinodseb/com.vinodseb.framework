dependencies {
    // Ktor server dependencies
    implementation("io.ktor:ktor-server-swagger:$ktor_version")
}

application {
    mainClass.set("com.vinodseb.framework.ApplicationKt")
}
