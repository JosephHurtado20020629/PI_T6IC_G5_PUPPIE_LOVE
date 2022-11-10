package com.puppie.puppie_love.Models;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "SERVICIOS")
public class Servicios {

    @Id
    @Column(name = "idPet",nullable = false)
    private String idPet;

    @Column(name = "nomPet")
    private String nomPet;

    @ManyToOne
    @JoinColumn(name = "idCategoria",insertable = false,updatable = false)
    private Categoria categoria;
    private String idCategoria;
    
    @Column(name = "estado")
    private String estado;
    

	public String getIdPet() {
		return idPet;
	}

	public void setIdPet(String idPet) {
		this.idPet = idPet;
	}

	public String getNomPet() {
		return nomPet;
	}

	public void setNomPet(String nomPet) {
		this.nomPet = nomPet;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
