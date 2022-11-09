package com.puppie.puppie_love.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Data
@Setter

public class Pedido {


    private String idPedido;

    private Cliente cliente;


    private Producto producto;


    private String idSede;

    private int cantXUnidad;

    private Date fechaPedido;


    private Date fechaAproxEntrega;


    private Date fechaEnvio;

    private String destinatario;

    private String direccionDestinatario;

    
    

}