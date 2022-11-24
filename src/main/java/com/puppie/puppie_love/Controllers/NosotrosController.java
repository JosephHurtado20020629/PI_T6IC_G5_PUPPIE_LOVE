package com.puppie.puppie_love.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("nosotros")
public class NosotrosController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String nosotros(Model model, HttpServletRequest request) {
       
    	return "nosotros";
    }
}
