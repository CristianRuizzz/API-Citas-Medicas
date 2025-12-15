package com.example.APIGestionDeCitasMedicas.repository;

import com.example.APIGestionDeCitasMedicas.entity.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {
    Optional<CitaMedica> findByIdCita(Long idCita);

    List<CitaMedica> findByPaciente_IdPaciente(Long idPaciente);

    List<CitaMedica> findByDoctor_IdDoctor(Long idDoctor);
}
