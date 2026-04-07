# 🏥 Sistema de Gestión de Consultorio Médico

Proyecto backend desarrollado con Spring Boot que permite gestionar pacientes y citas médicas mediante una API REST.

## 📌 Descripción

Este sistema permite registrar, consultar, actualizar y eliminar pacientes, así como gestionar citas médicas asociadas a cada paciente.  
Está diseñado siguiendo una arquitectura por capas (Controller, Service, Repository, Model) aplicando buenas prácticas de desarrollo backend.

---

## ⚙️ Tecnologías utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- MySQL (XAMPP)
- Maven
- Lombok
- JUnit 5 y Mockito
- Git y GitHub

---

## 🧱 Arquitectura del proyecto

El proyecto está organizado en capas:

---

## 🗂️ Funcionalidades principales

### 👤 Paciente
- Listar pacientes
- Buscar paciente por ID
- Registrar paciente
- Actualizar paciente
- Eliminar paciente

### 📅 Cita Médica
- Listar citas
- Buscar cita por ID
- Registrar cita (validando que el paciente exista)
- Actualizar cita
- Eliminar cita

---

## 🗄️ Base de datos

Motor: MySQL (XAMPP)

Base de datos utilizada:

Spring Boot crea automáticamente las tablas al ejecutar el proyecto (`ddl-auto=update`).

---

## 🚀 Ejecución del proyecto

1. Iniciar MySQL desde XAMPP
2. Crear la base de datos:
   ```sql
   CREATE DATABASE consultorio_db;
   spring.datasource.url=jdbc:mysql://localhost:3306/consultorio_db
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true