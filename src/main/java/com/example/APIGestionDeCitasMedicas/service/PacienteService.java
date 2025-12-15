package com.example.APIGestionDeCitasMedicas.service;

import com.example.APIGestionDeCitasMedicas.entity.Especialidad;
import com.example.APIGestionDeCitasMedicas.entity.Paciente;

import java.util.List;

public interface PacienteService {

    Paciente registerPaciente(Paciente paciente);

    List<Paciente> listPaciente();

    Paciente updatePaciente(Long idPaciente, Paciente paciente);

    void deletePaciente(Long idPaciente);
}
