package com.puppie.puppie_love.Models;


import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name="ROLES")
public class Rol {

	@Id
	@Column(name = "idRoles")
    private int idRoles;

	@Column(name = "descripcion")
    private String descripcion;


}
