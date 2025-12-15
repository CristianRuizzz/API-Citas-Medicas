package com.example.APIGestionDeCitasMedicas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private Long idPaciente;

    @Column(name = "nombrePaciente", nullable = false, length = 100)
    private String nombrePaciente;

    @Column(name = "docPaciente", nullable = false, length = 100)
    private String docPaciente;

    @Column(name = "telPaciente", nullable = false, length = 100)
        private String telPaciente;

    @Column(name = "emailPaciente", nullable = false, length = 100)
    private String emailPaciente;

    @Column(name = "direccionPaciente", nullable = false, length = 100)
    private String direccionPaciente;
}
