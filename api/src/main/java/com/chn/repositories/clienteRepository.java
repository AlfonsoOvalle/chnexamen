package com.chn.repositories;

import com.chn.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Denis Morales <alfonso200925014@gmail.com>
 */

public interface clienteRepository extends JpaRepository<Cliente, Integer> {


}
