package com.sportshop.service;

import com.sportshop.domain.Articulo;
import com.sportshop.domain.Categoria;
import com.sportshop.domain.General;
import com.sportshop.domain.Sexo;
import java.util.List;

public interface SexoService {
    
    //obtiene el registro de la tabla cliente
    //que tiene el idCategoria pasado por el objeto cliente
    public Sexo getSexo(Sexo sexo);
    
    //elimina el registro de la tabla cliente
    //que tiene el idCategoria pasado por el objeto cliente
    public void deleteSexo(Sexo sexo);
    
    //si el idCategoria pasado no existe o es nulo se crea 
    //un registro nuevo en la tabl cliente
    //si el idCategoria existe...se actualiza la información
    public void saveSexo(Sexo sexo);
    
    
}
