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
   @Column(name = "ID_PROVEEDOR")
    private String idProveedor;

   @Column(name = "NOMBRE_CIA")
    private String nombreCia;

   @Column(name = "NOMBRE_CONTACTO")
    private String nombreContacto;

   @Column(name = "DIRECCION")
    private String direccion;

   @Column(name = "TELEFONO")
    private String telefono;

}
