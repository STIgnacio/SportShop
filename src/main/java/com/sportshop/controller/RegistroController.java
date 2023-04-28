
package com.sportshop.controller;

import com.sportshop.domain.Registro;
import com.sportshop.service.RegistroService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private RegistroService registroService;
    
    @GetMapping("/editarUsuario")
    public String inicio(Model model){
        var registros=registroService.getRegistros();
        model.addAttribute("registros",registros);
        return "registro/editarUsuario";
    }
    
    @GetMapping("/registro")
    public String registro(Registro registro){
        return "/registro/registro";
    
    }
    
    
    @GetMapping("/inicioSesion")
    public String inicioSesion(Registro registro){
        return "/registro/inicioSesion";
    
    }
    
    @PostMapping("/validar")
    public String validaUsuario(Registro registro){
        Registro usuario = registroService.autenticarUsuario(registro.getCorreo(), registro.getContraseña());
        if(usuario != null && usuario.getCorreo() != null){
            return "redirect:/";
        }else{
            return "redirect:/registro/inicioSesion";
        }
    }
    
    @GetMapping("/contactenos")
    public String contacto(Registro registro){
        return "/registro/contactenos";
    
    }
    
    @GetMapping("/eliminar/{idRegistro}")
    public String eliminarRegistro(Registro registro){
        registroService.deleteRegistro(registro);
        return "redirect:/registro/editarUsuario";
    }
    
    
    @GetMapping("/nuevo")
    public String nuevoRegistro(Registro registro){
        return "/registro/compra";
    }
    
    @PostMapping("/guardar")
    public String guardarRegistro(@ModelAttribute("registro") Registro registro) {
        registroService.saveRegistro(registro);
        return "redirect:/";
    }
    
    @GetMapping("/modificar/{idRegistro}")
    public String modificaRegistro(Registro registro, Model model){
        registro = registroService.getRegistro(registro);
        model.addAttribute("registro", registro);
        return "/registro/modificar";
    
    }
    @PostMapping("/modificar/{idRegistro}")
    public String guardarRegistro(@ModelAttribute Registro registro, Model model) {
        registroService.guardarRegistroEditado(registro);
        return "redirect:/registro/editarUsuario";
}

}

