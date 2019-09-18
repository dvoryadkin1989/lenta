import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    java
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "by.dvaradkin.lenta.web.MainKt"
    }
}

tasks.register<JavaExec>("run-server") {
    group = "run"
    description = "Run server-side application"

    main = "-jar"
    val jarFilePath = tasks.jar.get().archiveFile.get().asFile.absolutePath
    args = listOf(jarFilePath)
    dependsOn(tasks.build.get())
}