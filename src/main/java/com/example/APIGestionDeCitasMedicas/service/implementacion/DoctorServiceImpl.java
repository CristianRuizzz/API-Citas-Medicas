package com.example.APIGestionDeCitasMedicas.service.implementacion;

import com.example.APIGestionDeCitasMedicas.DTO.DoctorDTO;
import com.example.APIGestionDeCitasMedicas.entity.Doctor;
import com.example.APIGestionDeCitasMedicas.entity.Especialidad;
import com.example.APIGestionDeCitasMedicas.repository.DoctorRepository;
import com.example.APIGestionDeCitasMedicas.repository.EspecialidadRepository;
import com.example.APIGestionDeCitasMedicas.service.DoctorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Doctor registerDoctor(DoctorDTO dto) {

        Especialidad especialidad = especialidadRepository.findById(dto.getIdEspecialidad())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        Doctor doctor = new Doctor();
        doctor.setNombreDoctor(dto.getNombreDoctor());
        doctor.setTarjetaDoctor(dto.getTarjetaDoctor());
        doctor.setTelDoctor(dto.getTelDoctor());
        doctor.setEmailDoctor(dto.getEmailDoctor());
        doctor.setEspecialidad(especialidad);

        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> listDoctor() {
        return doctorRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Doctor updateDoctor(Long idDoctor, Doctor doctor) {
        Doctor doctorExisting = doctorRepository.findById(idDoctor)
                .orElseThrow(() -> new Exception("Product with ID:" + idDoctor + " not Found"));

        doctorExisting.setNombreDoctor(doctor.getNombreDoctor());
        doctorExisting.setTarjetaDoctor(doctor.getTarjetaDoctor());
        doctorExisting.setTelDoctor(doctor.getTelDoctor());
        doctorExisting.setEmailDoctor(doctor.getEmailDoctor());
        doctorExisting.setEspecialidad(doctor.getEspecialidad());

        return doctorRepository.save(doctorExisting);
    }

    @SneakyThrows
    @Override
    public void deleteDoctor(Long idDoctor) {
        Doctor doctorExisting = doctorRepository.findByIdDoctor(idDoctor)
                .orElseThrow(() -> new Exception("Product With ID" + idDoctor + ("Not Found")));

        doctorRepository.deleteById(idDoctor);
    }
}
