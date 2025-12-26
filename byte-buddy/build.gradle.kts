plugins {
    id("bytecode-generation-sandbox.core-conventions")
    application
}

dependencies {
    implementation(libs.byte.buddy)
}

application {
    mainClass = "org.example.App"
}
