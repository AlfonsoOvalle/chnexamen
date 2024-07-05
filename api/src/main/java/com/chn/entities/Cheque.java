package com.chn.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Denis Morales <alfonso200925014@gmail.com>
 */
@Entity
@Table(name = "cheque")  // Optional: Specify table name if it differs from class name
public class Cheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Integer id_cheque;

    @Column(name = "estado", nullable = false, length = 10)
    private String estado;

    @Column(name = "motivo", nullable = false, length = 10)
    private String motivo;

    @Column(name = "monto_pagado", nullable = false)
    private Integer monto_pagado;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    private Cuenta cuenta;

    public Cheque() {
    }

    public Cheque(Integer id_cheque, String estado, String motivo, Integer monto_pagado, LocalDate fecha, Cuenta cuenta) {
        this.id_cheque = id_cheque;
        this.estado = estado;
        this.motivo = motivo;
        this.monto_pagado = monto_pagado;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    public Integer getId_cheque() {
        return id_cheque;
    }

    public void setId_cheque(Integer id_cheque) {
        this.id_cheque = id_cheque;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getMonto_pagado() {
        return monto_pagado;
    }

    public void setMonto_pagado(Integer monto_pagado) {
        this.monto_pagado = monto_pagado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
