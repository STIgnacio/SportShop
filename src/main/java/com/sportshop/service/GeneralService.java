package com.sportshop.service;

import com.sportshop.domain.Articulo;
import com.sportshop.domain.Categoria;
import com.sportshop.domain.General;
import java.util.List;

public interface GeneralService {
    
    //obtiene el registro de la tabla cliente
    //que tiene el idCategoria pasado por el objeto cliente
    public General getGenerales(General generales);
    
    //elimina el registro de la tabla cliente
    //que tiene el idCategoria pasado por el objeto cliente
    public void deleteGenerales(General generales);
    
    //si el idCategoria pasado no existe o es nulo se crea 
    //un registro nuevo en la tabl cliente
    //si el idCategoria existe...se actualiza la información
    public void saveGenerales(General generales);
    
    
}
