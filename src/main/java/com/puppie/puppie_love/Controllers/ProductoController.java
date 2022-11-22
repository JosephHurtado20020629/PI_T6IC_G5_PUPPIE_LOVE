package com.puppie.puppie_love.Controllers;

import com.puppie.puppie_love.Models.Categoria;
import com.puppie.puppie_love.Models.Producto;
import com.puppie.puppie_love.Repositorys.ICategoriaRepository;
import com.puppie.puppie_love.Repositorys.IProductoRepository;
import com.puppie.puppie_love.Repositorys.IProveedorRepository;
import com.puppie.puppie_love.Utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "product")
public class ProductoController {

    @Autowired
    private ICategoriaRepository repoc;

    @Autowired
    private IProveedorRepository repop;

    @Autowired
    private IProductoRepository productoRepository;


    @RequestMapping(value = "/{idCategory}", method = RequestMethod.GET)
    public String listarProductos(@PathVariable("idCategory") Integer idCategory, Model model) {
        //Obtengo el nombre de la categoria
        String categoryName=parseCategory(idCategory);
        List<Producto> listProducts = new ArrayList<Producto>();

        //busco productos segun su categoria
        listProducts = productoRepository.findAllByCategoria_NombreCategoria(categoryName);
        List<Categoria> listCategorys = new ArrayList<Categoria>();

        //obtengo los nombres de las subcategorias
        for (Producto prod : listProducts) {
            if(!listCategorys.contains(prod.getCategoria())) listCategorys.add(prod.getCategoria());
        }
        model.addAttribute("lstCategorys", listCategorys);
        model.addAttribute("lstProducts", listProducts);
        model.addAttribute("categoryName",categoryName);
        return "productos";
    }

    @GetMapping("cargar")
    public String cargarformPro(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("lstCategorias", repoc.findAll());
        model.addAttribute("lstProveedores", repop.findAll());
        return "crudproductos";
    }

    @PostMapping("grabar")
    public String grabarFormPro(@ModelAttribute Producto producto, Model model) {
        System.out.println(producto);
        model.addAttribute("lstCategorias", repoc.findAll());
        model.addAttribute("lstProveedores", repop.findAll());
        try {
            productoRepository.save(producto);
            model.addAttribute("successful","PROCESO REGISTRADO CON EXITO");
        } catch (Exception e) {
            model.addAttribute("error","Error al registrar producto");
        }
        
        return "crudproductos";
    }

    @GetMapping("listar")
    public String listadoProductos(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("lstProductos", productoRepository.findAll());
        return "listadoProductos";
    }

    @PostMapping("editar")
    public String buscarEditarProd(@ModelAttribute Producto p, Model model) {
        System.out.println(p);
        model.addAttribute("producto", productoRepository.findById(p.getIdProducto()));
        model.addAttribute("lstCategorias", repoc.findAll());        
        System.out.println(p);
        return "crudproductos";
    }

    @GetMapping("eliminar")
    public String EliminarUsua(@ModelAttribute Producto p, Model model) {
        productoRepository.delete(p);
		return "crudproductos";
    }

    private String parseCategory(Integer idCategory) {
        String nombre = null;
        switch (idCategory) {
            
            case 3:
                nombre = Enums.CATEGORIAS.ALIMENTOS_PARA_GATOS.getNombreCategoria();
                break;
            case 4:
                nombre = Enums.CATEGORIAS.ALIMENTOS_PARA_PERROS.getNombreCategoria();
                break;
            case 5:
                nombre = Enums.CATEGORIAS.FARMACIA.getNombreCategoria();
                break;
            case 6:
                nombre = Enums.CATEGORIAS.JUGUETES.getNombreCategoria();
                break;
            case 7:
                nombre = Enums.CATEGORIAS.CASAS_CAMAS.getNombreCategoria();
                break;
        }
        return nombre;
    }
}
