package com.puppie.puppie_love.Controllers;

import com.puppie.puppie_love.Config.SecurityService;
import com.puppie.puppie_love.Models.Cliente;
import com.puppie.puppie_love.Repositorys.IClienteRepository;
import com.puppie.puppie_love.Utils.ConstantsPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {
	
	@Autowired
    IClienteRepository clienteRepository;

    @Autowired
    SecurityService securityService;


    @RequestMapping(value = {"iniciar-sesion"}, method = RequestMethod.GET)
    public String inicio(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("cliente", new Cliente());
        if (error != null) model.addAttribute("error", true);
        return ConstantsPage.LOGIN;
    }

}
