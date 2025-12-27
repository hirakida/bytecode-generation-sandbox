plugins {
    id("bytecode-generation-sandbox.core-conventions")
    application
}

dependencies {
    implementation(libs.asm)
}

application {
    mainClass = "org.example.App"
}
