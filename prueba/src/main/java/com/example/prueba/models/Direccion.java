package com.example.prueba.models;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String calle;

    private String noExterior;

    private String noInterior;

    private String colonia;

    private String municipio;

    private String estado;

    private String pais;


}
