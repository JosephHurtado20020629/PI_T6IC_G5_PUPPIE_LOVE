package com.puppie.puppie_love.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data

@Getter
@Setter
public class Proveedor {

    private int idProveedor;

    private String nomCia;

    private String nomContac;

    private String direccion;

    private String telefono;

}
