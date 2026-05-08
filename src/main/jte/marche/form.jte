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

                    <div class="form-section-title text-success">
                        01. Informations Générales
                    </div>

                    <div class="row g-4 mb-5">

                        <!-- NUMERO MARCHE -->
                        <div class="col-md-6">
                            <label class="form-label small fw-bold text-uppercase">
                                Numéro provisoire
                            </label>
                            <input type="text"
                                   name="numMarche"
                                   value="${marcheDTO.getNumMarche()}"
                                   class="form-control bg-light"
                                   readonly>
                            @if(bindingResult != null && bindingResult.hasFieldErrors("numMarche"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("numMarche").getDefaultMessage()}
                                </div>
                            @endif
                        </div>

                        <!-- OBJET MARCHE -->
                        <div class="col-md-6">
                            <label class="form-label small fw-bold text-uppercase">
                                Objet du Marché <i class="text-danger">*</i>
                            </label>
                            <textarea
                                    name="objetMarche"
                                    rows="2"
                                    autocomplete="off"
                                    class="form-control ${bindingResult != null && bindingResult.hasFieldErrors("objetMarche") ? "is-invalid" : ""}">${marcheDTO != null ? marcheDTO.getObjetMarche() : ""}</textarea>
                            @if(bindingResult != null && bindingResult.hasFieldErrors("objetMarche"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("objetMarche").getDefaultMessage()}
                                </div>
                            @endif
                        </div>

                        <!-- IMPUTATION -->
                        <div class="col-md-12">
                            <label class="form-label small fw-bold text-uppercase">
                                Imputation Budgétaire <i class="text-danger">*</i>
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

                    <div class="form-section-title text-success">
                        02. Caractéristiques du marché
                    </div>

                    <div class="row g-4 mb-2">

                        <!-- TYPE MARCHE -->
                        <div class="col-md-6">
                            <label class="form-label small fw-bold text-uppercase">
                                Type de Marché <i class="text-danger">*</i>
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
                            <label class="form-label small fw-bold text-uppercase">
                                Mode de Passation <i class="text-danger">*</i>
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

                    <!-- TITULAIRE -->
                    <div class="col-md-12 mb-5">
                        <label class="form-label small fw-bold text-uppercase">
                            Titulaire du marché (NIF) <i class="text-danger">*</i>
                        </label>
                        <div class="position-relative">
                            <input type="text"
                                   id="titulaireMarche"
                                   name="titulaireMarche"
                                   autocomplete="off"
                                   value="${marcheDTO != null ? marcheDTO.getTitulaireMarche() : ""}"
                                   placeholder="Entrer le NIF ou la raison sociale"
                                   class="form-control ${bindingResult != null && bindingResult.hasFieldErrors("titulaireMarche") ? "is-invalid" : ""}">
                            <!-- suggestions -->
                            <div id="suggestionsNif"
                                 class="list-group position-absolute w-100 shadow-sm"
                                 style="z-index:9999; top:100%; left:0;">
                            </div>
                        </div>
                        @if(bindingResult != null && bindingResult.hasFieldErrors("titulaireMarche"))
                            <div class="invalid-feedback">
                                ${bindingResult.getFieldError("titulaireMarche").getDefaultMessage()}
                            </div>
                        @endif
                    </div>

                    <!-- ========================= -->
                    <!-- AUTORITES -->
                    <!-- ========================= -->

                    <div class="form-section-title text-success">
                        03. Autorités
                    </div>

                    <div class="row g-4 mb-5">

                        <!-- AUTORITE CONTRACTANTE -->
                        <div class="col-md-6">
                            <label class="form-label small fw-bold text-uppercase">
                                Autorité Contractante <i class="text-danger">*</i>
                            </label>
                            <select
                                    id="autorite"
                                    name="autoriteContractanteCode"
                                    onchange="loadStructures()"
                                    class="form-select select-slim ${bindingResult != null && bindingResult.hasFieldErrors("autoriteContractanteCode") ? "is-invalid" : ""}">
                                <option value="">Choisir...</option>
                                @for(var el : autoriteContractanteList)
                                    <option
                                            value="${el.getCode()}"
                                            selected="${marcheDTO != null && marcheDTO.getAutoriteContractanteCode() != null && marcheDTO.getAutoriteContractanteCode().equals(el.getCode())}">
                                        ${el.getCode()} - ${el.getIntitule()}
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
                            <label class="form-label small fw-bold text-uppercase">
                                Structure <i class="text-danger">*</i>
                            </label>
                            <select
                                    id="structure"
                                    name="structureAutoriteContractanteCode"
                                    class="form-select select-slim ${bindingResult != null && bindingResult.hasFieldErrors("structureAutoriteContractanteCode") ? "is-invalid" : ""}">
                                <option value="">Choisir...</option>
                            </select>
                            @if(bindingResult != null && bindingResult.hasFieldErrors("structureAutoriteContractanteCode"))
                                <div class="invalid-feedback">
                                    ${bindingResult.getFieldError("structureAutoriteContractanteCode").getDefaultMessage()}
                                </div>
                            @endif
                        </div>

                        <!-- APPROUVE PAR -->
                        <div class="col-md-6">
                            <label class="form-label small fw-bold text-uppercase">
                                Approuvé par <i class="text-danger">*</i>
                            </label>
                            <input type="text"
                                   name="approuvePar"
                                   autocomplete="off"
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
                            <label class="form-label small fw-bold text-uppercase">
                                Date d'approbation <i class="text-danger">*</i>
                            </label>
                            <input type="date"
                                   name="dateApprobation"
                                   value="${marcheDTO != null && marcheDTO.getDateApprobation() != null ? marcheDTO.getDateApprobation().toString() : ""}"
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

    <script>
        const structurePrecedente = '${marcheDTO != null && marcheDTO.getStructureAutoriteContractanteCode() != null ? marcheDTO.getStructureAutoriteContractanteCode() : ""}';

        function loadStructures() {
            let code = document.getElementById("autorite").value;
            let structure = document.getElementById("structure");

            if(code === "") {
                structure.innerHTML = "<option value=''>Choisir...</option>";
                return;
            }

            fetch("/marche/structures/" + code)
                .then(response => response.json())
                .then(data => {
                    structure.innerHTML = "<option value=''>Choisir...</option>";
                    data.forEach(el => {
                        let isSelected = (el.code.trim() === structurePrecedente.trim()) ? "selected" : "";
                        structure.innerHTML += "<option value='" + el.code + "' " + isSelected + ">" + el.intitule + "</option>";
                    });
                });
        }

        window.addEventListener('DOMContentLoaded', () => {
            if (document.getElementById("autorite").value !== "") {
                loadStructures();
            }
        });
    </script>

    <script>
        const titulaireInput = document.getElementById("titulaireMarche");
        const suggestionsBox = document.getElementById("suggestionsNif");

        titulaireInput.addEventListener("keyup", function () {
            let value = this.value.trim();

            if (value.length < 3) {
                suggestionsBox.innerHTML = "";
                return;
            }

            fetch("/marche/search-nif/" + value)
                .then(response => response.json())
                .then(data => {
                    suggestionsBox.innerHTML = "";

                    if(data.length === 0){
                        suggestionsBox.innerHTML = "<div class='list-group-item'>Aucun résultat</div>";
                        return;
                    }

                    data.forEach(el => {
                        let button = document.createElement("button");
                        button.type = "button";
                        button.className = "list-group-item list-group-item-action";
                        button.innerHTML = el.identifiant + " - " + el.raisonSociale;
                        button.addEventListener("click", function () {
                            titulaireInput.value = el.identifiant;
                            suggestionsBox.innerHTML = "";
                        });
                        suggestionsBox.appendChild(button);
                    });
                });
        });

        document.addEventListener("click", function(e){
            if(!suggestionsBox.contains(e.target) && e.target !== titulaireInput){
                suggestionsBox.innerHTML = "";
            }
        });
    </script>
`)