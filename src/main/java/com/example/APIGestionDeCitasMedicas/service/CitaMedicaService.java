package com.example.APIGestionDeCitasMedicas.service;

import com.example.APIGestionDeCitasMedicas.DTO.CitaDTO;
import com.example.APIGestionDeCitasMedicas.entity.CitaMedica;

import java.util.List;

public interface CitaMedicaService {

    CitaMedica registerCita(CitaDTO citaDTO);

    List<CitaMedica> listCita();

    CitaMedica updateCita(Long idCita, CitaMedica citaMedica);

    void deleteCita(Long idCita);

    List<CitaMedica> citasByPaciente(Long idPaciente);

    List<CitaMedica> citasByDoctor(Long idDoctor);
}
