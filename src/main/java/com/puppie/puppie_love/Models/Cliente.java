package com.puppie.puppie_love.Models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

@Getter
@Setter
public class Cliente {

    private int codCliente;
    private String nombre;
    private String apellido;
    private String userName;
    private String contraseña;
    private String nroDoc;
    private String telefono;
    private String direccion;

}
