package com.example.APIGestionDeCitasMedicas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {

    @NotNull
    private Long doctorId;

    @NotNull
    private Long pacienteId;

    @NotNull
    private String fechaCita;

    @NotNull
    private String horaCita;

    private String motivo;
}
