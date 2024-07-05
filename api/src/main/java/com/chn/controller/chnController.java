package com.chn.controller;

import com.chn.entities.Cheque;
import com.chn.entities.Cliente;
import com.chn.entities.Cuenta;
import com.chn.services.chnSerivice;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denis Morales <alfonso200925014@gmail.com>
 */
@RestController
@CrossOrigin(origins = "*")
public class chnController {

    @Autowired
    private chnSerivice chnSerivice;

    /*CLIENTES*/
    @PostMapping(value = "/agregarCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map agregarCliente(@RequestBody Cliente _Cliente) throws ParseException {
        Map mapRespuesta = new HashMap();
        try {
            boolean agregarCliente = chnSerivice.agregarCliente(_Cliente);
            if (agregarCliente) {
                mapRespuesta.put("estado", "exito");
                mapRespuesta.put("mensaje", "cliente agregado exitosamente");

                return mapRespuesta;
            } else {
                mapRespuesta.put("estado", "error");
                mapRespuesta.put("mensaje", "No se agrego el cliente");

                return mapRespuesta;
            }
        } catch (Exception e) {
            mapRespuesta.put("estado", "error");
            mapRespuesta.put("mensaje", "Error: " + e);

            return mapRespuesta;
        }
    }

    @GetMapping(value = "/obtenerClientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map obtenerClientes() throws ParseException {
        Map mapRespuesta = new HashMap();
        try {
            List<Cliente> lstClientes = chnSerivice.obtenerClientes();
            if (lstClientes != null) {
                mapRespuesta.put("estado", "exito");
                mapRespuesta.put("mensaje", "Clientes obtenidos exitosamente");
                mapRespuesta.put("data", lstClientes);

                return mapRespuesta;
            } else {
                mapRespuesta.put("estado", "error");
                mapRespuesta.put("mensaje", "Error al obtener los clientes");
                mapRespuesta.put("data", null);
                return mapRespuesta;
            }
        } catch (Exception e) {
            mapRespuesta.put("estado", "error");
            mapRespuesta.put("mensaje", "Error: " + e);
            mapRespuesta.put("data", null);
            return mapRespuesta;
        }
    }

    @PostMapping(value = "/editarCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map editarCliente(@RequestBody Cliente _Cliente) throws ParseException {
        Map mapRespuesta = new HashMap();
        try {
            boolean agregarCliente = chnSerivice.editarCliente(_Cliente);
            if (agregarCliente) {
                mapRespuesta.put("estado", "exito");
                mapRespuesta.put("mensaje", "cliente actualizado exitosamente");

                return mapRespuesta;
            } else {
                mapRespuesta.put("estado", "error");
                mapRespuesta.put("mensaje", "No se actualizo el cliente");

                return mapRespuesta;
            }
        } catch (Exception e) {
            mapRespuesta.put("estado", "error");
            mapRespuesta.put("mensaje", "Error: " + e);

            return mapRespuesta;
        }
    }

