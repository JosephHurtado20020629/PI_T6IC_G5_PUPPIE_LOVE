package com.puppie.puppie_love.Models;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CATEGORIAS")
public class Categoria {
	@Id
	@Column(name = "idCategoria")
	private String idCategoria;

	@Column(name = "nomCategoria")
	private String nombreCategoria;
}
