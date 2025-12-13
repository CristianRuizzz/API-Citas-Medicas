package com.example.APIGestionDeCitasMedicas.repository;

import com.example.APIGestionDeCitasMedicas.entity.CitaMedica;
import com.example.APIGestionDeCitasMedicas.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {

    Optional<Especialidad> findByIdEspecialidad(Long idEspecialidad);
}
