package com.sportshop.dao;

import com.sportshop.domain.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexoDao extends JpaRepository<Sexo,Long> {
    
}