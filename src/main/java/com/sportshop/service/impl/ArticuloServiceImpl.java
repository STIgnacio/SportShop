package com.sportshop.service.impl;

import com.sportshop.dao.ArticuloDao;
import com.sportshop.dao.CategoriaDao;
import com.sportshop.domain.Articulo;
import com.sportshop.domain.Categoria;
import com.sportshop.service.ArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    //Esto crea una única copia de un objeto
    @Autowired
    private ArticuloDao articuloDao;
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Articulo> getArticulos(boolean activos, int cantidad) {
        var lista= (List<Articulo>) articuloDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        if (lista.size() > cantidad) {
        lista = lista.subList(0, cantidad);
        }
        
        return lista;
    }

    @Override
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    public void deleteArticulo(Articulo articulo) {
       articuloDao.delete(articulo);
    }

    @Override
    public void saveArticulo(Articulo articulo) {
       Categoria categoria = articulo.getCategoria();
       categoria = categoriaDao.save(categoria);
       articulo.setCategoria(categoria);
       articuloDao.save(articulo);
    }
    
}
