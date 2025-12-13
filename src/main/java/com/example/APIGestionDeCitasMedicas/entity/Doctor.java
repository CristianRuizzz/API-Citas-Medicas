package com.example.APIGestionDeCitasMedicas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDoctor")
    private Long idDoctor;

    @Column(name = "nombreDoctor", nullable = false, length = 100)
    private String nombreDoctor;

    @Column(name = "tarjetaDoctor", nullable = false, length = 100)
    private String tarjetaDoctor;

    @Column(name = "telDoctor", nullable = false, length = 100)
    private String telDoctor;

    @Column(name = "emailDoctor", nullable = false, length = 100)
    private String emailDoctor;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad", referencedColumnName = "idEspecialidad")
    private Especialidad especialidad;

}
