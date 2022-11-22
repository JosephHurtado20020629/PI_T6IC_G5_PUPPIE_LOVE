package com.puppie.puppie_love.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puppie.puppie_love.Models.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,String> {
	
    List<Producto> findAllByCategoria_NombreCategoria(String nombreCategoria);
}


