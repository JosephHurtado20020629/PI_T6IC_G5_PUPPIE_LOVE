package com.puppie.puppie_love.Controllers;

import com.puppie.puppie_love.Models.Cliente;
import com.puppie.puppie_love.Models.Pedido;
import com.puppie.puppie_love.Models.Producto;
import com.puppie.puppie_love.Repositorys.IClienteRepository;
import com.puppie.puppie_love.Repositorys.IPedidosRepository;
import com.puppie.puppie_love.Repositorys.IProductoRepository;
import com.puppie.puppie_love.Utils.ConstantsPage;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @Autowired
    IPedidosRepository pedidosrepo;

    @Autowired
    IProductoRepository productorepo;

    @Autowired
    IClienteRepository clienteRepository;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        List<Pedido> listaPedidos = pedidosrepo.masVendidos();
        List<Producto> listaProductos = new ArrayList<>();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Cliente cliente = clienteRepository.findClienteByUserName(userDetails.getUsername());
        request.getSession().setAttribute("cliente", cliente);

        if (!listaPedidos.isEmpty()) {

            for (Pedido p : listaPedidos) {
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