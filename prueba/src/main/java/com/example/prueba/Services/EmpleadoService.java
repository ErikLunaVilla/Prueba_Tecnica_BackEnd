package com.example.prueba.Services;

import com.example.prueba.models.Empleado;
import com.example.prueba.repository.EmpleadoRepository;
import com.example.prueba.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado registraEmpleado(Empleado empleado){

        // Hay que generar una clave única
        String claveUnica = empleado.getCurp().substring(0,10)
                + generarDigitosExtra();
        empleado.setCurp(claveUnica);
        return empleadoRepository.save(empleado);
    }

    private String generarDigitosExtra() {
        Random random = new Random();
        int digitos = random.nextInt(100); //generamos un número entre 0 y 99
        return String.format("%02d", digitos);
    }

    public Empleado modificarPuesto(Long empleadoId, String nuevoPuesto){
        Empleado empleado = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));
        empleado.setPuesto(nuevoPuesto);
        return empleadoRepository.save(empleado);
    }

    public Empleado modificarJefe(Long empleadoId, Long nuevoJefeId){
        Empleado empleado = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado"));
        empleado.setJefeId(nuevoJefeId);
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> obtenerEmpleadosConSubordinados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        for (Empleado jefe : empleados) {
            List<Empleado> subordinados = empleadoRepository.findByJefeId(jefe.getId());
            jefe.setSubordinados(subordinados);
        }
        return empleados;
    }

}
