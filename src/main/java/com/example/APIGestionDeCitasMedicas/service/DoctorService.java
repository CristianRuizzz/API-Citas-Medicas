package com.example.APIGestionDeCitasMedicas.service;

import com.example.APIGestionDeCitasMedicas.DTO.DoctorDTO;
import com.example.APIGestionDeCitasMedicas.entity.CitaMedica;
import com.example.APIGestionDeCitasMedicas.entity.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {

    Doctor registerDoctor(DoctorDTO dto);

    List<Doctor> listDoctor();

    Doctor updateDoctor(Long idDoctor, Doctor doctor);

    void deleteDoctor(Long idDoctor);
}
