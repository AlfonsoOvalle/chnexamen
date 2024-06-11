# Detalles Proyecto CHN

> __Script de la Base de datos__
```sql
CREATE DATABASE IF NOT EXISTS DBCHN;

use DBCHN

CREATE TABLE IF NOT EXISTS cliente  (
  id_cliente int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  apellido varchar(50) NOT NULL,
  correo_electronico varchar(50) NOT NULL,
  direccion varchar(50) NOT NULL,
  estado varchar(255) NOT NULL,
  fecha_nacimiento date NOT NULL,
  nombre varchar(50) NOT NULL,
  numero_identificacion varchar(50) NOT NULL,
  telefono int NOT NULL
)

CREATE TABLE IF NOT EXISTS cuenta (
    id_cuenta int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    tipo_cuenta VARCHAR(10) NOT NULL,
    monto_apertura INT NOT NULL,
    saldo INT NOT NULL,
    estado VARCHAR(10) NOT NULL,
    cantidad_cheques INT DEFAULT NULL,
	  id_cliente INT NOT NULL    
)

CREATE TABLE IF NOT EXISTS cheque (
    id_cheque int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    estado VARCHAR(10) NOT NULL,
    motivo VARCHAR(10) NOT NULL,
    monto_pagado INT NOT NULL,
    fecha DATE NOT NULL,
    id_cuenta INT NOT NULL    
)

ALTER TABLE cuenta
ADD CONSTRAINT FK_cuenta_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente);

ALTER TABLE cheque
ADD CONSTRAINT FK_cuenta_cheque FOREIGN KEY (id_cuenta) REFERENCES cuenta(id_cuenta);
```

>__Diagrama Entidad Relacion__
>
![Logotipo de Google](https://www.4shared.com/img/0Wx3GwDxge/s25/1900341f2a0/ER_online)

>__Manual de Usuario__
```sh
Modulo de Clientes
En esta sección se tiene la creación de clientes, activación o inactivación y su edición 
```
>
![Logotipo de Google](https://www.4shared.com/img/9pkZpsmtjq/s25/1900352ea60/Modulo_de_Clientes)
![Logotipo de Google](https://www.4shared.com/img/KC19d9oafa/s25/1900352ea60/Modulo_de_Clientes_Nuevo)
![Logotipo de Google](https://www.4shared.com/img/-XovyZuLjq/s25/1900352e678/Modulo_de_Clientes_Inactivar)
```sh
Modulo de Cuentas
En este módulo se listan todas las cuentas para cada cliente y su respectiva solicitud de apertura de cuentas así como la activación o inactivación de alguna cuenta.
```
>
![Logotipo de Google](https://www.4shared.com/img/TJOT05Amge/s25/1900352ee48/Modulo_de_Cuentas_Solicitud)
![Logotipo de Google](https://www.4shared.com/img/yV-OxVjLfa/s25/1900352ee48/Modulo_de_Cuentas_Inactivar)

```sh
Modulo de Manejo de Cheques
En este módulo se listan los movimientos de saldos y pago de cheques que se realizan a cada cliente, así como el manejo de movimientos de las cuentas y chequeras.
```
![Logotipo de Google](https://www.4shared.com/img/i8GY7lmUku/s25/1900352f230/Modulo_de_Manejo_Chequeras)
![Logotipo de Google](https://www.4shared.com/img/vr6gqortfa/s25/1900352ee48/Modulo_de_Manejo_Chequeras_Mov)

# Despliegue Proyecto CHN
```sh

El proyecto se compone de 3 contenedores en los cuales se dividen de la siguiente forma
Contenedor1:  frontEnd(React js)
Contenedor2:  backEnd(Java Spring boot)
Contenedor3:  base de datos(Mysql)

```
#### Pasos para levantar los servicios y la aplicación

1. Clonar el repositorio:

   ```console
   $ git clone https://github.com/AlfonsoOvalle/chnexamen.git
   ```

2. Posicionarse en la carpeta raíz del proyecto y abrir una terminal:

   ```console
   $ cd <ruta raiz proyecto> 
   ```

3. En la carpeta raiz localizar el siguiente archivo:

   ```console
   docker-compose.yml
   ```

4. Ejecutar el siguiente comando para levantar los diferentes servicios:

   ```console
   $ docker-compose up -d
   ```
   Este comando puede demorar algunos minutos, esperar a que se aprovicionen los contenedores y verificar su estado
   
5. Verificar que los contenedores esten funcionando:

   ```console
   $ docker ps --format "table {{.Ports}}\\t{{.Image}}\\t{{.Status}}\\t{{.Names}}" --no-trunc
   ```
   Este comando mostrara una salida parecida a ala siguiente:
   ![Logotipo de Google](https://dc700.4shared.com/img/Wfrv-7YUku/s24/190082978b0/dockerps?async&rand=0.6425932090176958)

   Si todos los contenedores se estan ejecutando correctamente es posible validar el funcionamiento de la aplicacion
   
7. Acceder a la aplicacion web:
   ```console
   Puertos utiliados:
   Base de datos: 3306
   FrontEnd: 3000
   BackEnd: 8080

   http://localhost:3000
   
   ```

   ![Logotipo de Google](https://dc551.4shared.com/img/xQi3jvRbfa/s23/190083a8010/Web)
   
   Se mostrara una pantalla de la aplicacion web, esto indica que todo esta funcionando correctamente.
