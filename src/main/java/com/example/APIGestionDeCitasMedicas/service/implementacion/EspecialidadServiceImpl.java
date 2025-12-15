package com.example.APIGestionDeCitasMedicas.service.implementacion;

import com.example.APIGestionDeCitasMedicas.entity.Especialidad;
import com.example.APIGestionDeCitasMedicas.repository.EspecialidadRepository;
import com.example.APIGestionDeCitasMedicas.service.EspecialidadService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad registerEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public List<Especialidad> listEspecialidad() {
        return especialidadRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Especialidad updateEspecialidad(Long idEspecialidad, Especialidad especialidad) {
        Especialidad especialidadExisting = especialidadRepository.findById(idEspecialidad)
                .orElseThrow(() -> new Exception("Product with ID:" + idEspecialidad + " not Found"));

        especialidadExisting.setNombreEspecialidad(especialidad.getNombreEspecialidad());
        especialidadExisting.setDescEspecialidad(especialidad.getDescEspecialidad());

        return especialidadRepository.save(especialidadExisting);
    }

    @SneakyThrows
    @Override
    public void deleteEspecialidad(Long idEspecialidad) {
        Especialidad especialidadExisting = especialidadRepository.findByIdEspecialidad(idEspecialidad)
                .orElseThrow(() -> new Exception("Product With ID" + idEspecialidad + ("Not Found")));

        especialidadRepository.deleteById(idEspecialidad);
    }

    @Override
    public List<Especialidad> getEspecialidadesLimitadas(int limit) {
        return especialidadRepository
                .findAll(PageRequest.of(0, limit))
                .getContent();
    }
}
