package com.chn.repositories;

import com.chn.entities.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Denis Morales <alfonso200925014@gmail.com>
 */

public interface chequeRepository extends JpaRepository<Cheque, Integer> {


}
