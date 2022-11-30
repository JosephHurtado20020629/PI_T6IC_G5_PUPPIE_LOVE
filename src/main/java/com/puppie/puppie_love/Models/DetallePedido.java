package com.puppie.puppie_love.Models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "DETALLE_PEDIDOS")
public class DetallePedido {

	/*
	 * @Id
	 * 
	 * @Column(name = "idDetallePedido",nullable = false) private int
	 * idDetallePedido;
	 * 
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "idPedido",insertable = false,updatable = false) private
	 * Pedido pedido;
	 */

	@Id
	@Column(name = "idPedido", nullable = false)
	private int idPedido;

	@ManyToOne
	@JoinColumn(name = "idProducto", insertable = false, updatable = false)
	private Producto producto;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "pUnitario")
	private int pUnitario;

	@Column(name = "total")
	private int total;

}