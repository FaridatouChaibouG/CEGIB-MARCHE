package com.advinteck.cegib.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NifDTO {


    private Long id;
    @NotEmpty(message = "L'identifiant est obligatoire.")
    private String identifiant;

    private Long marcheId;

    private String raisonSocial;

}
