package com.chn.controller;

import com.chn.entities.Cliente;
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
}
