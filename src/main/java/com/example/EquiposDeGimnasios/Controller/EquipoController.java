package com.example.EquiposDeGimnasios.Controller;

import com.example.EquiposDeGimnasios.Model.Equipo;
import com.example.EquiposDeGimnasios.Service.EquipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService service;

    @GetMapping
    public ResponseEntity<List<Equipo>> listar() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<Equipo> crear(@Valid @RequestBody Equipo equipo) {
        return new ResponseEntity<>(service.guardar(equipo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
