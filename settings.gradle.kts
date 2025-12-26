plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "bytecode-generation-sandbox"

include("byte-buddy")
include("javassist")
include("jdk-proxy")
include("spring-cglib")
