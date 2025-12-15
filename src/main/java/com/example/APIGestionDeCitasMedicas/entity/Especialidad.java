package com.example.APIGestionDeCitasMedicas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecialidad")
    private Long idEspecialidad;

    @Column(name = "nombreEspecialidad", nullable = false, length = 100)
    private String nombreEspecialidad;

    @Column(name = "descEspecilidad", nullable = false, length = 100)
    private String descEspecialidad;
}
