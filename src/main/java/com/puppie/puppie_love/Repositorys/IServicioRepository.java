package com.puppie.puppie_love.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puppie.puppie_love.Models.Servicios;

@Repository
public interface IServicioRepository extends JpaRepository<Servicios,String> {

    List<Servicios> findAllByCategoria_NombreCategoria(String nombreCategoria);
}
