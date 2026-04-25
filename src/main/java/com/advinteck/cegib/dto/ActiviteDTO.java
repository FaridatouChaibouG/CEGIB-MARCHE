package com.advinteck.cegib.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiviteDTO {


    private Long id;
    private Long marcheId;
    private String codeActivite;
    private String intituleActivite;
    private Integer taux;
    private Long montant;
}
