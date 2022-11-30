package com.puppie.puppie_love.Models;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "PRODUCTOS")
public class Producto {
	
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

	
    
   
}
