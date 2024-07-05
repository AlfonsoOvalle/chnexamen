package com.chn.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cuenta;

    private String tipo_cuenta;

    private int monto_apertura;

    private int saldo;
    private int cantidad_cheques;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(Integer id_cuenta, String tipo_cuenta, int monto_apertura, int saldo, int cantidad_cheques, String estado, Cliente cliente) {
        this.id_cuenta = id_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.monto_apertura = monto_apertura;
        this.saldo = saldo;
        this.cantidad_cheques = cantidad_cheques;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public int getMonto_apertura() {
        return monto_apertura;
    }

    public void setMonto_apertura(int monto_apertura) {
        this.monto_apertura = monto_apertura;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getCantidad_cheques() {
        return cantidad_cheques;
    }

    public void setCantidad_cheques(int cantidad_cheques) {
        this.cantidad_cheques = cantidad_cheques;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
