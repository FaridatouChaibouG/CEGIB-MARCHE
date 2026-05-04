CREATE SCHEMA IF NOT EXISTS referentiel;
CREATE SCHEMA IF NOT EXISTS marche;



CREATE TABLE IF NOT EXISTS marche.marches
(
    id bigserial NOT NULL,
    numero_marche character varying(20) NOT NULL DEFAULT ('M'::text || lpad(nextval(pg_get_serial_sequence('marche.marches', 'id'))::text, 4, '0'::text)),
    imputation character varying(6) NOT NULL,
    objet_marche character varying(100) NOT NULL,
    date_approbation timestamp without time zone NOT NULL,
    autorite_contractante_code character varying(2) NOT NULL,
    structure_autorite_contractante_code character varying(6) NOT NULL,
    approuve_par character varying(100) NOT NULL,
    titulaire_marche character varying(100) NOT NULL,
    type_marche_code character varying(2) NOT NULL,
    mode_de_passation_code character varying(2) NOT NULL,
    statut character varying(50) NOT NULL DEFAULT 'EN_ATTENTE',
    owner character varying(50),
    observation character varying(255),
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT marches_pkey PRIMARY KEY (id),
    CONSTRAINT marches_numero_marche_key UNIQUE (numero_marche),
    CONSTRAINT fk_marches_autorite FOREIGN KEY (autorite_contractante_code)
    REFERENCES referentiel.autorite_contractante (code),
    CONSTRAINT fk_marches_imputation FOREIGN KEY (imputation)
    REFERENCES referentiel.imputation (imputation),
    CONSTRAINT fk_marches_mode_de_passation FOREIGN KEY (mode_de_passation_code)
    REFERENCES referentiel.modes_passation (code),
    CONSTRAINT fk_marches_structure FOREIGN KEY (structure_autorite_contractante_code)
    REFERENCES referentiel.autorite_contractante_structures (code),
    CONSTRAINT fk_marches_type_marche FOREIGN KEY (type_marche_code)
    REFERENCES referentiel.types_marche (code)
    );

ALTER TABLE IF EXISTS marche.marches OWNER to admin;


CREATE TABLE IF NOT EXISTS marche.marche_nifs
(
    id bigserial NOT NULL,
    marche_id bigint NOT NULL,
    identifiant character varying(20) NOT NULL,
    raison_social character varying(100),
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT marche_nifs_pkey PRIMARY KEY (id),
    CONSTRAINT fk_marche_nifs_marches FOREIGN KEY (marche_id)
    REFERENCES marche.marches (id),
    CONSTRAINT fk_marche_nifs_referentiel_nifs FOREIGN KEY (identifiant)
    REFERENCES referentiel.nifs (identifiant)
    );

ALTER TABLE IF EXISTS marche.marche_nifs OWNER to admin;


CREATE TABLE IF NOT EXISTS marche.marche_activite
(
    id bigserial NOT NULL,
    marche_id bigint NOT NULL,
    code_activite character varying(8) NOT NULL,
    intitule_activite character varying(255) NOT NULL,
    taux integer NOT NULL,
    montant bigint NOT NULL,
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT marche_activite_pkey PRIMARY KEY (id),
    CONSTRAINT fk_marche_activite_marches FOREIGN KEY (marche_id)
    REFERENCES marche.marches (id),
    CONSTRAINT fk_marche_activite_referentiel_dppd FOREIGN KEY (code_activite)
    REFERENCES referentiel.dppd_activite (code_activite)
    );

ALTER TABLE IF EXISTS marche.marche_activite OWNER to admin;





CREATE TABLE IF NOT EXISTS referentiel.autorite_contractante
(
    id bigserial NOT NULL,
    code character varying(2),
    intitule character varying(255),
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT autorite_contractante_pkey PRIMARY KEY (id),
    CONSTRAINT u_autorite_contractante UNIQUE (code)
    );

ALTER TABLE IF EXISTS referentiel.autorite_contractante
    OWNER to admin;



