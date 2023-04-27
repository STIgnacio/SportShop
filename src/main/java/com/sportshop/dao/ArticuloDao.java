package com.sportshop.dao;

import com.sportshop.domain.Articulo;
import com.sportshop.domain.Categoria;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticuloDao extends JpaRepository<Articulo, Long> {

    List<Articulo> findBydescripcionContaining(String descripcion);

    List<Articulo> findByCategoriaDescripcion(String descripcion);

}
