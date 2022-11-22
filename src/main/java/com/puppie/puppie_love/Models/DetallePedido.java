package com.puppie.puppie_love.Models;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "detallePedidos")
public class DetallePedido {

	
    @Id
    @Column(name = "idPedido",nullable = false)
    private int idPedido;

    @ManyToOne
    @JoinColumn(name = "idProducto",insertable = false,updatable = false)
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

	@Column(name = "pUnitario")
    private int pUnitario;
    
    @Column(name = "total")
    private int total;
    
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
    public int getcantidad() {
        return cantidad;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getpUnitario() {
		return pUnitario;
	}

	public void setpUnitario(int pUnitario) {
		this.pUnitario = pUnitario;
	}
	
    public int gettotal() {
        return total;
    }

    public void settotal(int total) {
        this.total = total;
    }
    
    
    
	
	

}