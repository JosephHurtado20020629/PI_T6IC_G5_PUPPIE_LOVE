package com.puppie.puppie_love.Controllers;

import com.puppie.puppie_love.Models.DetallePedido;
import com.puppie.puppie_love.Models.Producto;
import com.puppie.puppie_love.Models.Usuario;
import com.puppie.puppie_love.Repositorys.IDetallePedidosRepository;
import com.puppie.puppie_love.Repositorys.IPedidosRepository;
import com.puppie.puppie_love.Repositorys.IProductoRepository;
import com.puppie.puppie_love.Repositorys.IUsuarioRepository;
import com.puppie.puppie_love.Utils.ConstantsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @Autowired
    IPedidosRepository pedidosrepo;

    @Autowired
    IProductoRepository productorepo;
    
    @Autowired
    IDetallePedidosRepository detallpedidosrepo;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario =null;
        if(Objects.isNull(request.getSession().getAttribute("cliente"))) {
           usuario= usuarioRepository.findUsuarioByUsername(userDetails.getUsername());
            request.getSession().setAttribute("cliente", usuario);
            request.getSession().setAttribute("carrito", new ArrayList<DetallePedido>());
        }


        List<DetallePedido> listaPedidos = detallpedidosrepo.masVendidos();
        List<Producto> listaProductos = new ArrayList<>();

        if (!listaPedidos.isEmpty()) {

            for (DetallePedido p : listaPedidos) {
                Producto prod = new Producto();
                prod = productorepo.findById(p.getProducto().getIdProducto()).orElse(new Producto());
                if (prod != null) {
                    listaProductos.add(prod);
                }
            }
        }
        model.addAttribute("lstmasVendidos", listaProductos);
        return ConstantsPage.INICIO;
    }
}