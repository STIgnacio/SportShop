package com.sportshop.service.impl;

import com.sportshop.domain.ItemFab;
import com.sportshop.service.ItemFabService;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ItemFabServiceImpl implements ItemFabService {

    @Override
    public List<ItemFab> gets() {
        return listaItemFab;
    }
   

    //Se usa en el addCarrito... agrega un elemento
    @Override
    public void save(ItemFab item) {
        boolean existe = false;
        for (ItemFab i : listaItemFab) {
            //Busca si ya existe el articulo en el carrito
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                //Valida si aún puede colocar un item adicional -segun existencias-
                if (i.getCantidad() < item.getExistencias()) {
                    //Incrementa en 1 la cantidad de elementos
                    i.setCantidad(i.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {//Si no está el articulo en el carrito se agrega cantidad =1.            
            item.setCantidad(1);
            listaItemFab.add(item);
        }
    }

    //Se usa para eliminar un articulo del carrito
    @Override
    public void delete(ItemFab item) {
        var posicion = -1;
        var existe = false;
        for (ItemFab i : listaItemFab) {
            ++posicion;
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItemFab.remove(posicion);
        }
    }

    //Se obtiene la información de un articulo del carrito... para modificarlo
    @Override
    public ItemFab get(ItemFab item) {
        for (ItemFab i : listaItemFab) {
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                return i;
            }
        }
        return null;
    }

    //Se usa en la página para actualizar la cantidad de articulos
    @Override
    public void actualiza(ItemFab item) {
        for (ItemFab i : listaItemFab) {
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    /*En un futuro sería el proceso de generar la facturación...
    por ahora sólo borra los elementos del carrito */
    @Override
    public void facturar() {
        System.out.println("Facturando");
        for (ItemFab i : listaItemFab) {
            System.out.println("Producto: " + i.getDescripcion()
                    + " Cantidad: " + i.getCantidad()
                    + " Total: " + i.getPrecio() * i.getCantidad());

        }
        listaItemFab.clear();
    }
}
