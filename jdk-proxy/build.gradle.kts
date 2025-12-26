plugins {
    id("bytecode-generation-sandbox.core-conventions")
    application
}

application {
    mainClass = "org.example.App"
    applicationDefaultJvmArgs = listOf("-Djdk.proxy.ProxyGenerator.saveGeneratedFiles=true")
}
