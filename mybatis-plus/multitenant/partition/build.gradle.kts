plugins {
    id("java")
}

group = "org.example"
version = "1.0.0-SNAPSHOT"

dependencies {
    implementation("com.baomidou:mybatis-plus-spring-boot3-starter:3.5.5")
    runtimeOnly("com.h2database:h2")
}

tasks.test {
    useJUnitPlatform()
}
