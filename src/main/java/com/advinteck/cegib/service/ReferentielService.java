package com.advinteck.cegib.service;

import com.advinteck.cegib.generated.marche.tables.daos.MarcheNifsDao;
import com.advinteck.cegib.generated.marche.tables.daos.MarchesDao;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheNifs;
import com.advinteck.cegib.generated.referentiel.tables.daos.*;
import com.advinteck.cegib.generated.referentiel.tables.pojos.*;
import com.advinteck.cegib.repository.MarcheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferentielService {
    private final MarcheRepository marcheRepository;
    private final TypesMarcheDao typesMarcheDao;
    private final ImputationDao imputationDao;
    private final AutoriteContractanteDao autoriteContractanteDao;
    private final AutoriteContractanteStructuresDao autoriteContractanteStructuresDao;
    private final ModesPassationDao modesPassationDao;
    private final NifsDao nifsDao;
    private final DppdActiviteDao dppdActiviteDao;


    public List<Imputation> imputationsList(){
        return imputationDao.findAll();
    }

    public List<AutoriteContractante> autoriteContractantesList(){
        List<AutoriteContractante> list = autoriteContractanteDao.findAll();
        return list;
    }


    public List<AutoriteContractanteStructures>  structureAutoriteContractantesList(){
        return autoriteContractanteStructuresDao.findAll();
    }



    public List<TypesMarche> typeMarchesList(){
        return typesMarcheDao.findAll();
    }

    public List<ModesPassation> modePassationsList(){
        return modesPassationDao.findAll();
    }

    public List<Nifs> nifsList(){
        return nifsDao.findAll();
    }

    public Nifs findOneNifsByIdentifiant(String identifiant){
        return nifsDao.fetchOneByIdentifiant(identifiant);
    }

    public List<DppdActivite> dppdActiviteList(){
        return dppdActiviteDao.findAll();
    }

    public DppdActivite findOneActiviteByCodeActivite(String codeActivite){
        return  dppdActiviteDao.fetchOneByCodeActivite(codeActivite);

    }

    public List<DppdActivite> dppdActiviteListByImputation(String imputation) {
        if (imputation == null || imputation.length() < 5) return List.of();

        String sectionCode   = imputation.substring(0, 2);
        String programmeCode = imputation.substring(2, 5);

        return dppdActiviteDao.findAll()
                .stream()
                .filter(a -> sectionCode.equals(a.getSectionCode())
                        && programmeCode.equals(a.getProgrammeCode()))
                .toList();
    }




}
