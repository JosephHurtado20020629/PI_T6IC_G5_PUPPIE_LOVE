package com.puppie.puppie_love.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puppie.puppie_love.Models.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, String> {

	
}
