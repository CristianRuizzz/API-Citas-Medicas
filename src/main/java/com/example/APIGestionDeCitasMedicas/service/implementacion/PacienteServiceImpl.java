package com.example.APIGestionDeCitasMedicas.service.implementacion;

import com.example.APIGestionDeCitasMedicas.entity.Especialidad;
import com.example.APIGestionDeCitasMedicas.entity.Paciente;
import com.example.APIGestionDeCitasMedicas.repository.EspecialidadRepository;
import com.example.APIGestionDeCitasMedicas.repository.PacienteRepository;
import com.example.APIGestionDeCitasMedicas.service.PacienteService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente registerPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> listPaciente() {
        return pacienteRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Paciente updatePaciente(Long idPaciente, Paciente paciente) {
        Paciente pacienteExisting = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new Exception("Product with ID:" + idPaciente + " not Found"));

        pacienteExisting.setNombrePaciente(paciente.getNombrePaciente());
        pacienteExisting.setDocPaciente(paciente.getDocPaciente());
        pacienteExisting.setTelPaciente(paciente.getTelPaciente());
        pacienteExisting.setEmailPaciente(paciente.getEmailPaciente());
        pacienteExisting.setDireccionPaciente(paciente.getDireccionPaciente());

        return pacienteRepository.save(pacienteExisting);
    }

    @SneakyThrows
    @Override
    public void deletePaciente(Long idPaciente) {
        Paciente pacienteExisting = pacienteRepository.findByIdPaciente(idPaciente)
                .orElseThrow(() -> new Exception("Product With ID" + idPaciente + ("Not Found")));

        pacienteRepository.deleteById(idPaciente);
    }
}
