package com.example.APIGestionDeCitasMedicas.controller;

import com.example.APIGestionDeCitasMedicas.entity.Doctor;
import com.example.APIGestionDeCitasMedicas.entity.Especialidad;
import com.example.APIGestionDeCitasMedicas.service.DoctorService;
import com.example.APIGestionDeCitasMedicas.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/list")
    public ResponseEntity<List<Especialidad>> listEspecialidad() {
        List<Especialidad> especialidades = especialidadService.listEspecialidad();
        return ResponseEntity.ok(especialidades);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerEspecialidad(@RequestBody Especialidad especialidad){
        Especialidad newEspecialidad = especialidadService.registerEspecialidad(especialidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEspecialidad);
    }


    @PutMapping("/update/{idEspecialidad}")
    public ResponseEntity<?> updateEspecialidad(@PathVariable Long idEspecialidad, @RequestBody Especialidad especialidad) {
        try {
            Especialidad updateEspecialidad = new Especialidad();
            updateEspecialidad.setNombreEspecialidad(especialidad.getNombreEspecialidad());
            updateEspecialidad.setDescEspecialidad(especialidad.getDescEspecialidad());;


            Especialidad especialidadDB = especialidadService.updateEspecialidad(idEspecialidad, updateEspecialidad);
            return ResponseEntity.ok(especialidadDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idEspecialidad}")
    public ResponseEntity<?> deleteConductor(@PathVariable Long idEspecialidad) {
        try {
            especialidadService.deleteEspecialidad(idEspecialidad);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> especialidadesLimit(
            @RequestParam(defaultValue = "10") int limit) {

        return ResponseEntity.ok(
                especialidadService.getEspecialidadesLimitadas(limit)
        );
    }

}
