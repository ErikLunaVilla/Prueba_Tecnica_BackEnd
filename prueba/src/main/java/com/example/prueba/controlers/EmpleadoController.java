package com.example.prueba.controlers;


import com.example.prueba.Services.EmpleadoService;
import com.example.prueba.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<Empleado> registrarEmpleado(@RequestBody Empleado empleado){
        Empleado nuevoEmpleado = empleadoService.registraEmpleado(empleado);
        return ResponseEntity.ok(nuevoEmpleado);
    }

    @PutMapping("/{id}/puesto")
    public ResponseEntity<Empleado> modificarPuesto(@PathVariable Long id, @RequestParam String nuevoPuesto){
        Empleado empleadoActualizado = empleadoService.modificarPuesto(id, nuevoPuesto);
        return ResponseEntity.ok(empleadoActualizado);
    }

    @PutMapping("{id}/jefe")
    public ResponseEntity<Empleado> modificarJefe(@PathVariable Long id, @RequestParam Long nuevoJefeId) {
        Empleado empleadoActualizado = empleadoService.modificarJefe(id, nuevoJefeId);
        return ResponseEntity.ok(empleadoActualizado);
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados(){
        List<Empleado> empleados = empleadoService.obtenerEmpleadosConSubordinados();
        return ResponseEntity.ok(empleados);
    }
}
