package com.advinteck.cegib.service;


import com.advinteck.cegib.dto.ActiviteDTO;
import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.dto.NifDTO;
import com.advinteck.cegib.generated.marche.tables.daos.MarcheActiviteDao;
import com.advinteck.cegib.generated.marche.tables.daos.MarcheNifsDao;
import com.advinteck.cegib.generated.marche.tables.daos.MarchesDao;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheActivite;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheNifs;
import com.advinteck.cegib.generated.marche.tables.pojos.Marches;
import com.advinteck.cegib.generated.marche.tables.pojos.VMarches;
import com.advinteck.cegib.generated.referentiel.tables.daos.*;
import com.advinteck.cegib.generated.referentiel.tables.pojos.*;
import com.advinteck.cegib.repository.MarcheRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class MarcheService {


    private final MarchesDao marchesDao;
    private final MarcheActiviteDao marcheActiviteDao;
    private final MarcheNifsDao marcheNifsDao;
    private final MarcheRepository marcheRepository;
private final ReferentielService referentielService;

    public MarcheService(MarchesDao marchesDao, MarcheActiviteDao marcheActiviteDao, MarcheNifsDao marcheNifsDao, MarcheRepository marcheRepository, ReferentielService referentielService) {
        this.marchesDao = marchesDao;
        this.marcheActiviteDao = marcheActiviteDao;
        this.marcheNifsDao = marcheNifsDao;
        this.marcheRepository = marcheRepository;

        this.referentielService = referentielService;
    }




    public List<MarcheDTO> marcheList(){
        List<VMarches> marchesList = marcheRepository.findAll();
        List<MarcheDTO> marcheDTOList = new ArrayList<>();
        for (var marches: marchesList){
            MarcheDTO marcheDTO = new MarcheDTO(marches.getId(),  marches.getImputation(), marches.getObjetMarche(), marches.getDateApprobation().toLocalDate(),
                    marches.getAutoriteContractanteCode(), marches.getAutoriteContractanteIntitule(), marches.getStructureAutoriteContractanteCode(), marches.getStructureAutoriteContractanteIntitule(),marches.getApprouvePar(),
                    marches.getTitulaireMarche(), marches.getTypeMarcheCode(), marches.getTypeMarcheIntitule(), marches.getModeDePassationCode(), marches.getModePassationIntitule());
            marcheDTOList.add(marcheDTO);
        }
        return marcheDTOList;
    }





    public List<NifDTO> marcheNifList(Long marcheId){
        List<MarcheNifs> marcheNifsList = marcheRepository.findAllNif(marcheId);
        List<NifDTO> nifDTOList = new ArrayList<>();
        for (var nifs: marcheNifsList){
            NifDTO nifDTO = new NifDTO(nifs.getId(), nifs.getIdentifiant(), nifs.getMarcheId(), nifs.getRaisonSocial());
            nifDTOList.add(nifDTO);
        }
        return nifDTOList;
    }


    public void savemarcheNif(NifDTO nifDTO) throws Exception{
        MarcheNifs nifs = new  MarcheNifs();
        var refNif = referentielService.findOneNifsByIdentifiant(nifDTO.getIdentifiant());
        nifs.setMarcheId(nifDTO.getMarcheId());
        nifs.setIdentifiant(refNif.getIdentifiant());
        nifs.setRaisonSocial(refNif.getRaisonSociale());
        marcheNifsDao.insert(nifs);

    }




    public void savemarcheActivite(ActiviteDTO activiteDTO) throws Exception{
        MarcheActivite activite = new MarcheActivite();
        var refActivite = referentielService.findOneActiviteByCodeActivite(activiteDTO.getCodeActivite());
        activite.setMarcheId(activiteDTO.getMarcheId());
        activite.setCodeActivite(refActivite.getCodeActivite());
        activite.setIntituleActivite(refActivite.getIntituleActivite());
        activite.setMontant(activiteDTO.getMontant());
        activite.setTaux(activiteDTO.getTaux());
        marcheActiviteDao.insert(activite);

    }




    public void save(MarcheDTO marcheDTO) throws Exception{
        Marches marches = new Marches();
//        marches.setNumeroMarche(marcheDTO.getNumMarche());
        marches.setImputation(marcheDTO.getImputation());
        marches.setObjetMarche(marcheDTO.getObjetMarche());
        marches.setDateApprobation(LocalDateTime.of(marcheDTO.getDateApprobation(), LocalTime.of(0,0,0)));
        marches.setAutoriteContractanteCode(marcheDTO.getAutoriteContractanteCode());
        marches.setStructureAutoriteContractanteCode(marcheDTO.getStructureAutoriteContractanteCode());
        marches.setApprouvePar(marcheDTO.getApprouvePar());
        marches.setTitulaireMarche(marcheDTO.getTitulaireMarche());
        marches.setTypeMarcheCode(marcheDTO.getTypeMarcheCode());
        marches.setModeDePassationCode(marcheDTO.getModePassationCode());

        marchesDao.insert(marches);

    }



    public Optional<MarcheDTO> findOneMarcheById(Long id) {

        Optional<VMarches> marchesOpt = marcheRepository.findOneMarcheById(id);

        if (marchesOpt.isEmpty()) return Optional.empty();

        VMarches marches = marchesOpt.get();

        return  Optional.of(new MarcheDTO(
                marches.getId(),
//                marches.getNumeroMarche(),
                marches.getImputation(),
                marches.getObjetMarche(),
                marches.getDateApprobation().toLocalDate(),
                marches.getAutoriteContractanteCode(),
                marches.getAutoriteContractanteIntitule(),
                marches.getStructureAutoriteContractanteCode(),
                marches.getStructureAutoriteContractanteIntitule(),
                marches.getApprouvePar(),
                marches.getTitulaireMarche(),
                marches.getTypeMarcheCode(),
                marches.getTypeMarcheIntitule(),
                marches.getModeDePassationCode(),
                marches.getModePassationIntitule()



        ));
    }


    public NifDTO findOneMarcheNifById(Long id){

        MarcheNifs nif = marcheNifsDao.fetchOneById(id);
        NifDTO nifDTO = new NifDTO();
        nifDTO.setId(nif.getId());
        nifDTO.setIdentifiant(nif.getIdentifiant());
       nifDTO.setMarcheId(nif.getMarcheId());
       nifDTO.setRaisonSociale(nif.getRaisonSocial());
        return nifDTO;

    }



    public ActiviteDTO findOneActiviteByCodeActivite(Long id){

        MarcheActivite activite = marcheActiviteDao.fetchOneById(id);
        ActiviteDTO activiteDTO = new ActiviteDTO();
        activiteDTO.setId(activite.getId());
        activiteDTO.setCodeActivite(activite.getCodeActivite());
        activiteDTO.setIntituleActivite(activite.getIntituleActivite());
        activiteDTO.setMontant(activite.getMontant());
        activiteDTO.setTaux(activite.getTaux());
        activiteDTO.setMarcheId(activite.getMarcheId());

        return activiteDTO;

    }




    public void deleteNif(Long id) {
        marcheNifsDao.deleteById(id);
    }


    public void editNif(NifDTO nifDTO){
        MarcheNifs marcheNifs = new MarcheNifs();
        marcheNifs.setId(nifDTO.getId()); // On garde l'ID de la ligne
        marcheNifs.setMarcheId(nifDTO.getMarcheId()); // On garde l'ID du marché parent
        marcheNifs.setIdentifiant(nifDTO.getIdentifiant()); // On met le NIF dans la bonne colonne

        marcheNifsDao.update(marcheNifs);
    }





    public boolean NumeroMarcheAlreadyExists(String numMarche){
        return marchesDao.fetchOptionalByNumeroMarche(numMarche).isPresent();
    }




    public List<ActiviteDTO> marcheActiviteList(Long marcheId){
        List<MarcheActivite> marcheActiviteList = marcheRepository.findAllActivite(marcheId);
        List<ActiviteDTO> activiteDTOList = new ArrayList<>();
        for (var activites: marcheActiviteList){
            ActiviteDTO activiteDTO = new  ActiviteDTO(activites.getId(), activites.getMarcheId(), activites.getCodeActivite(), activites.getIntituleActivite(), activites.getTaux(), activites.getMontant());
            activiteDTOList.add(activiteDTO);
        }
        return activiteDTOList;
    }



    public void deleteActivite(Long id) {
        marcheActiviteDao.deleteById(id);
    }




    public void editActivite(ActiviteDTO activiteDTO){
        MarcheActivite marcheActivite = new MarcheActivite() ;
         marcheActivite.setId(activiteDTO.getId());
         marcheActivite.setMarcheId(activiteDTO.getMarcheId());
         marcheActivite.setCodeActivite(activiteDTO.getCodeActivite());
         marcheActivite.setIntituleActivite(activiteDTO.getIntituleActivite());
         marcheActivite.setMontant(activiteDTO.getMontant());
         marcheActivite.setTaux(activiteDTO.getTaux());

        marcheActiviteDao.update(marcheActivite);
    }



}



