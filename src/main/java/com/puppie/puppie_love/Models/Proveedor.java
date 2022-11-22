package com.puppie.puppie_love.Models;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "PROVEEDORES")
public class Proveedor {

   @Id
   @Column(name = "idProveedor")
    private String idProveedor;

   @Column(name = "nomCia")
    private String nombreCia;

   @Column(name = "nomContac")
    private String nombreContacto;

   @Column(name = "direccion")
    private String direccion;

   @Column(name = "telefono")
    private String telefono;

}
