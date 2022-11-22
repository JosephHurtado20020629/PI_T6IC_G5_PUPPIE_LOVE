package com.puppie.puppie_love.Models;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "PRODUCTOS")
public class Producto {

	//private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name = "idProducto",nullable = false)
    private String idProducto;

    @Column(name = "nomProducto")
    private String nombreProducto;

    @ManyToOne
    @JoinColumn(name = "idCategoria",insertable = false,updatable = false)
    private Categoria categoria;
    private String idCategoria;
    
    @Column(name = "precioUnidad")
    private double precioUnidad;

    @Column(name = "stock")
    private int stock;
    
    
    
    
    
    
    


    
	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getId_Categoria() {
		return idCategoria;
	}

	public void setId_Categoria(String id_Categoria) {
		this.idCategoria = id_Categoria;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
