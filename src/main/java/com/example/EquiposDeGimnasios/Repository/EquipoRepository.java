package com.example.EquiposDeGimnasios.Repository;

import com.example.EquiposDeGimnasios.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}

