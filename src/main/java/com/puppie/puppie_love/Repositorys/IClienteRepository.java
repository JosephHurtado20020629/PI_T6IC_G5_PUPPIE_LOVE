package com.puppie.puppie_love.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puppie.puppie_love.Models.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Integer> {
 Cliente findClienteByUserName(String username);

}