plugins {
    id("bytecode-generation-sandbox.java-conventions")
    application
}

application {
    mainClass = "org.example.App"
    applicationDefaultJvmArgs = listOf("-Djdk.proxy.ProxyGenerator.saveGeneratedFiles=true")
}
