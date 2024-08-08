package com.example.prueba.controlers;


import com.example.prueba.Services.DireccionService;
import com.example.prueba.models.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;


    @PostMapping
    public Direccion guardadoDireccion(@RequestBody Direccion direccion){
        return direccionService.guardarDireccion(direccion);
    }
}
