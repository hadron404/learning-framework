plugins {
    id("java")
}

group = "org.example"
version = "1.0.0-SNAPSHOT"

dependencies {
}

tasks.test {
    useJUnitPlatform()
}
