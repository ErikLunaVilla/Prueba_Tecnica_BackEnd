package com.example.prueba.repository;

import com.example.prueba.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findByJefeId(Long jefeId);
}
