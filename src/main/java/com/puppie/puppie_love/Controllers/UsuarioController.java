package com.puppie.puppie_love.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.puppie.puppie_love.Models.Usuario;
import com.puppie.puppie_love.Repositorys.IRolesRepository;
import com.puppie.puppie_love.Repositorys.IUsuarioRepository;



@Controller
@RequestMapping(value = "usuario")
public class UsuarioController {

    @Autowired
    private IRolesRepository repor;
    
    @Autowired
    private IUsuarioRepository repou;


    @GetMapping("cargar")
    public String cargarformUsu(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("lstRoles", repor.findAll());
        return "crudusuarios";
    }

    @PostMapping("grabar")
    public String grabarFormUsu(@ModelAttribute Usuario usuario, Model model) {
        System.out.println(usuario);
        model.addAttribute("lstRoles", repor.findAll());
        try {
            repou.save(usuario);
            model.addAttribute("successful", "PROCESO REGISTRADO CON EXITO");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar usuario!");
        }
        return "crudusuarios";
    }

    @GetMapping("listar")
    public String listadoUsuarios(Model model) {
        model.addAttribute("lstUsuarios", repou.findAll());
        return "listadoUsuario";
    }

    @PostMapping("editar")
    public String buscarUsua(@ModelAttribute Usuario u, Model model) {

        model.addAttribute("usuario", repou.findById(u.getCodUsuario()));
        model.addAttribute("lstRoles", repor.findAll());

        System.out.println(u);
        return "crudusuarios";
    }
    
    @PostMapping("eliminar")
    public String EliminarUsua(@ModelAttribute Usuario p, Model model) {
        repou.delete(p);
		return "crudusuarios";
    }

}
