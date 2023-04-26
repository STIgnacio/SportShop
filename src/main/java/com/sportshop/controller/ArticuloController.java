package com.sportshop.controller;

import com.sportshop.domain.Articulo;
import com.sportshop.domain.Categoria;
import com.sportshop.service.ArticuloService;
import com.sportshop.service.CategoriaService;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import static org.springframework.jdbc.core.JdbcOperationsExtensionsKt.query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;
    private CategoriaService categoriaService;

    @GetMapping("listado") //mapeo de una ruta//
    public String inicio(Model model) {
        var tamanoPagina = 12;
        var indiceInicio = 0;
        var articulos = articuloService.getArticulos(false, tamanoPagina, indiceInicio);
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos", articulos.size());
        return "/articulo/listado";
    }

    @GetMapping("/buscar")
    public String buscarArticulos(@RequestParam String busqueda, Model model) {
        List<Articulo> articulos = articuloService.buscarPorNombre(busqueda);
        model.addAttribute("articulos", articulos);
        return "/paginacion/6";

    }

    @GetMapping("/buscar-categoria")
    public String buscarArticulosC(@RequestParam(value = "descripcionCategoria", required = false) List<String> descripcionesCategoria, Model model) {
        if (descripcionesCategoria == null || descripcionesCategoria.isEmpty()) {
            var tamanoPagina = 12;
            var indiceInicio = 0;
            var articulos = articuloService.getArticulos(false, tamanoPagina, indiceInicio);
            model.addAttribute("articulos", articulos);
            model.addAttribute("totalArticulos", articulos.size());
            return "/paginacion/6";
        }
        List<Articulo> articulos = articuloService.buscarCategoriaPorDescripcion(descripcionesCategoria);
        model.addAttribute("articulos", articulos);
        return "/paginacion/6";
    }

    @GetMapping("/eliminar/{idArticulo}")
    public String eliminaArticulo(Articulo articulo) {
        articuloService.deleteArticulo(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoArticulo(Articulo articulo) {
        return "/articulo/modifica";
    }

    @GetMapping("/2")
    public String pag2(Model model) {
        var tamanoPagina = 12;
        var indiceInicio = 12;
        var articulos = articuloService.getArticulos(false, tamanoPagina, indiceInicio);
        model.addAttribute("articulos", articulos);
        return "/paginacion/2";
    }

    @GetMapping("/3")
    public String pag3(Model model) {
        var tamanoPagina = 12;
        var indiceInicio = 24;
        var articulos = articuloService.getArticulos(false, tamanoPagina, indiceInicio);
        model.addAttribute("articulos", articulos);
        return "/paginacion/3";
    }

    @GetMapping("/4")
    public String pag4(Model model) {
        var tamanoPagina = 12;
        var indiceInicio = 36;
        var articulos = articuloService.getArticulos(false, tamanoPagina, indiceInicio);
        model.addAttribute("articulos", articulos);
        return "/paginacion/4";
    }

    @GetMapping("/5") //mapeo de una ruta//
    public String pag5(Model model) {
        var tamanoPagina = 12;
        var indiceInicio = 48;
        var articulos = articuloService.getArticulos(false, tamanoPagina, indiceInicio);
        model.addAttribute("articulos", articulos);
        return "/paginacion/5";
    }

    @PostMapping("/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.saveArticulo(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/modificar/{idArticulo}")
    public String modificaArticulo(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modifica";
    }
}
