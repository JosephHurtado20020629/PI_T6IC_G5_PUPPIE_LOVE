package com.puppie.puppie_love.Models;


import javax.persistence.*;

import lombok.Data;


@Entity
@Table(name = "CLIENTE")
@Data
public class Cliente {

    @Id
    @Column(name = "codCliente")
    private int codCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "username")
    private String userName;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "nroDoc")
    private String nroDoc;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

}
