package com.puppie.puppie_love.Repositorys;

import com.puppie.puppie_love.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Integer> {
 Cliente findClienteByUserName(String username);

}
