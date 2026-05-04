package com.example.EquiposDeGimnasios.Service;

import com.example.EquiposDeGimnasios.Model.Cliente;
import com.example.EquiposDeGimnasios.Repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        log.info("Logs: Listando todos los clientes desde la base de datos");
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        log.info("Logs: Buscando cliente con ID: {}", id);
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        log.info("Logs: Guardando cliente: {} {}", cliente.getNombres(), cliente.getApellidos());
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        log.warn("Logs: Eliminando cliente con ID: {}", id);
        clienteRepository.deleteById(id);
    }
}
