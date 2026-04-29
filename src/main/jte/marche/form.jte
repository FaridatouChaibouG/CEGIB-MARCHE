@import com.advinteck.cegib.generated.referentiel.tables.pojos.*
@import org.springframework.validation.BindingResult
@import java.util.List
@import java.util.Map
@import com.advinteck.cegib.dto.MarcheDTO

@param BindingResult  bindingResult
@param MarcheDTO marcheDTO
@param Map<String, String> messages
@param List<TypesMarche>  typeMarcheList
@param List<Imputation>  imputationList
@param List<AutoriteContractante>  autoriteContractanteList
@param List<AutoriteContractanteStructures>  structureAutoriteContractanteList
@param List<ModesPassation>  modePassationList

@template.layout(
title = "Nouveau Marché",
messages = messages,
content = @`
    <style>
        .form-section-title {
            font-size: 0.9rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 1px;
            color: #4e73df;
            margin-bottom: 1.5rem;
            display: flex;
            align-items: center;
        }
        .form-section-title::after {
            content: "";
            flex: 1;
            height: 1px;
            background: #e3e6f0;
            margin-left: 1rem;
        }
        .card-custom { border-radius: 12px; border: none; }
        .form-control, .form-select {
            border-color: #d1d3e2;
            border-radius: 8px;
            padding: 0.75rem 1rem;
        }
        .form-control:focus, .form-select:focus {
            border-color: #4e73df;
            box-shadow: 0 0 0 0.2rem rgba(78, 115, 223, 0.1);
        }
        .btn-save {
            background: linear-gradient(135deg, #198754 0%, #157347 100%);
            border: none;
            padding: 10px 30px;
            border-radius: 8px;
            font-weight: 600;
            color: white;
        }
    </style>

    <div class="container-fluid py-4">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="h3 mb-0 text-gray-800"></h1>
            <a href="/marche/list" class="btn btn-outline-secondary shadow-sm">
                <i class="bi bi-arrow-left me-1"></i> Annuler et retourner
            </a>
        </div>

        <div class="card card-custom shadow">
            <div class="card-body p-lg-5">
                <form action="/marche/save" method="post">

                    <!-- Identification -->
                    <div class="form-section-title">01. Informations Générales</div>
                    <div class="row g-4 mb-5">
<%--                        <div class="col-md-4">--%>
<%--                            <label class="form-label small fw-bold">Numéro de Marché</label>--%>
<%--                            <input type="text" class="form-control" name="numMarche" placeholder="Ex: MAR-2024-001" value="${marcheDTO.getNumMarche()}">--%>
<%--                            @template.formMessage(bindingResult = bindingResult, field = "numMarche")--%>
<%--                        </div>--%>

                        <div class="col-md-6">
                            <label class="form-label small fw-bold">Objet du Marché</label>
                            <textarea class="form-control" name="objetMarche" rows="2" placeholder="Description du marché...">${marcheDTO.getObjetMarche()}</textarea>
                        </div>

                        <div class="col-md-6">
                            <label class="form-label small fw-bold">Imputation Budgétaire</label>
                            <select class="form-select select-slim" name="imputation">
                                <option value="" disabled selected="${marcheDTO.getImputation() == null}">Choisir...</option>
                                @for(var el: imputationList)
                                    <option selected="${marcheDTO.getImputation() != null && marcheDTO.getImputation().equals(el.getImputation())}" value="${el.getImputation()}">
                                        ${el.getImputation()} - ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                        </div>

                    </div>



                    <!-- Finition -->
                    <div class="form-section-title">02. Caractéristiques du marché </div>
                    <div class="row g-4 mb-5">
                        <%--                        <div class="col-md-12">--%>
                        <%--                            <label class="form-label small fw-bold">Titulaire (Prestataire)</label>--%>
                        <%--                            <input type="text" class="form-control" name="titulaireMarche" placeholder="Nom de l'entreprise" value="${marcheDTO.getTitulaireMarche()}">--%>
                        <%--                        </div>--%>
                        <div class="col-md-6">
                            <label class="form-label small fw-bold">Type de Marché</label>
                            <select class="form-select select-slim" name="typeMarcheCode">
                                <option value="" disabled selected="${marcheDTO.getTypeMarcheCode() == null}">Choisir...</option>
                                @for(var el: typeMarcheList)
                                    <option selected="${marcheDTO.getTypeMarcheCode() != null && marcheDTO.getTypeMarcheCode().equals(el.getCode())}" value="${el.getCode()}">
                                        ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label small fw-bold">Mode de Passation</label>
                            <select class="form-select select-slim" name="modePassationCode">
                                <option value="" disabled selected="${marcheDTO.getModePassationCode() == null}">Choisir...</option>
                                @for(var el: modePassationList)
                                    <option selected="${marcheDTO.getModePassationCode() != null && marcheDTO.getModePassationCode().equals(el.getCode())}" value="${el.getCode()}">
                                        ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                        </div>
                    </div>


                    <!-- Acteurs -->
                    <div class="form-section-title">03.  Autorités</div>
                    <div class="row g-4 mb-5">
                        <div class="col-md-6">
                            <label class="form-label small fw-bold">Autorité Contractante</label>
                            <select class="form-select select-slim" name="autoriteContractanteCode">
                                <option value="" disabled selected="${marcheDTO.getAutoriteContractanteCode() == null}">Choisir...</option>
                                @for(var el: autoriteContractanteList)
                                    <option selected="${marcheDTO.getAutoriteContractanteCode() != null && marcheDTO.getAutoriteContractanteCode().equals(el.getCode())}" value="${el.getCode()}">
                                        ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label small fw-bold">Structure Bénéficiaire</label>
                            <select class="form-select select-slim" name="structureAutoriteContractanteCode">
                                <option value="" disabled selected="${marcheDTO.getStructureAutoriteContractanteCode() == null}">Choisir...</option>
                                @for(var el: structureAutoriteContractanteList)
                                    <option selected="${marcheDTO.getStructureAutoriteContractanteCode() != null && marcheDTO.getStructureAutoriteContractanteCode().equals(el.getCode())}" value="${el.getCode()}">
                                        ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label small fw-bold" >Approuvé par</label>
                            <div class="input-group">
                                <span class="input-group-text bg-light"><i class="bi bi-person"></i></span>
                                <input type="text" class="form-control" name="approuvePar" value="${marcheDTO.getApprouvePar()}">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label small fw-bold">Date d'approbation</label>
                            <input type="date" class="form-control" name="dateApprobation">
                        </div>
                    </div>


                    <div class="d-flex justify-content-between align-items-center mt-5">
                        <button type="reset" class="btn btn-link text-muted text-decoration-none"></button>
                        <button type="submit" class="btn btn-success btn-save shadow">
                            <i class="bi bi-check2-all me-2"></i> Enregistrer
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script>
        document.querySelectorAll('.select-slim').forEach(el => {
            new SlimSelect({
                select: el,
                settings: {
                    placeholderText: 'Choisir...',
                }
            });
        });
    </script>
`)
