plugins {
    id("bytecode-generation-sandbox.java-conventions")
    application
}

dependencies {
    implementation(libs.asm)
}

application {
    mainClass = "org.example.App"
}
