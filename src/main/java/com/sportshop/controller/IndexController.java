
package com.sportshop.controller;

import com.sportshop.domain.Cliente;
import com.sportshop.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author Ignacio Barquero
 */
@Controller
public class IndexController {
    
    @GetMapping("/")
    public String inicio(Model model){
        return "index";
    }
     
}
