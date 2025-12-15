package com.example.APIGestionDeCitasMedicas.service.implementacion;

import com.example.APIGestionDeCitasMedicas.DTO.CitaDTO;
import com.example.APIGestionDeCitasMedicas.entity.CitaMedica;
import com.example.APIGestionDeCitasMedicas.entity.Doctor;
import com.example.APIGestionDeCitasMedicas.entity.Paciente;
import com.example.APIGestionDeCitasMedicas.repository.CitaMedicaRepository;
import com.example.APIGestionDeCitasMedicas.repository.DoctorRepository;
import com.example.APIGestionDeCitasMedicas.repository.PacienteRepository;
import com.example.APIGestionDeCitasMedicas.service.CitaMedicaService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public CitaMedica registerCita(CitaDTO citaDTO) {

        Doctor doctor = doctorRepository.findById(citaDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        Paciente paciente = pacienteRepository.findById(citaDTO.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        CitaMedica cita = new CitaMedica();
        cita.setDoctor(doctor);
        cita.setPaciente(paciente);
        cita.setFechaCita(citaDTO.getFechaCita());
        cita.setHoraCita(citaDTO.getHoraCita());
        cita.setMotivo(citaDTO.getMotivo());

        return citaMedicaRepository.save(cita);
    }

    @Override
    public List<CitaMedica> listCita() {
        return citaMedicaRepository.findAll();
    }

    @SneakyThrows
    @Override
    public CitaMedica updateCita(Long idCita, CitaMedica citaMedica) {
        CitaMedica citaExisting = citaMedicaRepository.findById(idCita)
                .orElseThrow(() -> new Exception("Product with ID:" + idCita + " not Found"));

        citaExisting.setPaciente(citaMedica.getPaciente());
        citaExisting.setDoctor(citaMedica.getDoctor());
        citaExisting.setFechaCita(citaMedica.getFechaCita());
        citaExisting.setHoraCita(citaMedica.getHoraCita());
        citaExisting.setMotivo(citaMedica.getMotivo());

        return citaMedicaRepository.save(citaExisting);
    }

    @SneakyThrows
    @Override
    public void deleteCita(Long idCita) {
        CitaMedica citaExisting = citaMedicaRepository.findByIdCita(idCita)
                .orElseThrow(() -> new Exception("Product With ID" + idCita + ("Not Found")));

        citaMedicaRepository.deleteById(idCita);
    }

    @Override
    public List<CitaMedica> citasByPaciente(Long idPaciente) {
        return citaMedicaRepository.findByPaciente_IdPaciente(idPaciente);
    }

    @Override
    public List<CitaMedica> citasByDoctor(Long idDoctor) {
        return citaMedicaRepository.findByDoctor_IdDoctor(idDoctor);
    }
}
