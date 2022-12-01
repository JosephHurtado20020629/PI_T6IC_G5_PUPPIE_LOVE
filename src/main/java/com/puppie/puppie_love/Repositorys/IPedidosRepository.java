package com.puppie.puppie_love.Repositorys;

import com.puppie.puppie_love.Models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidosRepository extends JpaRepository<Pedido,String > {

    Pedido findByDireccionDestinatario(String direccion);
	/*
	@Query(value = "select * from Pedidos p  group by (p.idProducto) order by sum(p.cant_x_unidad) desc limit 6",nativeQuery = true)
     List<Pedido> masVendidos();
     */
}
