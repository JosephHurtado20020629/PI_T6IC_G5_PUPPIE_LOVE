package com.puppie.puppie_love.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.puppie.puppie_love.Models.Pedido;

@Repository
public interface IPedidosRepository extends JpaRepository<Pedido,String > {
	
	@Query(value = "select * from Pedidos p  group by (p.idProducto) order by sum(p.cant_x_unidad) desc limit 6",nativeQuery = true)
     List<Pedido> masVendidos();
}
