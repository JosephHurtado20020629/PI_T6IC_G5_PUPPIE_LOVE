package com.puppie.puppie_love.Config;

import com.puppie.puppie_love.Models.DetallePedido;
import com.puppie.puppie_love.Models.Usuario;
import com.puppie.puppie_love.Repositorys.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component("Lo")
public class LoginSuccessfulHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    IUsuarioRepository usuarioRepository;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        super.onAuthenticationSuccess(request, response, authentication);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario=usuarioRepository.findUsuarioByUsername(userDetails.getUsername());
        request.getSession().setAttribute("cliente", usuario);
        request.getSession().setAttribute("carrito",new ArrayList<DetallePedido>());

    }
}
