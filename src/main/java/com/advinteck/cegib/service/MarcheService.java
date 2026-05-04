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
        return marcheRepository.findAllMarche();
    }


    public MarcheDTO save(MarcheDTO marcheDTO) throws Exception{
        Marches marches = new Marches();
        marches.setNumeroMarche(marcheDTO.getNumMarche());
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

        marcheDTO.setId(marches.getId());

        return marcheDTO;

    }

    public void update(MarcheDTO marcheDTO){
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
        marchesDao.update(marches);
    }



    public void deleteMarche(Long id) {
        marchesDao.deleteById(id);
    }


    public Optional<MarcheDTO> findOneMarcheById(Long id) {

        Optional<VMarches> marchesOpt = marcheRepository.findOneMarcheById(id);

        if (marchesOpt.isEmpty()) return Optional.empty();

        VMarches marches = marchesOpt.get();

        return  Optional.of(new MarcheDTO(
                marches.getId(),
                marches.getNumeroMarche(),
                marches.getImputation(),
                marches.getImputationIntitule(),
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

    public boolean NumeroMarcheAlreadyExists(String numMarche){
        return marchesDao.fetchOptionalByNumeroMarche(numMarche).isPresent();
    }




    public List<NifDTO> marcheNifList(Long marcheId) {
        return marcheRepository.findAllNif(marcheId);
    }

    public void savemarcheNif(NifDTO nifDTO) throws Exception{
        MarcheNifs nifs = new  MarcheNifs();
        var refNif = referentielService.findOneNifsByIdentifiant(nifDTO.getIdentifiant());
        nifs.setMarcheId(nifDTO.getMarcheId());
        nifs.setIdentifiant(refNif.getIdentifiant());
        nifs.setRaisonSocial(refNif.getRaisonSociale());
        marcheNifsDao.insert(nifs);

    }

    public NifDTO findOneMarcheNifById(Long id){

        MarcheNifs nif = marcheNifsDao.fetchOneById(id);
        NifDTO nifDTO = new NifDTO();
        nifDTO.setId(nif.getId());
        nifDTO.setIdentifiant(nif.getIdentifiant());
       nifDTO.setMarcheId(nif.getMarcheId());
       nifDTO.setRaisonSocial(nif.getRaisonSocial());
        return nifDTO;

    }

    public void deleteNif(Long id) {
        marcheNifsDao.deleteById(id);
    }






    public List<ActiviteDTO> marcheActiviteList(Long marcheId) {
        return marcheRepository.findAllActivite(marcheId);
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



