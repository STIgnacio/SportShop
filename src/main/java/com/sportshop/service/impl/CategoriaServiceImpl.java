package com.sportshop.service.impl;

import com.sportshop.dao.CategoriaDao;
import com.sportshop.domain.Categoria;
import com.sportshop.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    //Esto crea una única copia de un objeto
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista= (List<Categoria>) categoriaDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
       categoriaDao.delete(categoria);
    }

    @Override
    public void saveCategoria(Categoria categoria) {
       categoriaDao.save(categoria);
    }
    
}
