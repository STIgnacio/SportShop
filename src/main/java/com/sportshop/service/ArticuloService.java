package com.sportshop.service;

import com.sportshop.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    
    //obtiene la lista de registros de la tala cliente
    //y lo coloca en una lista de objetos cliente
    public List<Articulo> getArticulos(boolean activos, int cantidad);
    
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
    
    
}
