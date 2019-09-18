import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50" apply false
    id("org.springframework.boot") version "2.1.8.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

allprojects {
    repositories {
        mavenCentral()
    }
    group = "by.dvaradkin.lenta"
    version = "1.0-SNAPSHOT"
}

val springBasedModules = listOf("lenta-web", "lenta-data")
configure(allprojects.filter { it.name in springBasedModules }) {
    apply(plugin = "io.spring.dependency-management")
    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.1.8.RELEASE")
        }
    }
}
