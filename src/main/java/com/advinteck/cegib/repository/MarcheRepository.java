package com.advinteck.cegib.repository;
import com.advinteck.cegib.dto.ActiviteDTO;
import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.dto.NifDTO;
import com.advinteck.cegib.generated.marche.Tables;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheActivite;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheNifs;
import com.advinteck.cegib.generated.marche.tables.pojos.VMarches;
import com.advinteck.cegib.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.advinteck.cegib.generated.marche.Tables.MARCHE_ACTIVITE;
import static com.advinteck.cegib.generated.marche.Tables.MARCHE_NIFS;
import static com.advinteck.cegib.generated.marche.tables.VMarches.V_MARCHES;

@Repository
@RequiredArgsConstructor
public class MarcheRepository {

    private final DSLContext dsl;

    public Optional<VMarches> findOneMarcheById(Long id) {

        return dsl
                .selectFrom(Tables.V_MARCHES)
                .where(Tables.V_MARCHES.ID.eq(id))
                .fetchOptionalInto(VMarches.class);
    }


    public List<MarcheDTO> findAllMarche() {
        return dsl
                .select(V_MARCHES.ID, V_MARCHES.NUMERO_MARCHE.as("numMarche"), V_MARCHES.OBJET_MARCHE, V_MARCHES.TYPE_MARCHE_INTITULE, V_MARCHES.MODE_PASSATION_INTITULE, V_MARCHES.DATE_APPROBATION)
                .from(V_MARCHES)
                .where(Tables.V_MARCHES.STATUT.eq(Constants.EN_ATTENTE))
                .orderBy(V_MARCHES.ID.desc())
                .fetchInto(MarcheDTO.class);
    }

//    public List<VMarches> findAllValidated() {
//        return dsl
//                .selectFrom(Tables.V_MARCHES)
//                .where(Tables.V_MARCHES.STATUT.eq("VALIDER"))
//                .fetchInto(VMarches.class);
//    }





    public List<NifDTO> findAllNif(Long marcheId) {
        return dsl
                .select(MARCHE_NIFS.ID, MARCHE_NIFS.IDENTIFIANT, MARCHE_NIFS.MARCHE_ID, MARCHE_NIFS.RAISON_SOCIAL.as("raisonSocial"))
                .from(MARCHE_NIFS)
                .where(MARCHE_NIFS.MARCHE_ID.eq(marcheId))
                .fetchInto(NifDTO.class);
    }




    public List<ActiviteDTO> findAllActivite(Long marcheId) {
        return dsl
                .select(MARCHE_ACTIVITE.ID, MARCHE_ACTIVITE.MARCHE_ID, MARCHE_ACTIVITE.CODE_ACTIVITE.as("codeActivite"), MARCHE_ACTIVITE.INTITULE_ACTIVITE.as("intituleActivite"),
                        MARCHE_ACTIVITE.TAUX, MARCHE_ACTIVITE.MONTANT)
                .from(MARCHE_ACTIVITE)
                .where(MARCHE_ACTIVITE.MARCHE_ID.eq(marcheId))
                .fetchInto(ActiviteDTO.class);
    }



}
