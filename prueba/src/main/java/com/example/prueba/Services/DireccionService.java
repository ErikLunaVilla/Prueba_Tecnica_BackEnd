package com.example.prueba.Services;


import com.example.prueba.models.Direccion;
import com.example.prueba.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    public Direccion guardarDireccion(Direccion direccion){
        return direccionRepository.save(direccion);
    }
}
