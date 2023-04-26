package com.sportshop.service;

import com.sportshop.domain.Articulo;
import com.sportshop.domain.Categoria;
import java.util.List;

public interface ArticuloService {
    
    //obtiene la lista de registros de la tala cliente
    //y lo coloca en una lista de objetos cliente
    public List<Articulo> getArticulos(boolean activos, int cantidad, int indice);
    
    //obtiene el registro de la tabla cliente
    //que tiene el idArticulo pasado por el objeto cliente
    public Articulo getArticulo(Articulo articulo);
    
    //elimina el registro de la tabla cliente
    //que tiene el idArticulo pasado por el objeto cliente
    public void deleteArticulo(Articulo articulo);
    
    //si el idArticulo pasado no existe o es nulo se crea 
    //un registro nuevo en la tabl cliente
    //si el idArticulo existe...se actualiza la información
    public void saveArticulo(Articulo articulo);
    
    List<Articulo> buscarPorNombre(String descripcion);

    List<Articulo> buscarCategoriaPorDescripcion(List<String> descripcionCategoria);
}
