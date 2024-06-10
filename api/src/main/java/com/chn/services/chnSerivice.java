package com.chn.services;

import com.chn.entities.Cliente;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chn.repositories.clienteRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Denis Morales <alfonso200925014@gmail.com>
 */
@Service
public class chnSerivice {

    // private static final com.sun.org.slf4j.internal.Logger LOGGER = LoggerFactory.getLogger(chnSerivice.class);
    @Autowired
    private clienteRepository clienteRepository;

    public boolean agregarCliente(Cliente _Cliente) {
        try {
            Cliente agregarCliente = clienteRepository.save(_Cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Cliente> obtenerClientes() {
        try {
            List<Cliente> lstClientes = clienteRepository.findAll();
            return lstClientes;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean editarCliente(Cliente _ClienteActualizado) {
        try {
            Optional<Cliente> clienteObtenido = clienteRepository.findById(_ClienteActualizado.getIdCliente());
            if (clienteObtenido.isPresent()) {
                clienteRepository.save(_ClienteActualizado);
                return true; // Guardar el cliente actualizado
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
