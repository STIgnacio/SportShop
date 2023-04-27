package com.sportshop.controller;

import com.sportshop.domain.Articulo;
import com.sportshop.domain.ItemFab;
import com.sportshop.service.ArticuloService;
import com.sportshop.service.ItemFabService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class FavoritoController {

    @Autowired
    private ItemFabService itemfabService;
    @Autowired
    private ArticuloService articuloService;

    //Para ver el favorito
    @GetMapping("/favorito/listado")
    public String inicio(Model model) {
        var itemFabs = itemfabService.gets();
        model.addAttribute("itemFabs", itemFabs);
        var favoritoTotalVenta = 0;
        for (ItemFab i : itemFabs) {
            favoritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("favoritoTotal", favoritoTotalVenta);
        return "/favorito/listado";
    }

    //Para Agregar un articulo al favorito
    @GetMapping("/favorito/agregar/{idArticulo}")
    public String agregarItem(Model model, ItemFab item) {
        ItemFab item2 = itemfabService.get(item);
        if (item2 == null) {
            Articulo articulo = articuloService.getArticulo(item);
            item2 = new ItemFab(articulo);
        }
        itemfabService.save(item2);
        var listafab = itemfabService.gets();
        var totalFavoritos = 0;
        var favoritoTotalVenta = 0;
        for (ItemFab i : listafab) {
            totalFavoritos += i.getCantidad();
            favoritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", listafab);
        model.addAttribute("listaTotal", totalFavoritos);
        model.addAttribute("favoritoTotal", favoritoTotalVenta);
        return "/";
    }

    //Para mofificar un articulo del favorito
    @GetMapping("/favorito/modificar/{idArticulo}")
    public String modificarItem(ItemFab item, Model model) {
        item = itemfabService.get(item);
        model.addAttribute("item", item);
        return "/favorito/modificar";
    }

    //Para eliminar un elemento del favorito
    @GetMapping("/favorito/eliminar/{idArticulo}")
    public String eliminarItem(ItemFab item) {
        itemfabService.delete(item);
        return "redirect:/favorito/listado";
    } 

    //Para actualizar un articulo del favorito (cantidad)
    @PostMapping("/favorito/guardar")
    public String guardarItem(ItemFab item) {
        itemfabService.actualiza(item);
        return "redirect:/favorito/listado";
    }
    
    //Para facturar los articulos del favorito... no implementado...
    @GetMapping("/facturar/favorito")
    public String facturarFavorito() {
        itemfabService.facturar();
        return "redirect:/";
    }
}