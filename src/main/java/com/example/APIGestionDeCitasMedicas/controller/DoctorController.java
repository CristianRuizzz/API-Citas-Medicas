package com.example.APIGestionDeCitasMedicas.controller;

import com.example.APIGestionDeCitasMedicas.DTO.DoctorDTO;
import com.example.APIGestionDeCitasMedicas.entity.CitaMedica;
import com.example.APIGestionDeCitasMedicas.entity.Doctor;
import com.example.APIGestionDeCitasMedicas.service.CitaMedicaService;
import com.example.APIGestionDeCitasMedicas.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/list")
    public ResponseEntity<List<Doctor>> listDoctor() {
        List<Doctor> doctores = doctorService.listDoctor();
        return ResponseEntity.ok(doctores);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = doctorService.registerDoctor(doctorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }


    @PutMapping("/update/{idDoctor}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long idDoctor, @RequestBody Doctor doctor) {
        try {
            Doctor updateDoctor = new Doctor();
            updateDoctor.setNombreDoctor(doctor.getNombreDoctor());
            updateDoctor.setTarjetaDoctor(doctor.getTarjetaDoctor());
            updateDoctor.setTelDoctor(doctor.getTelDoctor());
            updateDoctor.setEmailDoctor(doctor.getEmailDoctor());
            updateDoctor.setEspecialidad(doctor.getEspecialidad());


            Doctor doctorDB = doctorService.updateDoctor(idDoctor, updateDoctor);
            return ResponseEntity.ok(doctorDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idDoctor}")
    public ResponseEntity<?> deleteConductor(@PathVariable Long idDoctor) {
        try {
            doctorService.deleteDoctor(idDoctor);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

}
