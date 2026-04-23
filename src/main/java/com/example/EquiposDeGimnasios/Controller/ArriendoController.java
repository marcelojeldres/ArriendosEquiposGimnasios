package com.example.EquiposDeGimnasios.Controller;

import com.example.EquiposDeGimnasios.Model.Arriendo;
import com.example.EquiposDeGimnasios.Service.ArriendoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/arriendos")
public class ArriendoController {

    @Autowired
    private ArriendoService service;

    // 1. Listar todos (Para la tabla del administrador)
    @GetMapping
    public List<Arriendo> listar() {
        return service.obtenerTodos();
    }

    // 2. Crear arriendo (El formulario de arriendo)
    @PostMapping
    public ResponseEntity<Arriendo> guardar(@Valid @RequestBody Arriendo arriendo) {
        return ResponseEntity.ok(service.crearArriendo(arriendo));
    }

    // 3. Finalizar arriendo (Cuando devuelven el equipo)
    @PatchMapping("/{id}/finalizar")
    public ResponseEntity<Arriendo> finalizar(@PathVariable Long id) {
        return ResponseEntity.ok(service.cambiarEstado(id, "FINALIZADO"));
    }

    // 4. Cancelar arriendo
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Arriendo> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(service.cambiarEstado(id, "CANCELADO"));
    }
}