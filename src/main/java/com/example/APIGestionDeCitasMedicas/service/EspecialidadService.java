package com.example.APIGestionDeCitasMedicas.service;

import com.example.APIGestionDeCitasMedicas.entity.Doctor;
import com.example.APIGestionDeCitasMedicas.entity.Especialidad;

import java.util.List;

public interface EspecialidadService {

    Especialidad registerEspecialidad(Especialidad especialidad);

    List<Especialidad> listEspecialidad();

    Especialidad updateEspecialidad(Long idEspecialidad, Especialidad especialidad);

    void deleteEspecialidad(Long idEspecialidad);

    List<Especialidad> getEspecialidadesLimitadas(int limit);
}
