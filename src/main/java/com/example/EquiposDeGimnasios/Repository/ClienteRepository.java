package com.example.EquiposDeGimnasios.Repository;

import com.example.EquiposDeGimnasios.Model.Arriendo;
import com.example.EquiposDeGimnasios.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
