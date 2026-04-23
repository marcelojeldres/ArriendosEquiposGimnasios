package com.example.EquiposDeGimnasios.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name= "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado a Long

    @NotBlank(message = "El RUN no puede estar vacío")
    @Size(min = 9, max = 13, message = "El RUN debe tener entre 9 y 13 caracteres")
    @Column(unique=true, length = 13, nullable=false)
    private String run;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable=false)
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(nullable=false)
    private String apellidos;

    @Column(nullable=true)
    private Date fechaNacimiento;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un formato de correo válido")
    @Column(nullable=false)
    private String correo;
}