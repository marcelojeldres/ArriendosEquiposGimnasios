package com.example.EquiposDeGimnasios.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "equipos")
@Data // Genera getters/setters con Lombok

public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El costo es obligatorio")
    @Min(0)
    private Double costoArriendoDia;

    private Boolean disponible = true;

}