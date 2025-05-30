
# SpringBootDockerBasic - Complete Setup Guide

### 1. Software Versions
- Java: 21.0.5 (Oracle JDK)
- Spring Boot: 3.5.0
- Gradle: 8.14.1
- Docker: 28.1.1
- OS: Windows + Docker Desktop with WSL2

---

### 2. Create Your Spring Boot Application
- Make sure your main Spring Boot class looks like this:

```java
package com.basic.docker.SpringBootDockerBasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDockerBasicApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from Dockerized Spring Boot!";
    }
}
```

---

### 3. Create `Dockerfile` in Project Root
Add this file named `Dockerfile` (no extension):

```Dockerfile
FROM openjdk:21-jdk-slim
COPY build/libs/SpringBootDockerBasic-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

---

### 4. Build Your Project JAR
Run this command in your project root (where `build.gradle` is):

```
./gradlew clean build
```

Make sure the jar file is created under `build/libs/` folder.

---

### 5. Build Docker Image
In the project root (where `Dockerfile` exists), run:

```
docker build -t springboot-docker-basic .
```

---

### 6. Run Docker Container
Run the container mapping port 8080 of container to your local 8080:

```
docker run -p 8080:8080 springboot-docker-basic
```

---

### 7. Access Application
Open your browser and visit:

```
http://localhost:8080
```

You should see:  
`Hello from Dockerized Spring Boot!`

---

### 8. Stop Running Container
First, get the container ID:

```
docker ps
```

Then stop the container:

```
docker stop <container_id>
```

---

### 9. Docker Login (If Needed)
If you face image pull errors, login to Docker Hub:

```
docker logout
docker login -u <your_username>
```

---

### 10. Important Notes
- Run all Docker commands in your project root folder where Dockerfile is.
- Make sure your jar file name matches what you use in the Dockerfile COPY command.
- Use `docker ps` to check running containers.
- Use `docker logs <container_id>` to see container logs if needed.
- Docker Image = Java Class and It's a blueprint. Contains all dependencies, your app code, configs, etc.
- Docker Container = Java Object - A running instance of an image. You can have multiple containers from the same image: