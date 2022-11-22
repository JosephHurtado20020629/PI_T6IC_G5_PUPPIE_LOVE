package com.puppie.puppie_love.Models;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "PEDIDOS")
public class Pedido {

    @Id
    @Column(name = "idPedido",nullable = false)
    private int idPedido;

    @ManyToOne
    @JoinColumn(name = "codCliente",insertable = false,updatable = false)
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

    
    
    
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getIdSede() {
		return idSede;
	}

	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}


	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaAproxEntrega() {
		return fechaAproxEntrega;
	}

	public void setFechaAproxEntrega(Date fechaAproxEntrega) {
		this.fechaAproxEntrega = fechaAproxEntrega;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getDireccionDestinatario() {
		return direccionDestinatario;
	}

	public void setDireccionDestinatario(String direccionDestinatario) {
		this.direccionDestinatario = direccionDestinatario;
	}
    
    

}