plugins {
    id("bytecode-generation-sandbox.core-conventions")
    application
}

dependencies {
    implementation(libs.spring.core)
}

application {
    mainClass = "org.example.App"
}
