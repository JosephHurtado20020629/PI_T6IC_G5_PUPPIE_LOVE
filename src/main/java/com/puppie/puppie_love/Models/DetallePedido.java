package com.puppie.puppie_love.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@Table(name = "DETALLE_PEDIDOS")
public class DetallePedido {



	@Id
	@Column(name = "idPedido", nullable = false)
	private int idPedido;

	@OneToOne
	@JoinColumn(name = "idProducto", insertable = false, updatable = false)
	private Producto producto;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "pUnitario")
	private double pUnitario;

	@Column(name = "total")
	private double total;

	public DetallePedido() {

	}
}