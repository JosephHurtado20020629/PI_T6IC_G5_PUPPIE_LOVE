package com.puppie.puppie_love.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puppie.puppie_love.Models.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findUsuarioByUsername(String username);
}
