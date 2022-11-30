package com.puppie.puppie_love.Models;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "PEDIDOS")
public class Pedido {

	@Id
	@Column(name = "idPedido", nullable = false)
	private int idPedido;

	@ManyToOne
	@JoinColumn(name = "codCliente", insertable = false, updatable = false)
	private Cliente cliente;

	@Column(name = "idSede")
	private String idSede;

	@Column(name = "fech_pedido")
	private Date fechaPedido;

	@Column(name = "fech_aprox_entrega")
	private Date fechaAproxEntrega;

	@Column(name = "fech_envio")
	private Date fechaEnvio;

	@Column(name = "destinatario")
	private String destinatario;

	@Column(name = "direcDestinatario")
	private String direccionDestinatario;

}