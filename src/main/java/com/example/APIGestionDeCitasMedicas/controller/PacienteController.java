package com.example.APIGestionDeCitasMedicas.controller;

import com.example.APIGestionDeCitasMedicas.entity.CitaMedica;
import com.example.APIGestionDeCitasMedicas.entity.Especialidad;
import com.example.APIGestionDeCitasMedicas.entity.Paciente;
import com.example.APIGestionDeCitasMedicas.service.EspecialidadService;
import com.example.APIGestionDeCitasMedicas.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/list")
    public ResponseEntity<List<Paciente>> listPaciente() {
        List<Paciente> pacientes = pacienteService.listPaciente();
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerPaciente(@RequestBody Paciente paciente){
        Paciente newPaciente = pacienteService.registerPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaciente);
    }


    @PutMapping("/update/{idPaciente}")
    public ResponseEntity<?> updatePaciente(@PathVariable Long idPaciente, @RequestBody Paciente paciente) {
        try {
            Paciente updatePaciente = new Paciente();
            updatePaciente.setNombrePaciente(paciente.getNombrePaciente());
            updatePaciente.setDocPaciente(paciente.getDocPaciente());
            updatePaciente.setTelPaciente(paciente.getTelPaciente());
            updatePaciente.setEmailPaciente(paciente.getEmailPaciente());
            updatePaciente.setDireccionPaciente(paciente.getDireccionPaciente());;


            Paciente pacienteDB = pacienteService.updatePaciente(idPaciente, updatePaciente);
            return ResponseEntity.ok(pacienteDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idPaciente}")
    public ResponseEntity<?> deleteConductor(@PathVariable Long idPaciente) {
        try {
            pacienteService.deletePaciente(idPaciente);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

}
