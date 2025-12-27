plugins {
    id("bytecode-generation-sandbox.java-conventions")
    application
}

dependencies {
    implementation(libs.byte.buddy)
}

application {
    mainClass = "org.example.App"
}
