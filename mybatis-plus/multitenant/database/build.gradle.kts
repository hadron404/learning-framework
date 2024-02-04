plugins {
    id("java")
    id("org.springframework.boot") version ("3.2.2")
    id("io.spring.dependency-management") version ("1.1.4")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

group = "org.example"
version = "1.0.0-SNAPSHOT"

dependencies {
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("com.baomidou:mybatis-plus-spring-boot3-starter:3.5.5")
}

tasks.test {
    useJUnitPlatform()
}
