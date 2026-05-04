package com.example.EquiposDeGimnasios.Service;

import com.example.EquiposDeGimnasios.Model.Arriendo;
import com.example.EquiposDeGimnasios.Repository.ArriendoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
public class ArriendoService {
    @Autowired
    private ArriendoRepository repository;

    public List<Arriendo> obtenerTodos() {
        log.info("Logs: Consultando historial de arriendos");
        return repository.findAll();
    }

    public Arriendo crearArriendo(Arriendo arriendo) {
        long dias = ChronoUnit.DAYS.between(arriendo.getFechaInicio(), arriendo.getFechaFin());
        if (dias <= 0) dias = 1;
        arriendo.setMontoTotal(dias * arriendo.getTarifaDiaria());
        arriendo.setEstado("EN CURSO");
        log.info("Logs: Generando arriendo para cliente {} por un total de {}", arriendo.getRunCliente(), arriendo.getMontoTotal());
        return repository.save(arriendo);
    }

    public Arriendo cambiarEstado(Long id, String nuevoEstado) {
        log.info("Logs: Actualizando arriendo ID {} a estado {}", id, nuevoEstado);
        Arriendo arriendo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Arriendo no encontrado"));
        arriendo.setEstado(nuevoEstado);
        return repository.save(arriendo);
    }
}
