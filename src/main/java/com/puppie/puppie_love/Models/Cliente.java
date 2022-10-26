package com.puppie.puppie_love.Models;


import lombok.Data;




@Data
public class Cliente {

    private String codCliente;

    private String nombre;
    private String apellido;
    private String userName;
    private String contraseña;
    private String nroDocumento;
    private String telefono;
    private String direccion;

}
