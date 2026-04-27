package com.advinteck.cegib.service;

import static org.mockito.Mockito.*;

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
import com.advinteck.cegib.generated.referentiel.tables.pojos.DppdActivite;
import com.advinteck.cegib.generated.referentiel.tables.pojos.Nifs;
import com.advinteck.cegib.repository.MarcheRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MarcheServiceTest {


    @Mock
    private MarchesDao marchesDao;
    @Mock
    private MarcheNifsDao marcheNifsDao;

    @InjectMocks
    private MarcheService marcheService;

    @Mock
    private MarcheActiviteDao marcheActiviteDao;

    @Mock
    private MarcheRepository marcheRepository;
    @Mock
    private ReferentielService referentielService;


    private static MarcheDTO createMarcheDto(String numMarche, String objet) {
        MarcheDTO dto = new MarcheDTO();
        dto.setNumMarche(numMarche);
        dto.setObjetMarche(objet);
        dto.setDateApprobation(LocalDate.now());
        dto.setImputation("457525");
        dto.setAutoriteContractanteCode("01");
        dto.setStructureAutoriteContractanteCode("121122");
        dto.setApprouvePar("Ministre");
        dto.setTitulaireMarche("Advinteck");
        dto.setTypeMarcheCode("01");
        dto.setModePassationCode("01");
        return dto;
    }

    private static Marches createMarche(Long id, String numMarche, String objet) {
        Marches pojo = new Marches();
        pojo.setId(id);
        pojo.setNumeroMarche(numMarche);
        pojo.setObjetMarche(objet);
        pojo.setDateApprobation(LocalDateTime.now());
        pojo.setImputation("457525");
        pojo.setAutoriteContractanteCode("01");
        pojo.setStructureAutoriteContractanteCode("121122");
        pojo.setApprouvePar("Ministre");
        pojo.setTitulaireMarche("Advinteck");
        pojo.setTypeMarcheCode("01");
        pojo.setModeDePassationCode("01");
        return pojo;
    }

    private static VMarches createVMarche(Long id, String numMarche, String objet) {
        VMarches pojo = new VMarches();
        pojo.setId(id);
        pojo.setNumeroMarche(numMarche);
        pojo.setObjetMarche(objet);
        pojo.setDateApprobation(LocalDateTime.now());
        pojo.setImputation("457525");
        pojo.setAutoriteContractanteCode("01");
        pojo.setStructureAutoriteContractanteCode("121122");
        pojo.setApprouvePar("Ministre");
        pojo.setTitulaireMarche("Advinteck");
        pojo.setTypeMarcheCode("01");
        pojo.setModeDePassationCode("01");
        return pojo;
    }

    @Test
    void testSaveMarche_Ok() throws Exception {
        MarcheDTO marcheDTO = createMarcheDto("M202600001", "Achat ordinateurs");
        marcheService.save(marcheDTO);
        verify(marchesDao, times(1)).insert(any(Marches.class));
    }

    @Test
    void testSaveMarche_Erreur() {
        doThrow(new RuntimeException("Erreur")).when(marchesDao).insert(any(Marches.class));

        MarcheDTO marcheDTO = new MarcheDTO();

        assertThrows(RuntimeException.class, () -> marcheService.save(marcheDTO));
    }


    @Test
    void testDeleteNif_Ok() {
        marcheService.deleteNif(1L);

        verify(marcheNifsDao, times(1)).deleteById(1L);
    }


//    @Test
//    void testDeleteNif_Erreur(){
//        doThrow(new RuntimeException("Erreur")).when(marcheNifsDao).insert(any(MarcheNifs.class));
//
//        NifDTO nifDTO = new NifDTO();
//
//        assertThrows(RuntimeException.class, () ->
//        {marcheService.save(nifDTO);});
//    }


    @Test
    void testNumeroMarcheAlreadyExists_Ok() {
        var pojo = createMarche(1L, "M1", "Test de marche");
        when(marchesDao.fetchOptionalByNumeroMarche("M1"))
                .thenReturn(Optional.of(pojo));

        boolean result = marcheService.NumeroMarcheAlreadyExists("M1");

        assertTrue(result);
    }

    @Test
    void testNumeroMarcheAlreadyExists_notFound() {
        when(marchesDao.fetchOptionalByNumeroMarche("M2"))
                .thenReturn(Optional.empty());

        boolean result = marcheService.NumeroMarcheAlreadyExists("M2");

        assertFalse(result);
    }

    @Test
    void testFindByNumeroMarcheOk() {
        var pojo = createVMarche(2L, "M1", "Test de marche");
        when(marcheRepository.findOneMarcheById(pojo.getId()))
                .thenReturn(Optional.of(pojo));

        var result = marcheService.findOneMarcheById(2L);
        assertTrue(result.isPresent());
        assertEquals(pojo.getId(), result.get().getId());
        assertEquals(pojo.getNumeroMarche(), result.get().getNumMarche());
        assertEquals(pojo.getObjetMarche(), result.get().getObjetMarche());
    }

    @Test
    void testFindByNumeroMarcheNotFound() {
        when(marcheRepository.findOneMarcheById(1L))
                .thenReturn(Optional.empty());

        var result = marcheService.findOneMarcheById(1L);

        assertTrue(result.isEmpty());
    }


    @Test
    void testSaveMarcheNif_Ok() throws Exception {

        Nifs ref = new Nifs();
        ref.setIdentifiant("NIF1");
        ref.setRaisonSociale("Societe");

        when(referentielService.findOneNifsByIdentifiant("NIF1"))
                .thenReturn(ref);

        NifDTO dto = new NifDTO();
        dto.setMarcheId(1L);
        dto.setIdentifiant("NIF1");

        marcheService.savemarcheNif(dto);

        verify(marcheNifsDao, times(1)).insert(any(MarcheNifs.class));
    }


    @Test
    void testSaveMarcheActivite_Ok() throws Exception {

        DppdActivite ref = new DppdActivite();
        ref.setCodeActivite("A1");

        when(referentielService.findOneActiviteByCodeActivite("A1"))
                .thenReturn(ref);


        ActiviteDTO dto = new ActiviteDTO();
        dto.setMarcheId(1L);
        dto.setCodeActivite("A1");
        dto.setMontant(100L);
        dto.setTaux(10);
        marcheService.savemarcheActivite(dto);

        verify(marcheActiviteDao, times(1)).insert(any(MarcheActivite.class));
    }


    @Test
    void testDeleteActivite_Ok() {
        marcheService.deleteActivite(1L);

        verify(marcheActiviteDao, times(1)).deleteById(1L);
    }


    @Test
    void testEditActivite_Ok() {

        ActiviteDTO dto = new ActiviteDTO();
        dto.setId(1L);
        dto.setMarcheId(1L);
        dto.setCodeActivite("A1");
        dto.setIntituleActivite("Test");
        dto.setMontant(100L);
        dto.setTaux(10);

        marcheService.editActivite(dto);

        verify(marcheActiviteDao, times(1)).update(any(MarcheActivite.class));
    }


}