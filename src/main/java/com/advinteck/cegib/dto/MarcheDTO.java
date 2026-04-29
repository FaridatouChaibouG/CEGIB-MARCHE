package com.advinteck.cegib.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcheDTO {

    private Long id;
//    @NotEmpty(message = "Le numéro de marché est obligatoire.")
//    private String numMarche;
    @NotEmpty(message = "L'imputation est obligatoire.")
    private String imputation;
    private String imputationIntitule;
    @NotEmpty(message = "L'objet du marché est obligatoire.")
    private String objetMarche;
    @NotNull(message = "La date d'approbation est obligatoire.")
    private LocalDate dateApprobation;
    @NotEmpty(message = "L'autorité ccontractante est obligatoire.")
    private String autoriteContractanteCode;
    private String autoriteContractanteIntitule;
    @NotEmpty(message = "La structure de l'autorité contractante est obligatoire.")
    private String structureAutoriteContractanteCode;
    private String structureAutoriteContractanteIntutule;
    @NotEmpty(message = "L'approbation est obligatoire.")
    private String approuvePar;
//    @NotEmpty(message = "Le titulaire de marché est obligatoire.")
//  private String titulaireMarche;
    @NotEmpty(message = "Le type de marché est obligatoire.")
    private String typeMarcheCode;
    private String typeMarcheIntitule;
    @NotEmpty(message = "Le mode de passation est obligatoire.")
    private String modePassationCode;
    private String modePassationIntitule;

}
