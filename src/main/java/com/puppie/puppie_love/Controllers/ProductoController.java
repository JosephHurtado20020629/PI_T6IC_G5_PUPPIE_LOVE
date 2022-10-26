package com.puppie.puppie_love.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "product")
public class ProductoController {



    @RequestMapping(value = "/{idCategory}", method = RequestMethod.GET)
    public String listarProductos(@PathVariable("idCategory") Integer idCategory, Model model) {
        //Obtengo el nombre de la categoria

        return "productos";
    }

}
