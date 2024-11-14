# Gestion financiera

![Licencia](https://img.shields.io/badge/license-MIT-blue.svg)
![Lenguaje](https://img.shields.io/badge/language-java-yellow.svg)
![Framework](https://img.shields.io/badge/framework-SpringBoot-yellow.svg)

## Descripción

Este proyecto es una aplicación [Consta de dos microservicios (persona, cliente) y (cuenta, movimiento)"]. Fue desarrollada utilizando [Spring Boot con base de datos mysql].



## Tabla de Contenidos

- Crud de personas
- Crud de clientes
- Crud de cuentas
- Crud de movimientos

## Endpoints

- [ ] /cliente GET, POST, PUT, DELETE
- [ ] /persona GET, POST, PUT, DELETE
- [ ] /movimiento GET, POST, PUT, DELETE
- [ ] /reportes GET

## Instalación

Para instalar y ejecutar este proyecto en tu máquina local, sigue estos pasos:

1. Clona este repositorio:

   ```bash
   git clone https://github.com/DiegoMedina04/gestion-financiera.git


2. Se puede levantar en el local entrando al application.properties de los microservicios y colocando la opcion de desarrollo
      ```bash
   spring.profiles.active=prod

2. El proyecto esta dockerizado entonces puede en la raiz principal lanzar el comando docker-compose up -d y modificar la opcion
      ```bash
   spring.profiles.active=dev
3. JSON persona

   ```bash
    {
        "nombre": "Persona 1",
        "genero": "Masculino",
        "edad": 30,
        "identificacion": 123456789,
        "telefono": 987654321,
        "direccion": "Calle Falsa 123, Ciudad X"
    }

4. JSON cliente

   ```bash
    {
        "contrasena": "*********",
        "estado": true,
            "persona":{
                "id":1
            }
    }
5. JSON cuenta

   ```bash
    {
        "numeroCuenta": 1234567890,
        "tipoCuenta": "persona 2",
        "saldoInicial": 5000.00,
        "estado": true,
        "clienteId": 1
    }

6. JSON movimiento

   ```bash
    {
        "fecha": "2024-11-13T10:00:00Z",
        "tipoMovimiento": "persona 1 segundo movimiento",
        "valor": 100.00,
        "cuenta": {
            "id": 1
        }
    }

7. reportes
   ```bash
    /reportes?rangoFechaInicio=2024-11-01&rangoFechaFin=2024-11-30&clienteId=1