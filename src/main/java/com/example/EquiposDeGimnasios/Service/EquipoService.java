package com.example.EquiposDeGimnasios.Service;

import com.example.EquiposDeGimnasios.Model.Equipo;
import com.example.EquiposDeGimnasios.Repository.EquipoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j // Para los Logs que pide la pauta
public class EquipoService {

    @Autowired
    private EquipoRepository repository;

    public List<Equipo> obtenerTodos() {
        log.info("Consultando todos los equipos");
        return repository.findAll();
    }

    public Equipo guardar(Equipo equipo) {
        log.info("Guardando nuevo equipo: {}", equipo.getNombre());
        return repository.save(equipo);
    }

    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }
}