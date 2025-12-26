plugins {
    id("bytecode-generation-sandbox.core-conventions")
    application
}

dependencies {
    implementation(libs.javassist)
}

application {
    mainClass = "org.example.App"
    applicationDefaultJvmArgs = listOf("--add-opens", "java.base/java.lang=ALL-UNNAMED")
}
