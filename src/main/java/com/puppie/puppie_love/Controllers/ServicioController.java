package com.puppie.puppie_love.Controllers;


import com.puppie.puppie_love.Models.Servicios;
import com.puppie.puppie_love.Repositorys.ICategoriaRepository;
import com.puppie.puppie_love.Repositorys.IServicioRepository;
import com.puppie.puppie_love.Utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "service")
public class ServicioController {

    @Autowired
    private ICategoriaRepository repoc;

    @Autowired
    private IServicioRepository repos;



    @RequestMapping(value = "/{idCategory}", method = RequestMethod.GET)
    public String listarProductos(@PathVariable("idCategory") Integer idCategory, Model model) {
        //Obtengo el nombre de la categoria
        String categoryName=parseCategory(idCategory);
        List<Servicios> listService = new ArrayList<Servicios>();

        //busco productos segun su categoria
        listService = repos.findAllByCategoria_NombreCategoria(categoryName);

        //obtengo los nombres de las subcategorias
        
        model.addAttribute("listService", listService);
        model.addAttribute("categoryName",categoryName);
        return "servicios";
    }

    private String parseCategory(Integer idCategory) {
        String nombre = null;
        switch (idCategory) {
            
            case 1:
                nombre = Enums.CATEGORIAS.ADOPCION.getNombreCategoria();
                break;
            case 5:
                nombre = Enums.CATEGORIAS.PERROS_GUIA.getNombreCategoria();
                break;
        }
        return nombre;
    }
}
