package com.puppie.puppie_love.Controllers;

import com.puppie.puppie_love.Models.Usuario;
import com.puppie.puppie_love.Repositorys.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value="cliente")
public class RegistroController {
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@GetMapping("cargar")
	public String cargarForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}
	
	
	@PostMapping("grabar")
	public String grabarForm(@ModelAttribute Usuario cliente, Model model) {
		System.out.println(cliente);
		try {
			usuarioRepository.save(cliente);
			model.addAttribute("success", "Registro exitoso");
			return "redirect:/iniciar-sesion";
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al registrar");
		}
		return "registro";
	} 
	
}

