package com.puppie.puppie_love.Controllers;

import com.puppie.puppie_love.Models.*;
import com.puppie.puppie_love.Repositorys.*;
import com.puppie.puppie_love.Utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "product")
public class ProductoController {

    @Autowired
    private ICategoriaRepository repoc;

    @Autowired
    private IProveedorRepository repop;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IPedidosRepository pedidosRepository;

    @Autowired
    private IDetallePedidosRepository detallePedidosRepository;


    @RequestMapping(value = "/{idCategory}", method = RequestMethod.GET)
    public String listarProductos(@PathVariable("idCategory") Integer idCategory, Model model) {
        //Obtengo el nombre de la categoria
        String categoryName = parseCategory(idCategory);
        List<Producto> listProducts = new ArrayList<Producto>();

        //busco productos segun su categoria
        listProducts = productoRepository.findAllByCategoria_NombreCategoria(categoryName);
        List<Categoria> listCategorys = new ArrayList<Categoria>();

        //obtengo los nombres de las subcategorias
        for (Producto prod : listProducts) {
            if (!listCategorys.contains(prod.getCategoria())) listCategorys.add(prod.getCategoria());
        }
        model.addAttribute("lstCategorys", listCategorys);
        model.addAttribute("lstProducts", listProducts);
        model.addAttribute("categoryName", categoryName);
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
            model.addAttribute("successful", "PROCESO REGISTRADO CON EXITO");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar producto");
        }

        return "crudproductos";
    }

    @GetMapping("listar")
    public String listadoProductos(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("lstProductos", productoRepository.findAll());
        return "listadoProductos";
    }

    @PostMapping("/editar")
    public String EditarProd(@ModelAttribute Producto producto, Model model) {
        //System.out.println(producto);
        model.addAttribute("producto", productoRepository.findById(producto.getIdProducto()));
        model.addAttribute("lstCategorias", repoc.findAll());
        System.out.println(producto);
        return "crudproductos";
    }

    @PostMapping("eliminar")
    public String EliminarUsua(@ModelAttribute Producto p, Model model) {
        productoRepository.delete(p);
        return "crudproductos";
    }

    @ResponseBody
    @GetMapping("/add-cart/{idProducto}")
    public ResponseEntity<?> addCart(@PathVariable("idProducto") String idProducto, HttpServletRequest request) {
        try {

            if (Objects.isNull(idProducto)) return ResponseEntity.badRequest().build();
            List<DetallePedido> detalle = (List<DetallePedido>) request.getSession().getAttribute("carrito");
            DetallePedido found = null;
            if (Objects.nonNull(detalle)) {
                found = detalle.stream().filter(p -> p.getProducto().getIdProducto().equals(idProducto)).findFirst().orElse(null);
            } else {
                detalle = new ArrayList<DetallePedido>();
            }
            if (Objects.nonNull(found)) {
                int index = detalle.indexOf(found);
                found.setCantidad(found.getCantidad() + 1);
                found.setTotal(found.getTotal() + found.getPUnitario());
                detalle.set(index, found);
            } else {
                Producto product = productoRepository.findById(idProducto).orElse(null);
                if (Objects.nonNull(product)) System.out.println(product.toString());
                detalle.add(DetallePedido.builder().producto(product).pUnitario(product.getPrecioUnidad()).cantidad(1).total(product.getPrecioUnidad()).build());

            }
            request.getSession().setAttribute("carrito", detalle);
            return ResponseEntity.ok(detalle);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/cart")
    public String cart() {
        return "resumenCompra";
    }

    @ResponseBody
    @GetMapping("/delete-cart/{idProducto}")
    public ResponseEntity<?> deleteCart(@PathVariable("idProducto") String idProducto, HttpServletRequest request) {
        try {
            List<DetallePedido> detalle = (List<DetallePedido>) request.getSession().getAttribute("carrito");
            DetallePedido found = null;
            if (Objects.nonNull(detalle))
                found = detalle.stream().filter(p -> p.getProducto().getIdProducto().equals(idProducto)).findFirst().orElse(null);
            else detalle = new ArrayList<DetallePedido>();
            if (found != null) {
                if (found.getCantidad() == 1) detalle.remove(found);
                else {
                    int index = detalle.indexOf(found);
                    found.setCantidad(found.getCantidad() - 1);
                    found.setTotal(found.getTotal() - found.getPUnitario());
                    detalle.set(index, found);
                    request.getSession().setAttribute("carrito", detalle);
                }
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("shop")
    public ResponseEntity<?> shop(@RequestBody Pedido pedido, HttpServletRequest request) {
        List<DetallePedido> detallePedidos = (List<DetallePedido>) request.getSession().getAttribute("carrito");
        Usuario usuario = (Usuario) request.getSession().getAttribute("cliente");

        pedido.setCliente(usuario);

        pedidosRepository.save(pedido);

        int id = pedidosRepository.findByDireccionDestinatario(pedido.getDireccionDestinatario()).getIdPedido();
        for (DetallePedido detallePedido : detallePedidos) {
            detallePedido.setIdPedido(id);
            detallePedidosRepository.save(detallePedido);
        }
        return ResponseEntity.ok().build();
    }

    ;

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
                nombre = Enums.CATEGORIAS.CAMAS_Y_CASAS.getNombreCategoria();
                break;
        }
        return nombre;
    }
}
