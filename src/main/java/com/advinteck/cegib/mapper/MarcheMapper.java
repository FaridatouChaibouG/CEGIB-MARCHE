package com.advinteck.cegib.mapper;

import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.dto.NifDTO;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheNifs;
import com.advinteck.cegib.generated.marche.tables.pojos.Marches;
import com.advinteck.cegib.generated.marche.tables.pojos.VMarches;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class MarcheMapper {


    public MarcheDTO mapToMarcheDto(VMarches vMarches) {
        if (vMarches == null) {
            return null;
        }

        return MarcheDTO.builder()
                .id(vMarches.getId())
                .numMarche(vMarches.getNumeroMarche())
                .imputation(vMarches.getImputation())
                .imputationIntitule(vMarches.getImputationIntitule())
                .objetMarche(vMarches.getObjetMarche())
                .structureAutoriteContractanteCode(vMarches.getStructureAutoriteContractanteCode())
                .structureAutoriteContractanteIntutule(vMarches.getStructureAutoriteContractanteIntitule())
                .dateApprobation(vMarches.getDateApprobation().toLocalDate())
                .autoriteContractanteCode(vMarches.getAutoriteContractanteCode())
                .autoriteContractanteIntitule(vMarches.getStructureAutoriteContractanteIntitule())
                .approuvePar(vMarches.getApprouvePar())
                .titulaireMarche(vMarches.getTitulaireMarche())
                .typeMarcheCode(vMarches.getTypeMarcheCode())
                .typeMarcheIntitule(vMarches.getTypeMarcheIntitule())
                .modePassationCode(vMarches.getModeDePassationCode())
                .modePassationIntitule(vMarches.getModePassationIntitule())
                .build();
    }

    public List<MarcheDTO> maptoMarcheDtoList(List<VMarches> vMarchesList) {
        if (vMarchesList == null) {
            return null;
        }

        return vMarchesList.stream()
                .map(this::mapToMarcheDto)
                .collect(Collectors.toList());
    }

    public Marches mapToMarche(MarcheDTO marcheDTO) {
        if (marcheDTO == null) {
            return null;
        }

        Marches marches = new Marches();
        marches.setId(marcheDTO.getId());
        marches.setNumeroMarche(marcheDTO.getNumMarche());
        marches.setObjetMarche(marcheDTO.getObjetMarche());
        marches.setTitulaireMarche(marcheDTO.getTitulaireMarche());
        marches.setApprouvePar(marcheDTO.getApprouvePar());
        marches.setDateApprobation(LocalDateTime.of(marcheDTO.getDateApprobation(), LocalTime.of(0,0,0)));
        marches.setImputation(marcheDTO.getImputation());
        marches.setAutoriteContractanteCode(marcheDTO.getAutoriteContractanteCode());
        marches.setStructureAutoriteContractanteCode(marcheDTO.getStructureAutoriteContractanteCode());
        marches.setTypeMarcheCode(marcheDTO.getTypeMarcheCode());
        marches.setModeDePassationCode(marcheDTO.getModePassationCode());

        return marches;
    }

    public NifDTO mapToNifDto(MarcheNifs marcheNifs) {
        if (marcheNifs == null) {
            return null;
        }

        return NifDTO.builder()
                .id(marcheNifs.getId())
                .marcheId(marcheNifs.getMarcheId())
                .identifiant(marcheNifs.getIdentifiant())
                .raisonSocial(marcheNifs.getRaisonSocial())
                .build();
    }
}
