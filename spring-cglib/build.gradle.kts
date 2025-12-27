plugins {
    id("bytecode-generation-sandbox.java-conventions")
    application
}

dependencies {
    implementation(libs.spring.core)
}

application {
    mainClass = "org.example.App"
}
