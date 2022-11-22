package com.puppie.puppie_love.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.puppie.puppie_love.Models.DetallePedido;


@Repository
public interface IDetallePedidosRepository extends JpaRepository<DetallePedido,String > {
	
	@Query(value = "select * from DETALLE_PEDIDOS p  group by (p.idProducto) order by sum(p.cantidad) desc limit 6",nativeQuery = true)
     List<DetallePedido> masVendidos();
	
	
}
