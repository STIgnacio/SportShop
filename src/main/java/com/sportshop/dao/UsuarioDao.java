package com.sportshop.dao;

import com.sportshop.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository <Usuario,Long> {
 
    Usuario findByUsername(String username);
}