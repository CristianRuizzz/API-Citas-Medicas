package com.example.APIGestionDeCitasMedicas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita")
    private Long idCita;

    @ManyToOne
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idDoctor", referencedColumnName = "idDoctor")
    private Doctor doctor;

    @Column(name = "fechaCita", nullable = false, length = 100)
    private String fechaCita;

    @Column(name = "horaCita", nullable = false, length = 100)
    private String horaCita;

    @Column(name = "motivoCita", nullable = false, length = 100)
    private String motivo;
}
