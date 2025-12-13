package com.example.APIGestionDeCitasMedicas.repository;

import com.example.APIGestionDeCitasMedicas.entity.CitaMedica;
import com.example.APIGestionDeCitasMedicas.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByIdDoctor(Long idDoctor);
}
