package com.example.APIGestionDeCitasMedicas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {

    private String nombreDoctor;
    private String tarjetaDoctor;
    private String telDoctor;
    private String emailDoctor;

    private Long idEspecialidad;

}
