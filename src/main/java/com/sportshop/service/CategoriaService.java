package com.sportshop.service;

import com.sportshop.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //obtiene la lista de registros de la tala cliente
    //y lo coloca en una lista de objetos cliente
    public List<Categoria> getCategorias(boolean activos);
    
    //obtiene el registro de la tabla cliente
    //que tiene el idCategoria pasado por el objeto cliente
    public Categoria getCategoria(Categoria categoria);
    
    //elimina el registro de la tabla cliente
    //que tiene el idCategoria pasado por el objeto cliente
    public void deleteCategoria(Categoria categoria);
    
    //si el idCategoria pasado no existe o es nulo se crea 
    //un registro nuevo en la tabl cliente
    //si el idCategoria existe...se actualiza la información
    public void saveCategoria(Categoria categoria);
    
    
}
