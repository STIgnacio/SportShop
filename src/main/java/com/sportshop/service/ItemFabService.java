package com.sportshop.service;

import com.sportshop.domain.ItemFab;
import java.util.ArrayList;
import java.util.List;

public interface ItemFabService {     

    List<ItemFab> listaItemFab = new ArrayList<>();
    
    public List<ItemFab> gets();
    
    //Se recupera el registro que tiene el idItemFab pasado por parámetro
    //si no existe en la tabla se retorna null
    public ItemFab get(ItemFab item);
    
    //Se elimina el registro que tiene el idItemFab pasado por parámetro
    public void delete(ItemFab item);
    
    //Si el objeto item tiene un idItemFab que existe en la tabla item
    //El registro de actualiza con la nueva información
    //Si el idItemFab NO existe en la tabla, se crea el registro con esa información
    public void save(ItemFab item);
    
    public void actualiza(ItemFab item);
    
    public void facturar();
}
