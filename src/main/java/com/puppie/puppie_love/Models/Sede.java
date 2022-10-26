package com.puppie.puppie_love.Models;

import lombok.Data;


@Data
public class Sede {
    public Sede(String idSede, String nomSede, String dirSede, String nroSede, String codUsuario) {
        this.idSede = idSede;
        this.nomSede = nomSede;
        this.dirSede = dirSede;
        this.nroSede = nroSede;
        this.codUsuario = codUsuario;
    }

    public Sede() {
        // TODO Auto-generated constructor stub
    }

  
    private String idSede;

    private String nomSede;

    private String dirSede;

    private String nroSede;

    private String codUsuario;

}
