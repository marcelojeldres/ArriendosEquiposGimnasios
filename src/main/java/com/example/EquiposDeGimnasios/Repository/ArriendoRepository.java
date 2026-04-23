package com.example.EquiposDeGimnasios.Repository;

import com.example.EquiposDeGimnasios.Model.Arriendo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArriendoRepository extends JpaRepository<Arriendo, Long> {
}
