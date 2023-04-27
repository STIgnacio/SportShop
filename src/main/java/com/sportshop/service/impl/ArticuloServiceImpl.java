package com.sportshop.service.impl;

import com.sportshop.dao.ArticuloDao;
import com.sportshop.dao.CategoriaDao;
import com.sportshop.domain.Articulo;
import com.sportshop.domain.Categoria;
import com.sportshop.service.ArticuloService;
import java.util.ArrayList;
import java.util.Collections;
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
    public List<Articulo> getArticulos(boolean activos, int cantidad, int indice) {
        var lista = (List<Articulo>) articuloDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }

        if (indice >= lista.size()) {
            return Collections.emptyList();
        }

        var indiceFinal = Math.min(indice + cantidad, lista.size());
        return lista.subList(indice, indiceFinal);
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

    @Override
    public List<Articulo> buscarPorNombre(String descripcion) {
        return articuloDao.findBydescripcionContaining(descripcion);
    }

    @Override
    public List<Articulo> buscarCategoriaPorDescripcion(List<String> descripciones) {
        List<Articulo> listaArticulos = (List<Articulo>) articuloDao.findAll();
        List<Articulo> articulosCoincidentesExactos = new ArrayList<>();
        List<Articulo> articulosCoincidentes = new ArrayList<>();

        for (Articulo articulo : listaArticulos) {
            int contadorCoincidencias = 0;

            for (String descripcion : descripciones) {
                if (articulo.getCategoria().getDescripcion().equalsIgnoreCase(descripcion)) {
                    contadorCoincidencias++;
                }
                if (articulo.getMarca().equalsIgnoreCase(descripcion)) {
                    contadorCoincidencias++;
                }
                if (articulo.getGenerales().getDescripcion().equalsIgnoreCase(descripcion)) {
                    contadorCoincidencias++;
                }
                if (articulo.getSexo().getDescripcion().equalsIgnoreCase(descripcion)) {
                    contadorCoincidencias++;
                }
                if (descripcion.equalsIgnoreCase("niño") && articulo.getSexo().getDescripcion().equalsIgnoreCase("niño") && articulo.isNinos()) {
                    contadorCoincidencias++;
                }
                if (descripcion.equalsIgnoreCase("niña") && articulo.getSexo().getDescripcion().equalsIgnoreCase("niña") && articulo.isNinos()) {
                    contadorCoincidencias++;
                }
            }

            if (contadorCoincidencias == descripciones.size()) {
                articulosCoincidentesExactos.add(articulo);
            } else if (contadorCoincidencias > 0) {
                articulosCoincidentes.add(articulo);
            }
        }

        articulosCoincidentesExactos.addAll(articulosCoincidentes);

        return articulosCoincidentesExactos;
    }
}
