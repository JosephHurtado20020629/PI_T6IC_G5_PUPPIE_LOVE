package com.puppie.puppie_love.Models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
@Data
public class Usuario {

    @Id
    @Column(name = "codUsuario")
    private int codUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "idRoles",insertable = false,updatable = false)
    private Rol rol;
    private int idRoles;

    //private int idRol;


//    public Usuario(int codUsuario, String nombre, String apellido, String username, String contraseña,
//                   int idRoles) {
//        this.codUsuario = codUsuario;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.username = username;
//        this.contraseña = contraseña;
//        this.idRoles = idRoles;
//    }
//
//    public Usuario() {
//        // TODO Auto-generated constructor stub
//    }


}
