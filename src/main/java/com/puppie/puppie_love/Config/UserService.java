package com.puppie.puppie_love.Config;


import com.puppie.puppie_love.Models.Cliente;

public interface UserService {
    void save(Cliente cliente);

    Cliente findByUsername(String username);
}