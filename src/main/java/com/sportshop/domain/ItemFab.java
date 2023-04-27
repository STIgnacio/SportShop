
package com.sportshop.domain;

import lombok.Data;

@Data
public class ItemFab extends Articulo {
    private int cantidad; //Almacenar la cantidad de items de un articulo

    public ItemFab() {
    }

    public ItemFab(Articulo articulo) {
        super.setIdArticulo(articulo.getIdArticulo());
        super.setCategoria(articulo.getCategoria());
        super.setDescripcion(articulo.getDescripcion());
        super.setDetalle(articulo.getDetalle());
        super.setPrecio(articulo.getPrecio());
        super.setExistencias(articulo.getExistencias());
        super.setActivo(articulo.isActivo());
        super.setCategoria(articulo.getCategoria());
        super.setSexo(articulo.getSexo());
        super.setImagen(articulo.getImagen());
        super.setMoneda(articulo.getMoneda());
        this.cantidad = 0;
    }
}
