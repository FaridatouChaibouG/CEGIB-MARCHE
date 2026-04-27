package com.advinteck.cegib.repository;
import com.advinteck.cegib.generated.marche.Tables;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheActivite;
import com.advinteck.cegib.generated.marche.tables.pojos.MarcheNifs;
import com.advinteck.cegib.generated.marche.tables.pojos.Marches;
import com.advinteck.cegib.generated.marche.tables.pojos.VMarches;
import com.advinteck.cegib.generated.referentiel.tables.pojos.VNifs;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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


    public List<VMarches> findAll() {
        return dsl
                .selectFrom(Tables.V_MARCHES)
                .fetchInto(VMarches.class);
    }






    public List<MarcheNifs> findAllNif(Long marcheId) {
        return dsl
                .selectFrom(Tables.MARCHE_NIFS)
                .where(Tables.MARCHE_NIFS.MARCHE_ID.eq(marcheId))
                .fetchInto(MarcheNifs.class);
    }


    public List<MarcheActivite> findAllActivite(Long marcheId) {
        return dsl
                .selectFrom(Tables.MARCHE_ACTIVITE)
                .where(Tables.MARCHE_ACTIVITE.MARCHE_ID.eq(marcheId))
                .fetchInto(MarcheActivite.class);
    }



//    public List<MarcheActivite> findAllActivite(Long marcheId) {
//        return dsl
//                .selectFrom(Tables.MARCHE_ACTIVITE)
//                .where(Tables.MARCHE_ACTIVITE.MARCHE_ID.eq(marcheId))
//                .fetchInto(MarcheActivite.class);
//    }

}
