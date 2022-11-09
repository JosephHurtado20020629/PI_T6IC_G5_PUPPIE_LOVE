package com.puppie.puppie_love.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class Producto {


    private String idProducto;
    private String nomProducto;
    private Categoria categoria;
    private String idCategoria;
    private double precioUnidad;
    private int stock;

}
