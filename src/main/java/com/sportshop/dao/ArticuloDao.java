package com.sportshop.dao;

import com.sportshop.domain.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloDao extends JpaRepository<Articulo,Long> {
    
}