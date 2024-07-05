package com.chn.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Entity;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Denis Morales <alfonso200925014@gmail.com>
 */
@Entity
@Table(name = "cliente")  // Optional: Specify table name if it differs from class name
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Integer id_cliente;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 50)
    private String numero_identificacion;

    private LocalDate fecha_nacimiento;  // Use LocalDate for Date

    @Column(nullable = false, length = 50)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String correo_electronico;

    @Column(nullable = false)
    private int telefono;

    private String estado;

    public Cliente() {
    }

    public Cliente(Integer id_cliente, String nombre, String apellido, String numero_identificacion, LocalDate fecha_nacimiento, String direccion, String correo_electronico, int telefono, String estado) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_identificacion = numero_identificacion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
