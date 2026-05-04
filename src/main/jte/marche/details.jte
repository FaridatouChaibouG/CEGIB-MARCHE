@import com.advinteck.cegib.dto.ActiviteDTO
@import com.advinteck.cegib.dto.MarcheDTO
@import com.advinteck.cegib.generated.referentiel.tables.pojos.*
@import com.advinteck.cegib.dto.NifDTO
@import java.util.Map
@import java.util.List

@param List<Nifs> nifList
@param List<DppdActivite> dppActiviteList
@param MarcheDTO marcheDTO
@param Map<String, String> messages
@param List<NifDTO> marcheNifDTOs
@param List<ActiviteDTO> marcheActiviteDTOs

@template.layout(
title = "Détail du Marché",
messages = messages,
content = @`
    <!-- Actions Bar -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h4 class="text-success fw-bold"><i  class="bi bi-file-earmark-text me-2"> ${marcheDTO.getNumMarche()}</i>   </h4>
      <h4 class="text-success fw-bold"> </h4>
        <a href="/marche/list" class="btn btn-outline-secondary shadow-sm">
            <i class="bi bi-arrow-left me-1"></i> Retour à la liste
        </a>
    </div>

    <!-- Infos Générales -->
    <div class="card border-0 shadow-sm mb-4">
        <div class="card-header bg-white py-3">
            <h5 class="mb-0 text-dark fw-bold">Informations Générales</h5>
        </div>
        <div class="card-body">
            <div class="row g-3">


                <div class="col-md-4 ">
                    <small class="fw-bold d-block">Numéro provisoire du  marché </small>
                    <span class="small">${marcheDTO.getNumMarche()}</span>
                </div>

                <div class="col-md-4">
                    <small class="fw-bold d-block">Objet du Marché</small>
                    <p class="mb-0 fw-medium">${marcheDTO.getObjetMarche()}</p>
                </div>


                <div class="col-md-4 ">
                    <small class="fw-bold d-block">Imputation Budgétaire</small>
                    <span class="small">${marcheDTO.getImputationIntitule()}</span>
                </div>


                <div class="col-md-6">
                    <small class="fw-bold d-block">Type de Marché</small>
                    <span class="small">${marcheDTO.getTypeMarcheIntitule()}</span>
                </div>
                <div class="col-md-6">
                    <small class="fw-bold d-block">Mode de Passation</small>
                    <span class="small">${marcheDTO.getModePassationIntitule()}</span>
                </div>

                <div class="col-md-6">
                    <small class="fw-bold d-block">Autorité Contractante</small>
                    <span class="small">${marcheDTO.getAutoriteContractanteIntitule()}</span>
                </div>

                <div class="col-md-6">
                    <small class="fw-bold d-block"> Structure Autorité Contractante</small>
                    <span class="small">${marcheDTO.getStructureAutoriteContractanteIntutule()}</span>
                </div>

                <div class="col-md-3 col-6">
                    <small class="fw-bold d-block">Date d'approbation</small>
                    <small>
                        ${marcheDTO.getDateApprobation().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))}
                    </small>
                </div>
                <div class="col-md-3 col-6">
                    <small class="fw-bold d-block">Approuvé par</small>
                    <span class="small">${marcheDTO.getApprouvePar()}</span>
                </div>

                <div class="col-md-4 col-6">
                    <small class="fw-bold d-block">Titulaire du marché</small>
                    <span class="small">${marcheDTO.getTitulaireMarche()}</span>
                </div>



            </div>
        </div>
    </div>

    <div class="row g-4">
        <!-- Section Activités -->
        <div class="col-lg-8">
            <div class="card border-0 shadow-sm h-100">
                <div class="card-header bg-white d-flex justify-content-between align-items-center py-3">
                    <h5 class="mb-0 fw-bold">Activités</h5>
                    <button class="btn btn-sm btn-success rounded-pill" data-bs-toggle="modal"
                            data-bs-target="#activiteAddModal">
                        <i class="bi bi-plus-lg me-1"></i> Ajouter
                    </button>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover align-middle mb-0">
                        <thead class="table-light">
                        <tr class="small text-uppercase">
                            <th class="ps-4">Code / Intitulé</th>
                            <th class="text-center">Taux (%)</th>
                            <th class="text-end">Montant HT</th>
                            <th class="text-end">Montant TTC</th>
                            <th class="text-center">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        @for(var el : marcheActiviteDTOs)
                            <tr>
                                <td class="ps-4">
                                    <div class="fw-bold text-dark">${el.getCodeActivite()}</div>
                                    <div class="small text-muted">${el.getIntituleActivite()}</div>
                                </td>
                                <td class="text-center"><span class="badge bg-light text-dark">${el.getTaux()}</span>
                                </td>
                                <td class="text-end fw-medium">
                                    ${String.format(java.util.Locale.FRANCE, "%,d", el.getMontant())}
                                </td>

                                <td class="text-end fw-bold text-success">
                                    ${String.format(java.util.Locale.FRANCE, "%,d", el.getMontant() * (100 + el.getTaux()) / 100)}
                                </td>

                                <td class="text-center">
                                    <button class="btn btn-sm btn-outline-primary border-0"
                                            onclick="edit_activite('${el.getId()}', '${el.getMarcheId()}', '${el.getCodeActivite()}', '${el.getMontant()}', '${el.getTaux()}')"
                                            data-bs-toggle="modal" data-bs-target="#activiteEditModal">
                                        <i class="bi bi-pencil"></i>
                                    </button>
                                    <button class="btn btn-sm btn-outline-danger border-0"
                                            onclick="supprimer_activite('${el.getId()}','${el.getCodeActivite()}')"
                                            data-bs-toggle="modal" data-bs-target="#activiteDeleteModal">
                                        <i class="bi bi-trash"></i>
                                    </button>
                                </td>
                            </tr>
                        @endfor
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Section NIF -->
        <div class="col-lg-4">
            <div class="card border-0 shadow-sm h-100">
                <div class="card-header bg-white d-flex justify-content-between align-items-center py-3">
                    <h5 class="mb-0 fw-bold">NIF Associés</h5>
                    <button class="btn btn-sm btn-success rounded-pill" data-bs-toggle="modal"
                            data-bs-target="#nifAddModal">
                        <i class="bi bi-plus-lg me-1"></i> Ajouter
                    </button>
                </div>
                <div class="card-body p-0">
                    <div class="list-group list-group-flush">
                        @for(var el : marcheNifDTOs)
                            <div class="list-group-item py-3 d-flex justify-content-between align-items-center">
                                <div>
                                    <div class="fw-bold text-dark">${el.getIdentifiant()}</div>
                                    <div class="small text-muted">${el.getRaisonSocial()}</div>
                                </div>
                                <button class="btn btn-link text-danger p-0"
                                        onclick="supprimer_nif('${el.getId()}','${el.getIdentifiant()}', '${el.getRaisonSocial()}')"
                                        data-bs-toggle="modal" data-bs-target="#nifDeleteModal">
                                    <i class="bi bi-trash text-danger"></i>
                                </button>
<%--                                <div>--%>
<%--                                    <button class="btn btn-sm btn-outline-primary border-0"--%>
<%--                                            onclick="edit_nif('${el.getId()}', '${el.getIdentifiant()}')"--%>
<%--                                            data-bs-toggle="modal" data-bs-target="#nifEditModal">--%>
<%--                                        <i class="bi bi-pencil"></i>--%>
<%--                                    </button>--%>
<%--                            </div>--%>
                            </div>
                        @endfor
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal activité -->
    <div class="modal fade" id="activiteAddModal" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border-0 shadow">
                <div class="modal-header bg-success text-white">
                    <h5 class="modal-title">Nouvelle Activité</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
                </div>
                <form action="/marche/savemarcheActivite" method="post">
                    <div class="modal-body p-4">
                        <input type="hidden" name="marcheId" value="${marcheDTO.getId()}">

                        <div class="mb-3">
                            <label class="form-label fw-bold small">Sélectionner l'Activité</label>
                            <select class="form-select border-success-subtle" name="codeActivite" id="selectActivite" required>
                                <option value="">Choisir...</option>
                                @for(var el: dppActiviteList)
                                    <option value="${el.getCodeActivite()}">${el.getCodeActivite()}
                                        - ${el.getIntituleActivite()}</option>
                                @endfor
                            </select>
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label fw-bold small">Montant HT</label>
                                <div class="input-group">
                                    <input type="number" class="form-control border-success-subtle" name="montant"
                                           required>
                                    <span class="input-group-text">CFA</span>
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label class="form-label fw-bold small">Taux (%)</label>
                                <input type="number" class="form-control border-success-subtle" name="taux" value=""
                                       required>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer bg-light border-0">
                        <button type="button" class="btn btn-secondary px-4" data-bs-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-success px-4">Enregistrer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="activiteEditModal" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border-0 shadow">
                <div class="modal-header bg-success text-white">
                    <h5 class="modal-title">Modifier Activité</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
                </div>
                <form action="/marche/updatemarcheActivite" method="post">
                    <div class="modal-body p-4">
                        <input type="hidden" id="edit_marcheId" name="marcheId">
                        <input type="hidden" id="edit_id" name="id">

                        <div class="mb-3">
                            <label class="form-label fw-bold small">Sélectionner l'Activité</label>
                            <select class="form-select border-success-subtle" name="codeActivite" id="edit_codeActivite" required readonly>
                                <option value="">Choisir...</option>
                                @for(var el: dppActiviteList)
                                    <option value="${el.getCodeActivite()}">${el.getCodeActivite()}
                                        - ${el.getIntituleActivite()}</option>
                                @endfor
                            </select>
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label fw-bold small">Montant HT</label>
                                <div class="input-group">
                                    <input type="number" class="form-control border-success-subtle" name="montant" id="edit_montant"
                                           required>
                                    <span class="input-group-text">CFA</span>
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label class="form-label fw-bold small">Taux (%)</label>
                                <input type="number" class="form-control border-success-subtle" name="taux" id="edit_taux"
                                       required>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer bg-light border-0">
                        <button type="button" class="btn btn-secondary px-4" data-bs-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-success px-4">Enregistrer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="activiteDeleteModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border-0 shadow-lg">
                <div class="modal-body p-4 text-center">
                    <div class="mb-3">
                        <i class="bi bi-x-circle text-danger" style="font-size: 3.5rem;"></i>
                    </div>

                    <h5 class="fw-bold text-dark">Supprimer l'activité  : <span id="activiteToDelete"></span> ?</h5>
                    <p class="text-muted small" id="deleteActiviteMsg">
                        Cette action est irréversible.
                    </p>

                    <div class="d-grid gap-2 d-md-flex justify-content-center mt-4">
                        <button type="button" class="btn btn-light px-4 border" data-bs-dismiss="modal">Annuler</button>
                        <a id="btn-confirm-delete-activite" href="#" class="btn btn-danger px-4 shadow-sm">
                            Confirmer
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal nif -->
    <div class="modal fade" id="nifAddModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border-0 shadow">
                <div class="modal-header bg-success text-white">
                    <h5 class="modal-title"><i class="bi bi-person-plus me-2"></i>Associer un NIF</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
                </div>
                <form action="/marche/savemarcheNif" method="post">
                    <div class="modal-body p-4">
                        <input type="hidden" name="marcheId" value="${marcheDTO.getId()}">

                        <div class="mb-3">
                            <label class="form-label fw-bold small text-uppercase">Sélectionner l'Identifiant Fiscal (NIF)</label>
                            <select class="form-select border-success-subtle" name="identifiant" id="selectNif" required>
                                <option value="">Rechercher un NIF...</option>
                                @for(var el : nifList)
                                    <option value="${el.getIdentifiant()}">${el.getIdentifiant()} - ${el.getRaisonSociale()}</option>
                                @endfor
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer bg-light border-0">
                        <button type="button" class="btn btn-secondary px-4" data-bs-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-success px-4">
                            <i class="bi bi-check-circle me-1"></i> Valider l'association
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>




    <div class="modal fade" id="nifEditModal" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border-0 shadow">
                <div class="modal-header bg-success text-white">
                    <h5 class="modal-title">Modifier Nif</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
                </div>
                <form action="/marche/updatemarcheNif" method="post">
                    <div class="modal-body p-4">
                        <input type="hidden" id="edit_marcheId" name="marcheId">
                        <input type="hidden" id="edit_id" name="id">

                        <div class="mb-3">
                            <label class="form-label fw-bold small">Sélectionner le nif</label>
                            <select class="form-select border-success-subtle" name="codeActivite" id="edit_identifiant" >
                                <option value="">Choisir...</option>
                                @for(var el: nifList)
                                    <option value="${el.getIdentifiant()}">${el.getIdentifiant()}
                                        - ${el.getRaisonSociale()}</option>
                                @endfor
                            </select>
                        </div>

                        <div class="modal-footer bg-light border-0">
                            <button type="button" class="btn btn-secondary px-4" data-bs-dismiss="modal">Annuler</button>
                            <button type="submit" class="btn btn-success px-4">Enregistrer</button>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>





    <div class="modal fade" id="nifDeleteModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border-0 shadow">
                <div class="modal-body p-4 text-center">
                    <i class="bi bi-exclamation-triangle text-danger" style="font-size: 3rem;"></i>
                    <h5 class="mt-3 fw-bold">Confirmation</h5>
                    <p class="text-muted" id="deleteMsgNif">Voulez-vous détacher ce NIF :<span id="nifToDelete"></span> ?</p>
                    <div class="d-flex gap-2 justify-content-center mt-4">
                        <button type="button" class="btn btn-light px-4" data-bs-dismiss="modal">Non</button>
                        <a id="btn-confirm-delete-nif" href="#" class="btn btn-danger px-4">Oui, Supprimer</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        function supprimer_nif(id, identifiant, rs) {
            const text = identifiant + " - " + rs
            const c = document.getElementById("nifToDelete");
            nifToDelete.innerHTML = text;

            const nifId = document.getElementById("btn-confirm-delete-nif");
            nifId.setAttribute("href", "/marche/nif/delete/" + id);


        }

        function edit_nif(id, identifiant) {
            document.getElementById('edit_id').value = id;
            document.getElementById('edit_identifiant').value = identifiant;

        }



        function supprimer_activite(id, codeActivite) {
            const text = codeActivite
            const activiteToDelete = document.getElementById("activiteToDelete");
            activiteToDelete.innerHTML = text;

            const activiteId = document.getElementById("btn-confirm-delete-activite");
            activiteId.setAttribute("href", "/marche/activite/delete/" + id);


        }


        function edit_activite(id, marcheId, codeActivite, montant, taux) {
            document.getElementById('edit_id').value = id;
            document.getElementById('edit_marcheId').value = marcheId;
            document.getElementById('edit_codeActivite').value = codeActivite;
            document.getElementById('edit_montant').value = montant;
            document.getElementById('edit_taux').value = taux;
        }

        new SlimSelect({
            select: '#selectActivite',
            placeholder: 'Rechercher une activité...'
        });


        new SlimSelect({
            select: '#selectNif',
            placeholder: 'Rechercher un NIF...'
        });




    </script>
`)



