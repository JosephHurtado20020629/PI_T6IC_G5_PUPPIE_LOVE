package com.puppie.puppie_love.Utils;

public class Enums {


public enum CATEGORIAS {

        ADOPCION(1, "Adopción"),
        FARMACIA(5, "Farmacia"),
        ALIMENTOS_PARA_PERROS(3, "Alimentos para perros"),
        ALIMENTOS_PARA_GATOS(4, "Alimentos para gatos"),
        PERROS_GUIA(2,"Perros guía"),
	    JUGUETES(6,"Juguetes"),
	    CAMAS_Y_CASAS(7,"Camas y casas");
        private Integer idCategoria;
        private String nombreCategoria;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    CATEGORIAS(Integer idCategoria, String nombreCategoria) {
            this.idCategoria = idCategoria;
            this.nombreCategoria = nombreCategoria;
        }
    }

}
