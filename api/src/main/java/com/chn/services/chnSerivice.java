package com.chn.services;

import com.chn.entities.Cheque;
import com.chn.entities.Cliente;
import com.chn.entities.Cuenta;
import com.chn.repositories.chequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chn.repositories.clienteRepository;
import com.chn.repositories.cuentaRepository;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private cuentaRepository cuentaRepository;

    @Autowired
    private chequeRepository chequeRepository;

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
            Optional<Cliente> clienteObtenido = clienteRepository.findById(_ClienteActualizado.getId_cliente());
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

    /*CUENTAS*/
    public boolean agregarCuenta(Cuenta _Cuenta) {
        try {
            cuentaRepository.save(_Cuenta);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Cuenta> obtenerCuentas() {
        try {
            List<Cuenta> lstCuentas = cuentaRepository.findAll();
            return lstCuentas;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean editarCuenta(Cuenta _CuentaActualizada) {
        try {
            Optional<Cuenta> cuentaObtenida = cuentaRepository.findById(_CuentaActualizada.getId_cuenta());
            if (cuentaObtenida.isPresent()) {
                cuentaRepository.save(_CuentaActualizada);
                return true; // Guardar el cliente actualizado
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean editarSaldoCuenta(Map parametrosEntrada) {
        try {
            Optional<Cuenta> cuentaObtenida = cuentaRepository.findById(Integer.parseInt(""+parametrosEntrada.get("idCuenta")));
            
            if (cuentaObtenida.isPresent()) {
                Cuenta cuentaAActualizar = cuentaObtenida.get();
                cuentaAActualizar.setSaldo(cuentaAActualizar.getSaldo()-Integer.parseInt(""+parametrosEntrada.get("nuevoSaldo")));
                cuentaRepository.save(cuentaAActualizar);
                return true; // 
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }    

    /*CHEQUE*/
    public boolean agregarCheque(Cheque _Cheque) {
        try {
            chequeRepository.save(_Cheque);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
        public List<Cheque> obtenerCheques() {
        try {
            List<Cheque> lstCheque = chequeRepository.findAll();
            return lstCheque;
        } catch (Exception e) {
            return null;
        }
    }
}
