package com.puppie.puppie_love.Models;

import lombok.Data;

import javax.persistence.*;

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
    private String password;

    @ManyToOne
    @JoinColumn(name = "idRoles",insertable = false,updatable = false)
    private Rol rol;
    
    private int idRoles;

    public Usuario() {
        // TODO Auto-generated constructor stub
    }


}
