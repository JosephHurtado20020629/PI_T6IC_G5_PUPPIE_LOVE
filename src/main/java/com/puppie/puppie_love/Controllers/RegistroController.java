package com.puppie.puppie_love.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.puppie.puppie_love.Models.Usuario;
import com.puppie.puppie_love.Repositorys.IRolesRepository;
import com.puppie.puppie_love.Repositorys.IUsuarioRepository;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
@RequestMapping(value="user")
public class RegistroController {
	
	@Autowired
    private IRolesRepository repor;
	
	@Autowired
	IUsuarioRepository repous;
	
	@GetMapping("cargar")
	public String cargarForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("lstRoles", repor.findAll());
		return "registro";
	}
	
	
	@PostMapping("grabar")
	public String grabarForm(@ModelAttribute Usuario usuario, Model model) {
		System.out.println(usuario);
		try {
			repous.save(usuario);
			model.addAttribute("success", "Registro exitoso");
			return "redirect:/iniciar-sesion";
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al registrar");
		}
		return "registro";
	} 
	
}