    /*CUENTAS*/
    @PostMapping(value = "/agregarCuenta", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map agregarCuenta(@RequestBody Cuenta _Cuenta) throws ParseException {
        Map mapRespuesta = new HashMap();
        try {
            boolean agregarCliente = chnSerivice.agregarCuenta(_Cuenta);
            if (agregarCliente) {
                mapRespuesta.put("estado", "exito");
                mapRespuesta.put("mensaje", "cuenta agregada exitosamente");

                return mapRespuesta;
            } else {
                mapRespuesta.put("estado", "error");
                mapRespuesta.put("mensaje", "No se agrego la cuenta");

                return mapRespuesta;
            }
        } catch (Exception e) {
            mapRespuesta.put("estado", "error");
            mapRespuesta.put("mensaje", "Error: " + e);

            return mapRespuesta;
        }
    }

    @GetMapping(value = "/obtenerCuentas", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map obtenerCuentas() throws ParseException {
        Map mapRespuesta = new HashMap();
        try {
            List<Cuenta> lstCuentas = chnSerivice.obtenerCuentas();
            if (lstCuentas != null) {
                mapRespuesta.put("estado", "exito");
                mapRespuesta.put("mensaje", "Cuentas obtenidos exitosamente");
                mapRespuesta.put("data", lstCuentas);

                return mapRespuesta;
            } else {
                mapRespuesta.put("estado", "error");
                mapRespuesta.put("mensaje", "Error al obtener las cuentas");
                mapRespuesta.put("data", null);
                return mapRespuesta;
            }
        } catch (Exception e) {
            mapRespuesta.put("estado", "error");
            mapRespuesta.put("mensaje", "Error: " + e);
            mapRespuesta.put("data", null);
            return mapRespuesta;
        }
    }

    @PostMapping(value = "/editarCuenta", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map editarCliente(@RequestBody Cuenta _Cuenta) throws ParseException {
        Map mapRespuesta = new HashMap();
        try {
            boolean editarCuenta = chnSerivice.editarCuenta(_Cuenta);
            if (editarCuenta) {
                mapRespuesta.put("estado", "exito");
                mapRespuesta.put("mensaje", "cuenta actualizado exitosamente");

                return mapRespuesta;
            } else {
                mapRespuesta.put("estado", "error");
                mapRespuesta.put("mensaje", "No se actualizo la cuenta");

                return mapRespuesta;
            }
        } catch (Exception e) {
            mapRespuesta.put("estado", "error");
            mapRespuesta.put("mensaje", "Error: " + e);

            return mapRespuesta;
        }
    }

    @PostMapping(value = "/actualizarSaldo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map actualizarSaldo(@RequestBody Map parametrosEntrada) throws ParseException {
        Map mapRespuesta = new HashMap();
        try {
            boolean editarCuenta = chnSerivice.editarSaldoCuenta(parametrosEntrada);
            if (editarCuenta) {
                mapRespuesta.put("estado", "exito");
                mapRespuesta.put("mensaje", "Saldo actualizado exitosamente");

                return mapRespuesta;
            } else {
                mapRespuesta.put("estado", "error");
                mapRespuesta.put("mensaje", "No se actualizo el saldo");

                return mapRespuesta;
            }
        } catch (Exception e) {
            mapRespuesta.put("estado", "error");
            mapRespuesta.put("mensaje", "Error: " + e);

            return mapRespuesta;
        }
    }

    /*CHEQUE*/
    @PostMapping(value = "/agregarCheque", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map agregarCheque(@RequestBody Cheque _Cheque) throws ParseException {
        Map mapRespuesta = new HashMap();
        try {
            boolean agregarCliente = chnSerivice.agregarCheque(_Cheque);
            if (agregarCliente) {
                mapRespuesta.put("estado", "exito");
                mapRespuesta.put("mensaje", "Movimiento de cheque exitoso");

                return mapRespuesta;
            } else {
                mapRespuesta.put("estado", "error");
                mapRespuesta.put("mensaje", "No se agrego el movimiento del cheque");

                return mapRespuesta;
            }
        } catch (Exception e) {
            mapRespuesta.put("estado", "error");
            mapRespuesta.put("mensaje", "Error: " + e);

            return mapRespuesta;
        }
    }

    @GetMapping(value = "/obtenerCheques", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map obtenerCheques() throws ParseException {
        Map mapRespuesta = new HashMap();
        try {
            List<Cheque> lstCuentas = chnSerivice.obtenerCheques();
            if (lstCuentas != null) {
                mapRespuesta.put("estado", "exito");
                mapRespuesta.put("mensaje", "Cheques obtenidos exitosamente");
                mapRespuesta.put("data", lstCuentas);

                return mapRespuesta;
            } else {
                mapRespuesta.put("estado", "error");
                mapRespuesta.put("mensaje", "Error al obtener los cheques");
                mapRespuesta.put("data", null);
                return mapRespuesta;
            }
        } catch (Exception e) {
            mapRespuesta.put("estado", "error");
            mapRespuesta.put("mensaje", "Error: " + e);
            mapRespuesta.put("data", null);
            return mapRespuesta;
        }
    }

}
