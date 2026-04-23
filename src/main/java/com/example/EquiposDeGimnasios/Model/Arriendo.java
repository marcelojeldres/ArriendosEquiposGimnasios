package com.example.EquiposDeGimnasios.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "arriendos")
public class Arriendo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El RUN del cliente es obligatorio")
    @Size(min = 9, max = 13, message = "El RUN debe tener entre 9 y 13 caracteres")
    @Column(unique=true, length = 13, nullable=false)
    private String runCliente;

    @NotBlank(message = "El nombre del equipo es obligatorio")
    private String nombreEquipo;

    @NotNull
    @FutureOrPresent
    private LocalDate fechaInicio;

    @NotNull
    private LocalDate fechaFin;

    @Positive(message = "La tarifa debe ser mayor a 0")
    private Double tarifaDiaria;

    private Double montoTotal;

    private String estado; // EJ: "RESERVADO", "EN CURSO", "FINALIZADO", "CANCELADO"
}
