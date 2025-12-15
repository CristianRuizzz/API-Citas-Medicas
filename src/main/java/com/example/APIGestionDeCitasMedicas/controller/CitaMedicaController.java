package com.example.APIGestionDeCitasMedicas.controller;

import com.example.APIGestionDeCitasMedicas.DTO.CitaDTO;
import com.example.APIGestionDeCitasMedicas.entity.CitaMedica;
import com.example.APIGestionDeCitasMedicas.service.CitaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaMedicaController {

    @Autowired
    private CitaMedicaService citaMedicaService;

    @GetMapping("/list")
    public ResponseEntity<List<CitaMedica>> listCita() {
        List<CitaMedica> citasMedicas = citaMedicaService.listCita();
        return ResponseEntity.ok(citasMedicas);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCita(@RequestBody CitaDTO citaDTO) {
        CitaMedica cita = citaMedicaService.registerCita(citaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cita);
    }


    @PutMapping("/update/{idCita}")
    public ResponseEntity<?> updateCita(@PathVariable Long idCita, @RequestBody CitaMedica citaMedica) {
        try {
            CitaMedica updateCita = new CitaMedica();
            updateCita.setPaciente(citaMedica.getPaciente());
            updateCita.setDoctor(citaMedica.getDoctor());
            updateCita.setFechaCita(citaMedica.getFechaCita());
            updateCita.setHoraCita(citaMedica.getHoraCita());
            updateCita.setMotivo(citaMedica.getMotivo());


            CitaMedica citaDB = citaMedicaService.updateCita(idCita, updateCita);
            return ResponseEntity.ok(citaDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idCita}")
    public ResponseEntity<?> deleteCita(@PathVariable Long idCita) {
        try {
            citaMedicaService.deleteCita(idCita);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<CitaMedica>> getCitasByPaciente(
            @PathVariable Long idPaciente) {

        List<CitaMedica> citas = citaMedicaService.citasByPaciente(idPaciente);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/doctor/{idDoctor}")
    public ResponseEntity<List<CitaMedica>> getCitasByDoctor(
            @PathVariable Long idDoctor) {

        List<CitaMedica> citas = citaMedicaService.citasByDoctor(idDoctor);
        return ResponseEntity.ok(citas);
    }
}
