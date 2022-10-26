package com.puppie.puppie_love.Controllers;

import com.puppie.puppie_love.Models.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("shop")
public class TiendaController {

    
    @RequestMapping(value = "{idTienda}",method = RequestMethod.GET)
    public String tienda(@PathVariable("idTienda")String idTienda, Model model){
        model.addAttribute("sedes",new Sede());
        return "tiendas";
    }
}
