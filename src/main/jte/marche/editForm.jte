@import com.advinteck.cegib.dto.MarcheDTO
@import com.advinteck.cegib.generated.referentiel.tables.pojos.*
@import org.springframework.validation.BindingResult
@import java.util.List
@import java.util.Map

@param BindingResult bindingResult
@param MarcheDTO marcheDTO
@param Map<String, String> messages
@param List<Imputation> imputationList
@param List<AutoriteContractante> autoriteContractanteList
@param List<AutoriteContractanteStructures> autoriteContractanteStructuresList
@param List<TypesMarche> typesMarcheList
@param List<ModesPassation> modesPassationList

@template.layout(
title = "Modification du Marché",
messages = messages,
content = @`
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h4 class="text-success fw-bold">
            <i class="bi bi-pencil-square me-2"></i> Modification du Marché
        </h4>
        <a href="/marche/details/${marcheDTO.getId()}" class="btn btn-outline-secondary shadow-sm">
            <i class="bi bi-arrow-left me-1"></i> Retour à la liste
        </a>
    </div>

    <div class="card border-0 shadow-sm">
        <div class="card-header bg-white py-3 border-bottom">
            <h5 class="mb-0 text-dark fw-bold">Détails du Formulaire</h5>
        </div>
        <div class="card-body p-4">
            <form action="/marche/update" method="post">
                <input type="hidden" name="id" value="${marcheDTO.getId()}">

                <!-- Section Info Principale -->
                <div class="row g-3 mb-4">
                    <div class="col-md-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control border-success-subtle bg-light" id="numMarche" name="numMarche"
                                   placeholder="Num de marché provisoire" value="${marcheDTO.getNumMarche()}" readonly>
                            <label for="numMarche"><i class="bi me-2"></i>Num de marché provisoire</label>
                            @template.formMessage(bindingResult = bindingResult, field = "numMarche")
                        </div>
                    </div>
                </div>

                <div class="row g-3 mb-4">
                    <div class="col-md-12">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control border-success-subtle" id="objetMarche" name="objetMarche"
                                   placeholder="Objet" value="${marcheDTO.getObjetMarche()}">
                            <label for="objetMarche"><i class="bi bi-info-circle me-2"></i>Objet du Marché</label>
                            @template.formMessage(bindingResult = bindingResult, field = "objetMarche")
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="approuvePar" name="approuvePar"
                                   placeholder="Approuvé par" value="${marcheDTO.getApprouvePar()}">
                            <label for="approuvePar"><i class="bi bi-person-check me-2"></i>Approuvé Par</label>
                            @template.formMessage(bindingResult = bindingResult, field = "approuvePar")
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <input type="date" class="form-control" id="dateApprobation" name="dateApprobation"
                                   value="${marcheDTO.getDateApprobation() != null ? marcheDTO.getDateApprobation().toString() : ""}">
                            <label for="dateApprobation"><i class="bi bi-calendar-event me-2"></i>Date Approbation</label>
                            @template.formMessage(bindingResult = bindingResult, field = "dateApprobation")
                        </div>
                    </div>
                </div>

                <!-- Section Référentiels -->
                <h6 class="text-success text-uppercase small fw-bold mb-3 border-bottom pb-2">Configuration & Codes</h6>

                <div class="row g-3">

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <select class="form-select" name="autoriteContractanteCode" id="autoriteContractante">
                                <option value="">Choisir une autorité...</option>
                                @for(var el: autoriteContractanteList)
                                    <option selected="${el.getCode().equals(marcheDTO.getAutoriteContractanteCode())}" value="${el.getCode()}">
                                        ${el.getCode()} - ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                            <label for="autoriteContractante">Autorité Contractante</label>
                            @template.formMessage(bindingResult = bindingResult, field = "autoriteContractanteCode")
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <select class="form-select" name="structureAutoriteContractanteCode" id="structureAutoriteContractanteCode">
                                <option value="">Choisir...</option>
                                @for(var el: autoriteContractanteStructuresList)
                                    <option selected="${el.getCode().equals(marcheDTO.getStructureAutoriteContractanteCode())}" value="${el.getCode()}">
                                        ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                            <label for="structureAutoriteContractanteCode">Structure AC</label>
                            @template.formMessage(bindingResult = bindingResult, field = "structureAutoriteContractanteCode")
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <select class="form-select" name="imputation" id="imputation">
                                <option value="">Choisir une imputation...</option>
                                @for(var el: imputationList)
                                    <option selected="${el.getImputation().equals(marcheDTO.getImputation())}" value="${el.getImputation()}">
                                        ${el.getImputation()} - ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                            <label for="imputation">Imputation Budgétaire</label>
                            @template.formMessage(bindingResult = bindingResult, field = "imputation")
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <select class="form-select" name="typeMarcheCode" id="typeMarcheCode">
                                <option value="">Sélectionner...</option>
                                @for(var el: typesMarcheList)
                                    <option selected="${marcheDTO.getTypeMarcheCode() != null && marcheDTO.getTypeMarcheCode().equals(el.getCode())}" value="${el.getCode()}">
                                        ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                            <label for="typeMarcheCode">Type de Marché</label>
                            @template.formMessage(bindingResult = bindingResult, field = "typeMarcheCode")
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <select class="form-select" name="modePassationCode" id="modePassationCode">
                                <option value="">Sélectionner...</option>
                                @for(var el: modesPassationList)
                                    <option selected="${marcheDTO.getModePassationCode() != null && marcheDTO.getModePassationCode().equals(el.getCode())}" value="${el.getCode()}">
                                        ${el.getIntitule()}
                                    </option>
                                @endfor
                            </select>
                            <label for="modePassationCode">Mode de Passation</label>
                            @template.formMessage(bindingResult = bindingResult, field = "modePassationCode")
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="form-floating mb-3 position-relative">
                            <input type="text"
                                   class="form-control"
                                   id="titulaireMarche"
                                   name="titulaireMarche"
                                   placeholder="Titulaire du marché"
                                   autocomplete="off"
                                   value="${marcheDTO.getTitulaireMarche()}">
                            <label for="titulaireMarche">
                                <i class="bi bi-person-check me-2"></i>
                                Titulaire du marché
                            </label>
                            @template.formMessage(bindingResult = bindingResult, field = "titulaireMarche")

                            <!-- SUGGESTIONS NIF -->
                            <div id="suggestionsNif"
                                 class="list-group position-absolute w-100 shadow-sm"
                                 style="z-index:9999; top:100%; left:0;"></div>
                        </div>
                    </div>


                    <div class="col-md-6">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="statut" name="statut"
                                   placeholder="Statut" value="${marcheDTO.getStatut()}">
                            <label for="statut"><i class="bi bi-person-check me-2"></i>Statut</label>
                            @template.formMessage(bindingResult = bindingResult, field = "statut")
                        </div>
                    </div>


                </div>

                <div class="mt-4 pt-3 border-top d-flex gap-2">
                    <button type="submit" class="btn btn-success px-5 shadow-sm">
                        <i class="bi bi-check-circle me-2"></i>Enregistrer les modifications
                    </button>
                    <a href="/marche/details" class="btn btn-light px-4 border">
                        Annuler
                    </a>
                </div>
            </form>
        </div>
    </div>

    <script>
        const config = { showSearch: true, searchPlaceholder: 'Rechercher...' };
        new SlimSelect({ select: '#imputation', ...config });
        new SlimSelect({ select: '#autoriteContractante', ...config });
        new SlimSelect({ select: '#typeMarcheCode', ...config });
        new SlimSelect({ select: '#modePassationCode', ...config });
    </script>

    <script>
        const structurePrecedente =
            '${marcheDTO != null && marcheDTO.getStructureAutoriteContractanteCode() != null
            ? marcheDTO.getStructureAutoriteContractanteCode()
            : ""}';

        function loadStructuresEdit() {
            let code = document.getElementById("autoriteContractante").value;
            let structure = document.getElementById("structureAutoriteContractanteCode");

            if (code === "") {
                structure.innerHTML = "<option value=''>Sélectionner...</option>";
                return;
            }

            fetch("/marche/structures/" + code)
                .then(response => response.json())
                .then(data => {
                    structure.innerHTML = "<option value=''>Sélectionner...</option>";
                    data.forEach(el => {
                        structure.innerHTML +=
                            "<option value='" + el.code + "'>" +
                            el.intitule +
                            "</option>";
                    });
                    setTimeout(() => {
                        if (structurePrecedente && structurePrecedente !== "") {
                            structure.value = structurePrecedente.trim();
                        }
                    }, 0);
                });
        }

        document.getElementById("autoriteContractante")
            .addEventListener("change", function () {
                loadStructuresEdit();
            });

        window.addEventListener("DOMContentLoaded", () => {
            if (document.getElementById("autoriteContractante").value !== "") {
                loadStructuresEdit();
            }
        });
    </script>

    <script>
        window.addEventListener("DOMContentLoaded", function () {

            const input = document.getElementById("titulaireMarche");
            const box = document.getElementById("suggestionsNif");

            if (!input || !box) return;

            input.addEventListener("input", function () {
                let value = this.value.trim();

                if (value.length < 3) {
                    box.innerHTML = "";
                    return;
                }

                fetch("/marche/search-nif/" + value)
                    .then(response => response.json())
                    .then(data => {
                        box.innerHTML = "";

                        if (!data || data.length === 0) {
                            box.innerHTML = "<div class='list-group-item'>Aucun résultat</div>";
                            return;
                        }

                        data.forEach(el => {
                            let item = document.createElement("button");
                            item.type = "button";
                            item.className = "list-group-item list-group-item-action";
                            item.innerHTML = el.identifiant + " - " + el.raisonSociale;
                            item.onclick = function () {
                                input.value = el.identifiant;
                                box.innerHTML = "";
                            };
                            box.appendChild(item);
                        });
                    })
                    .catch(error => {
                        console.error("Erreur autocomplete NIF:", error);
                    });
            });

            document.addEventListener("click", function (e) {
                if (e.target !== input && !box.contains(e.target)) {
                    box.innerHTML = "";
                }
            });
        });
    </script>
`)