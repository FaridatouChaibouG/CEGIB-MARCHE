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
import com.advinteck.cegib.mapper.MarcheMapper;
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
    private final MarcheMapper marcheMapper;


    public MarcheService(MarchesDao marchesDao, MarcheActiviteDao marcheActiviteDao, MarcheNifsDao marcheNifsDao, MarcheRepository marcheRepository, ReferentielService referentielService, MarcheMapper marcheMapper) {
        this.marchesDao = marchesDao;
        this.marcheActiviteDao = marcheActiviteDao;
        this.marcheNifsDao = marcheNifsDao;
        this.marcheRepository = marcheRepository;

        this.referentielService = referentielService;
        this.marcheMapper = marcheMapper;
    }


    public List<MarcheDTO> marcheList(){
        return marcheRepository.findAllMarche();
    }


    public List<MarcheDTO> marcheListValide(){
        return marcheRepository.findAllMarcheValide();
    }




    public MarcheDTO save(MarcheDTO marcheDTO) {

    Marches marches = marcheMapper.mapToMarche(marcheDTO);

    marchesDao.insert(marches);

    marcheDTO.setId(marches.getId());

    // AJOUT DU TITULAIRE DANS MARCHE_NIFS
    if (marcheDTO.getTitulaireMarche() != null && !marcheDTO.getTitulaireMarche().isBlank()) {

        var refNif = referentielService
                .findOneNifsByIdentifiant(marcheDTO.getTitulaireMarche());

        if (refNif != null) {

            MarcheNifs nif = new MarcheNifs();
            nif.setMarcheId(marches.getId());
            nif.setIdentifiant(refNif.getIdentifiant());
            nif.setRaisonSocial(refNif.getRaisonSociale());

            marcheNifsDao.insert(nif);
        }
    }

    return marcheDTO;
}


public void update(MarcheDTO marcheDTO){

    // 1. update marche
    Marches marches = marcheMapper.mapToMarche(marcheDTO);

    // Si le statut passe à "valide", générer le numéro définitif
    if ("VALIDE".equals(marcheDTO.getStatut())) {
        String ancienNum = marches.getNumeroMarche();
        // Remplacer seulement si c'est encore un numéro provisoire (format M0001)
        if (ancienNum != null && ancienNum.matches("M\\d{4}")) {
            marches.setNumeroMarche(generateNumMarcheValide());
        }
    }

    marchesDao.update(marches);

    Long marcheId = marcheDTO.getId();
    String nouveauTitulaire = marcheDTO.getTitulaireMarche();

    // 2. récupérer tous les NIF du marché
    List<MarcheNifs> existingNifs = marcheNifsDao.fetchByMarcheId(marcheId);

    String ancienTitulaire = null;

    // 3. identifier l'ancien titulaire
    for (MarcheNifs nif : existingNifs) {
        if (nif.getIdentifiant() != null) {
            ancienTitulaire = nif.getIdentifiant();
            break;
        }
    }

    // 4. supprimer seulement l'ancien titulaire
    if (ancienTitulaire != null && !ancienTitulaire.equals(nouveauTitulaire)) {

        for (MarcheNifs nif : existingNifs) {
            if (ancienTitulaire.equals(nif.getIdentifiant())) {
                marcheNifsDao.deleteById(nif.getId());
            }
        }
    }

    // 5. vérifier si nouveau titulaire existe déjà
    boolean exists = existingNifs.stream()
            .anyMatch(n -> n.getIdentifiant() != null
                    && n.getIdentifiant().equals(nouveauTitulaire));

    // 6. ajouter nouveau titulaire si absent
    if (!exists) {

        var refNif = referentielService.findOneNifsByIdentifiant(nouveauTitulaire);

        if (refNif != null) {
            MarcheNifs n = new MarcheNifs();
            n.setMarcheId(marcheId);
            n.setIdentifiant(refNif.getIdentifiant());
            n.setRaisonSocial(refNif.getRaisonSociale());

            marcheNifsDao.insert(n);
        }
    }
}


    public void deleteMarche(Long id) {
        marchesDao.deleteById(id);
    }



    public Optional<MarcheDTO> findOneMarcheById(Long id) {


        return marcheRepository.findOneMarcheById(id).map(marches -> marcheMapper.mapToMarcheDto(marches));


    }



    public boolean NumeroMarcheAlreadyExists(String numMarche){
        return marchesDao.fetchOptionalByNumeroMarche(numMarche).isPresent();
    }




    public List<NifDTO> marcheNifList(Long marcheId) {
        return marcheRepository.findAllNif(marcheId);
    }

    public void savemarcheNif(NifDTO nifDTO) {
        MarcheNifs nifs = new  MarcheNifs();
        var refNif = referentielService.findOneNifsByIdentifiant(nifDTO.getIdentifiant());
        nifs.setMarcheId(nifDTO.getMarcheId());
        nifs.setIdentifiant(refNif.getIdentifiant());
        nifs.setRaisonSocial(refNif.getRaisonSociale());
        marcheNifsDao.insert(nifs);

    }


    public NifDTO findOneMarcheNifById(Long id){

        MarcheNifs nif = marcheNifsDao.fetchOneById(id);

        return marcheMapper.mapToNifDto(nif);
    }


    public void deleteNif(Long id) {
        marcheNifsDao.deleteById(id);
    }


    public List<ActiviteDTO> marcheActiviteList(Long marcheId) {
        return marcheRepository.findAllActivite(marcheId);
    }

    public void savemarcheActivite(ActiviteDTO activiteDTO) {
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




    public String generateNumMarche() {
        List<Marches> all = marchesDao.findAll();

        int max = all.stream()
                .map(Marches::getNumeroMarche)
                .filter(n -> n != null && n.matches("M\\d{4}"))
                .mapToInt(n -> Integer.parseInt(n.substring(1)))
                .max()
                .orElse(0);

        return String.format("M%04d", max + 1);
    }


    public String generateNumMarcheValide() {
        int annee = java.time.LocalDate.now().getYear() % 100; // 2026 → 26
        String pattern = String.format("\\d{4}/%02d/DGCMP/MEF", annee);

        int max = marchesDao.findAll().stream()
                .map(Marches::getNumeroMarche)
                .filter(n -> n != null && n.matches(pattern))
                .mapToInt(n -> Integer.parseInt(n.substring(0, 4)))
                .max()
                .orElse(0);

        return String.format("%04d/%02d/DGCMP/MEF", max + 1, annee);
    }




}



