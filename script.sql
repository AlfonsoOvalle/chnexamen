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



