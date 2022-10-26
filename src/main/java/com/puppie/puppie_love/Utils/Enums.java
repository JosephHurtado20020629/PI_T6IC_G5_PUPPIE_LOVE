package com.puppie.puppie_love.Utils;

public class Enums {


public enum CATEGORIAS {

        HOGAR(1, "Hogar"),
        MODA(2, "Moda"),
        TECNOLOGIA(3, "Tecnologia"),
        PAPELERIA(4, "Papeleria"),
    SALUD_Y_BELLEZA(5,"Salud y Belleza");
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
