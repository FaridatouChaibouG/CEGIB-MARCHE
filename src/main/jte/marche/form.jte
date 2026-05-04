@import com.advinteck.cegib.generated.referentiel.tables.pojos.*
@import org.springframework.validation.BindingResult
@import java.util.List
@import java.util.Map
@import com.advinteck.cegib.dto.MarcheDTO

@param BindingResult bindingResult
@param MarcheDTO marcheDTO
@param Map<String, String> messages
@param List<TypesMarche> typeMarcheList
@param List<Imputation> imputationList
@param List<AutoriteContractante> autoriteContractanteList
@param List<AutoriteContractanteStructures> structureAutoriteContractanteList
@param List<ModesPassation> modePassationList

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

        .card-custom {
            border-radius: 12px;
            border: none;
        }

        .form-control,
        .form-select {
            border-color: #d1d3e2;
            border-radius: 8px;
            padding: 0.75rem 1rem;
        }

        .form-control:focus,
        .form-select:focus {
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

        .invalid-feedback {
            display: block;
            font-size: 0.85rem;
        }
    </style>

    <div class="container-fluid py-4">

        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="h3 mb-0 text-gray-800">Nouveau Marché</h1>

            <a href="/marche/list" class="btn btn-outline-secondary shadow-sm">
                <i class="bi bi-arrow-left me-1"></i>
                Retour à la liste
            </a>
        </div>

        <div class="card card-custom shadow">
            <div class="card-body p-lg-5">

                <form action="/marche/save" method="post">

                    <!-- ========================= -->
                    <!-- INFORMATIONS GENERALES -->
                    <!-- ========================= -->

                    <div class="form-section-title">
                        01. Informations Générales
                    </div>

                    <div class="row g-4 mb-5">

                        <!-- NUMERO MARCHE -->

                        <div class="col-md-6">
                            <label class="form-label small fw-bold">
                                Numéro provisoire du marché
                            </label>

                            <input type="text"
                                   name="numMarche"
                                   placeholder="Ex: M0001"
                                   value="${marcheDTO != null ? marcheDTO.getNumMarche() : ""}"
                                   class="form-control ${bindingResult != null && bindingResult.hasFieldErrors("numMarche") ? "is-invalid" : ""}">

                            @if(bindingResult != null && bindingResult.hasFieldErrors("numMarche"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("numMarche").getDefaultMessage()}
                                </div>
                            @endif
                        </div>

                        <!-- OBJET MARCHE -->

                        <div class="col-md-6">
                            <label class="form-label small fw-bold">
                                Objet du Marché
                            </label>

                            <textarea
                                    name="objetMarche"
                                    rows="2"
                                    class="form-control ${bindingResult != null && bindingResult.hasFieldErrors("objetMarche") ? "is-invalid" : ""}">${marcheDTO != null ? marcheDTO.getObjetMarche() : ""}</textarea>

                            @if(bindingResult != null && bindingResult.hasFieldErrors("objetMarche"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("objetMarche").getDefaultMessage()}
                                </div>
                            @endif
                        </div>

                        <!-- IMPUTATION -->

                        <div class="col-md-12">
                            <label class="form-label small fw-bold">
                                Imputation Budgétaire
                            </label>

                            <select
                                    name="imputation"
                                    class="form-select select-slim ${bindingResult != null && bindingResult.hasFieldErrors("imputation") ? "is-invalid" : ""}">

                                <option value="">Choisir...</option>

                                @for(var el : imputationList)

                                    <option
                                            value="${el.getImputation()}"
                                            selected="${marcheDTO != null && marcheDTO.getImputation() != null && marcheDTO.getImputation().equals(el.getImputation())}">

                                        ${el.getImputation()} - ${el.getIntitule()}

                                    </option>

                                @endfor

                            </select>

                            @if(bindingResult != null && bindingResult.hasFieldErrors("imputation"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("imputation").getDefaultMessage()}
                                </div>
                            @endif
                        </div>

                    </div>

                    <!-- ========================= -->
                    <!-- CARACTERISTIQUES -->
                    <!-- ========================= -->

                    <div class="form-section-title">
                        02. Caractéristiques du marché
                    </div>

                    <div class="row g-4 mb-5">

                        <!-- TITULAIRE -->

                        <div class="col-md-12">

                            <label class="form-label small fw-bold">
                                Titulaire du marché
                            </label>

                            <input type="text"
                                   name="titulaireMarche"
                                   value="${marcheDTO != null ? marcheDTO.getTitulaireMarche() : ""}"
                                   placeholder="Nom de l'entreprise"
                                   class="form-control ${bindingResult != null && bindingResult.hasFieldErrors("titulaireMarche") ? "is-invalid" : ""}">

                            @if(bindingResult != null && bindingResult.hasFieldErrors("titulaireMarche"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("titulaireMarche").getDefaultMessage()}
                                </div>
                            @endif

                        </div>

                        <!-- TYPE MARCHE -->

                        <div class="col-md-6">

                            <label class="form-label small fw-bold">
                                Type de Marché
                            </label>

                            <select
                                    name="typeMarcheCode"
                                    class="form-select select-slim ${bindingResult != null && bindingResult.hasFieldErrors("typeMarcheCode") ? "is-invalid" : ""}">

                                <option value="">Choisir...</option>

                                @for(var el : typeMarcheList)

                                    <option
                                            value="${el.getCode()}"
                                            selected="${marcheDTO != null && marcheDTO.getTypeMarcheCode() != null && marcheDTO.getTypeMarcheCode().equals(el.getCode())}">

                                        ${el.getIntitule()}

                                    </option>

                                @endfor

                            </select>

                            @if(bindingResult != null && bindingResult.hasFieldErrors("typeMarcheCode"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("typeMarcheCode").getDefaultMessage()}
                                </div>
                            @endif

                        </div>

                        <!-- MODE PASSATION -->

                        <div class="col-md-6">

                            <label class="form-label small fw-bold">
                                Mode de Passation
                            </label>

                            <select
                                    name="modePassationCode"
                                    class="form-select select-slim ${bindingResult != null && bindingResult.hasFieldErrors("modePassationCode") ? "is-invalid" : ""}">

                                <option value="">Choisir...</option>

                                @for(var el : modePassationList)

                                    <option
                                            value="${el.getCode()}"
                                            selected="${marcheDTO != null && marcheDTO.getModePassationCode() != null && marcheDTO.getModePassationCode().equals(el.getCode())}">

                                        ${el.getIntitule()}

                                    </option>

                                @endfor

                            </select>

                            @if(bindingResult != null && bindingResult.hasFieldErrors("modePassationCode"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("modePassationCode").getDefaultMessage()}
                                </div>
                            @endif

                        </div>

                    </div>

                    <!-- ========================= -->
                    <!-- AUTORITES -->
                    <!-- ========================= -->

                    <div class="form-section-title">
                        03. Autorités
                    </div>

                    <div class="row g-4 mb-5">

                        <!-- AUTORITE CONTRACTANTE -->

                        <div class="col-md-6">

                            <label class="form-label small fw-bold">
                                Autorité Contractante
                            </label>

                            <select
                                    name="autoriteContractanteCode"
                                    class="form-select select-slim ${bindingResult != null && bindingResult.hasFieldErrors("autoriteContractanteCode") ? "is-invalid" : ""}">

                                <option value="">Choisir...</option>

                                @for(var el : autoriteContractanteList)

                                    <option
                                            value="${el.getCode()}"
                                            selected="${marcheDTO != null && marcheDTO.getAutoriteContractanteCode() != null && marcheDTO.getAutoriteContractanteCode().equals(el.getCode())}">

                                        ${el.getIntitule()}

                                    </option>

                                @endfor

                            </select>

                            @if(bindingResult != null && bindingResult.hasFieldErrors("autoriteContractanteCode"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("autoriteContractanteCode").getDefaultMessage()}
                                </div>
                            @endif

                        </div>

                        <!-- STRUCTURE -->

                        <div class="col-md-6">

                            <label class="form-label small fw-bold">
                                Structure Bénéficiaire
                            </label>

                            <select
                                    name="structureAutoriteContractanteCode"
                                    class="form-select select-slim ${bindingResult != null && bindingResult.hasFieldErrors("structureAutoriteContractanteCode") ? "is-invalid" : ""}">

                                <option value="">Choisir...</option>

                                @for(var el : structureAutoriteContractanteList)

                                    <option
                                            value="${el.getCode()}"
                                            selected="${marcheDTO != null && marcheDTO.getStructureAutoriteContractanteCode() != null && marcheDTO.getStructureAutoriteContractanteCode().equals(el.getCode())}">

                                        ${el.getIntitule()}

                                    </option>

                                @endfor

                            </select>

                            @if(bindingResult != null && bindingResult.hasFieldErrors("structureAutoriteContractanteCode"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("structureAutoriteContractanteCode").getDefaultMessage()}
                                </div>
                            @endif

                        </div>

                        <!-- APPROUVE PAR -->

                        <div class="col-md-6">

                            <label class="form-label small fw-bold">
                                Approuvé par
                            </label>

                            <input type="text"
                                   name="approuvePar"
                                   value="${marcheDTO != null ? marcheDTO.getApprouvePar() : ""}"
                                   class="form-control ${bindingResult != null && bindingResult.hasFieldErrors("approuvePar") ? "is-invalid" : ""}">

                            @if(bindingResult != null && bindingResult.hasFieldErrors("approuvePar"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("approuvePar").getDefaultMessage()}
                                </div>
                            @endif

                        </div>

                        <!-- DATE APPROBATION -->

                        <div class="col-md-6">

                            <label class="form-label small fw-bold">
                                Date d'approbation
                            </label>

                            <input type="date"
                                   name="dateApprobation"
                                   class="form-control ${bindingResult != null && bindingResult.hasFieldErrors("dateApprobation") ? "is-invalid" : ""}">

                            @if(bindingResult != null && bindingResult.hasFieldErrors("dateApprobation"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("dateApprobation").getDefaultMessage()}
                                </div>
                            @endif

                        </div>

                    </div>

                    <!-- BOUTONS -->

                    <div class="d-flex justify-content-end mt-5">

                        <button type="submit" class="btn btn-success btn-save shadow">
                            <i class="bi bi-check2-all me-2"></i>
                            Enregistrer
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