CREATE TABLE IF NOT EXISTS referentiel.autorite_contractante_structures
(
    id bigserial NOT NULL,
    code_autorite_contractante character varying(2) NOT NULL,
    code character varying(6) NOT NULL UNI,
    intitule character varying(255) NOT NULL,
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT autorite_contractante_structures_pkey PRIMARY KEY (id),
    CONSTRAINT u_autorite_contractante_structures UNIQUE (code),
    CONSTRAINT autorite_contractante_structure_code_autorite_contractante_fkey FOREIGN KEY (code_autorite_contractante)
    REFERENCES referentiel.autorite_contractante (code) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION
    );

ALTER TABLE IF EXISTS referentiel.autorite_contractante_structures
    OWNER to admin;


CREATE TABLE IF NOT EXISTS referentiel.modes_passation
(
    id bigserial NOT NULL,
    code character(2) NOT NULL,
    intitule character varying(50) NOT NULL,
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT u_modes_passation UNIQUE (code),
    CONSTRAINT modes_passation_pkey PRIMARY KEY (id)
    );

ALTER TABLE IF EXISTS referentiel.modes_passation
    OWNER to admin;

CREATE TABLE IF NOT EXISTS referentiel.types_marche
(
    id bigserial NOT NULL,
    code character varying(2) NOT NULL,
    intitule character varying(50) NOT NULL,
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT u_types_marche UNIQUE (code),
    CONSTRAINT types_marche_pkey PRIMARY KEY (id)
    );

ALTER TABLE IF EXISTS referentiel.types_marche
    OWNER to admin;



CREATE TABLE IF NOT EXISTS referentiel.nifs
(
    id bigserial NOT NULL,
    identifiant character varying(20) NOT NULL,
    raison_sociale character varying(100) NOT NULL,
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT u_nif UNIQUE (identifiant)
    );

ALTER TABLE IF EXISTS referentiel.nifs
    OWNER to admin;


CREATE TABLE IF NOT EXISTS referentiel.imputation
(
    id bigserial NOT NULL,
    imputation character varying(6),
    intitule character varying(100),
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT imputation_pkey PRIMARY KEY (id),
    CONSTRAINT imputation_imputation_key UNIQUE (imputation)
    );

ALTER TABLE IF EXISTS referentiel.imputation
    OWNER to admin;


CREATE TABLE IF NOT EXISTS referentiel.dppd_activite
(
    id bigserial NOT NULL,
    imputation character varying(50),
    intitule_activite character varying(255),
    section_code character varying(2),
    programme_code character varying(3),
    code_activite character varying(8),
    gestion character varying(4),
    who_done character varying(100) DEFAULT CURRENT_USER,
    when_done timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    last_update timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    deleted_on timestamp without time zone DEFAULT NULL,
    CONSTRAINT dppd_activite_pkey PRIMARY KEY (id),
    CONSTRAINT u_dppd_activite UNIQUE (code_activite)
    );

ALTER TABLE IF EXISTS referentiel.dppd_activite
    OWNER to admin;




CREATE OR REPLACE VIEW marche.v_marches AS
SELECT
    m.id,
    m.numero_marche,
    m.imputation,
    i.intitule AS imputation_intitule,
    m.objet_marche,
    m.date_approbation,
    m.autorite_contractante_code,
    ac.intitule AS autorite_contractante_intitule,
    m.structure_autorite_contractante_code,
    sac.intitule AS structure_autorite_contractante_intitule,
    m.approuve_par,
    m.titulaire_marche,
    m.type_marche_code,
    tm.intitule AS type_marche_intitule,
    m.mode_de_passation_code,
    mp.intitule AS mode_passation_intitule,
    m.owner,
    m.statut,
    m.who_done,
    m.when_done,
    m.last_update
FROM marche.marches m
         LEFT JOIN referentiel.imputation i ON m.imputation = i.imputation
         LEFT JOIN referentiel.autorite_contractante ac ON m.autorite_contractante_code = ac.code
         LEFT JOIN referentiel.autorite_contractante_structures sac ON m.structure_autorite_contractante_code = sac.code
         LEFT JOIN referentiel.types_marche tm ON m.type_marche_code = tm.code
         LEFT JOIN referentiel.modes_passation mp ON m.mode_de_passation_code = mp.code;





