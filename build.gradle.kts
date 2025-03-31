plugins {
    id("java")
}

group = "me.itzisonn_.registry"
version = "1.0"
description = "RegistryLib"
java.sourceCompatibility = JavaVersion.VERSION_21

val lombokVersion = "1.18.36"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
}