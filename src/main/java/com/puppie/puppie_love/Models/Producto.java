package com.puppie.puppie_love.Models;

import lombok.Data;


@Data
public class Producto {


    private String idProducto;
    private String nombreProducto;
    private Proveedor proveedor;
    private String id_Proveedor;
    private Categoria categoria;
    private String id_Categoria;
    private double precioUnidad;
    private int stock;

}
