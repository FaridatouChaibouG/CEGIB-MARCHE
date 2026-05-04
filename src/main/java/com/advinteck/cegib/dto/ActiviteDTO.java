package com.advinteck.cegib.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
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
