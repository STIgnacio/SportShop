
package com.sportshop.dao;

import com.sportshop.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ignacio Barquero
 */
public interface ClienteDao extends JpaRepository<Cliente,Long>{
    
}
