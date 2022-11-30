package com.puppie.puppie_love.Config;


import com.puppie.puppie_love.Models.Usuario;

public interface UserService {
    void save(Usuario cliente);

    Usuario findByUsername(String username);
}