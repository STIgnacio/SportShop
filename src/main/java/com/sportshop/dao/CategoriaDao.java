package com.sportshop.dao;

import com.sportshop.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria,Long> {
    
}