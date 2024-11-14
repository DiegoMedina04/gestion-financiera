# Etapa de construcción
FROM maven:3.8.5-openjdk-17 AS build

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el pom.xml y descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Empaquetar la aplicación
RUN mvn clean package -DskipTests

# Etapa final
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar el JAR de la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Puerto que expone Spring Boot por defecto
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]