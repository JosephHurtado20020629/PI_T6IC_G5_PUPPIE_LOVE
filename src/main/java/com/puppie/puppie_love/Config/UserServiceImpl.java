package com.puppie.puppie_love.Config;

import com.puppie.puppie_love.Models.Cliente;
import com.puppie.puppie_love.Repositorys.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Cliente cliente) {
        cliente.setContraseña(bCryptPasswordEncoder.encode(cliente.getContraseña()));
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente findByUsername(String username) {
        return clienteRepository.findClienteByUserName(username);
    }
}