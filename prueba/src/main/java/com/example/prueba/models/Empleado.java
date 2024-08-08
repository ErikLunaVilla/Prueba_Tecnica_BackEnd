package com.example.prueba.models;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false, unique = true)
    private String curp;

    @Column
    private String puesto; // Este campo es opcional

    @Column(name = "jefe_id", nullable = true)
    private Long jefeId; //campo opcional

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    @Transient
    private List<Empleado> subordinados; // lista de los subordinados

}
