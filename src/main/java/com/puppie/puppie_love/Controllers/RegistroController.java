package com.puppie.puppie_love.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.puppie.puppie_love.Config.UserService;
import com.puppie.puppie_love.Models.Cliente;
import com.puppie.puppie_love.Repositorys.IClienteRepository;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
@RequestMapping(value="cliente")
public class RegistroController {
	
	@Autowired
	IClienteRepository repocli;
	
	@GetMapping("cargar")
	public String cargarForm(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "registro";
	}
	
	
	@PostMapping("grabar")
	public String grabarForm(@ModelAttribute Cliente cliente, Model model) {
		System.out.println(cliente);
		try {
			repocli.save(cliente);
			model.addAttribute("success", "Registro exitoso");
			return "redirect:/iniciar-sesion";
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al registrar");
		}
		return "registro";
	} 
	
}

