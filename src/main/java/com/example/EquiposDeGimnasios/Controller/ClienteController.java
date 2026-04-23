package com.example.EquiposDeGimnasios.Controller;


import com.example.EquiposDeGimnasios.Model.Cliente;
import com.example.EquiposDeGimnasios.Service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/clientes")
public class    ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        log.info("Consultando lista completa de clientes");
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@Valid @RequestBody Cliente cliente) {
        log.info("Registrando nuevo cliente con RUN: {}", cliente.getRun());
        Cliente nuevo = clienteService.save(cliente);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        log.warn("Eliminando cliente con ID: {}", id);
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
