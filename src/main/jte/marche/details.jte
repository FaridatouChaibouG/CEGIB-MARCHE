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

    <span id="marcheImputation" data-imputation="${marcheDTO.getImputation()}" style="display:none;"></span>

    <div class="d-flex justify-content-between align-items-center mb-4">
        <div class="d-flex align-items-center gap-3">
        <span class="badge text-bg-success-subtle border border-success-subtle text-success fw-semibold px-3 py-2 fs-6">
            ${marcheDTO.getNumMarche()}
        </span>
            <h5 class="mb-0 fw-semibold text-body">Détail du Marché</h5>
        </div>
        <a href="/marche/list" class="btn btn-sm btn-outline-secondary">
            <i class="bi bi-arrow-left me-1"></i> Retour à la liste
        </a>
    </div>


    <div class="card border shadow-none mb-4">
        <div class="card-header bg-white d-flex justify-content-between align-items-center py-3 border-bottom">
            <h6 class="mb-0 fw-semibold">Informations générales</h6>
            <a href="/marche/edit/${marcheDTO.getId()}" class="btn btn-sm btn-success">
                <i class="bi bi-pencil me-1"></i> Modifier
            </a>
        </div>
        <div class="card-body">
            <div class="row g-4">

                <div class="col-md-3">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Numéro provisoire</p>
                    <p class="mb-0 fw-semibold">${marcheDTO.getNumMarche()}</p>
                </div>

                <div class="col-md-9">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Objet du marché</p>
                    <p class="mb-0 fw-semibold">${marcheDTO.getObjetMarche()}</p>
                </div>

                <div class="col-12"><hr class="my-0 opacity-10"></div>

                <div class="col-md-4">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Imputation budgétaire</p>
                    <p class="mb-0 small">${marcheDTO.getImputation()} – ${marcheDTO.getImputationIntitule()}</p>
                </div>

                <div class="col-md-4">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Type de marché</p>
                    <p class="mb-0 small">${marcheDTO.getTypeMarcheIntitule()}</p>
                </div>

                <div class="col-md-4">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Mode de passation</p>
                    <p class="mb-0 small">${marcheDTO.getModePassationIntitule()}</p>
                </div>

                <div class="col-md-4">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Autorité contractante</p>
                    <p class="mb-0 small">${marcheDTO.getAutoriteContractanteIntitule()}</p>
                </div>

                <div class="col-md-4">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Structure AC</p>
                    <p class="mb-0 small">${marcheDTO.getStructureAutoriteContractanteIntitule()}</p>
                </div>

                <div class="col-md-4">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Titulaire</p>
                    <p class="mb-0 small">${marcheDTO.getTitulaireMarche()}</p>
                </div>

                <div class="col-12"><hr class="my-0 opacity-10"></div>

                <div class="col-md-3">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Date d'approbation</p>
                    <p class="mb-0 small">
                        ${marcheDTO.getDateApprobation().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))}
                    </p>
                </div>

                <div class="col-md-3">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Approuvé par</p>
                    <p class="mb-0 small">${marcheDTO.getApprouvePar()}</p>
                </div>

                <div class="col-md-3">
                    <p class="text-uppercase text-muted fw-semibold mb-1" style="font-size:.68rem;letter-spacing:.06em;">Statut</p>
                    <span class="badge text-bg-success-subtle border border-success-subtle text-success small">
                    ${marcheDTO.getStatut()}
                </span>
                </div>

            </div>
        </div>
    </div>

    <div class="row g-4">

        <div class="col-lg-8">
            <div class="card border shadow-none h-100">
                <div class="card-header bg-white d-flex justify-content-between align-items-center py-3 border-bottom">
                    <h6 class="mb-0 fw-semibold">Activités</h6>
                    <button class="btn btn-sm btn-success" data-bs-toggle="modal" data-bs-target="#activiteAddModal">
                        <i class="bi bi-plus-lg me-1"></i> Ajouter
                    </button>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover align-middle mb-0 small">
                        <thead class="table-light">
                        <tr class="text-uppercase text-muted" style="font-size:.68rem;letter-spacing:.05em;">
                            <th class="ps-3 fw-semibold py-2">Code / Intitulé</th>
                            <th class="text-center fw-semibold py-2">Taux</th>
                            <th class="text-end fw-semibold py-2">Montant HT</th>
                            <th class="text-end fw-semibold py-2">Montant TTC</th>
                            <th class="text-center fw-semibold py-2" style="width:80px;"></th>
                        </tr>
                        </thead>
                        <tbody>
                        @for(var el : marcheActiviteDTOs)
                            <tr>
                                <td class="ps-3">
                                    <code class="text-success bg-success-subtle rounded px-1 py-0" style="font-size:.75rem;">${el.getCodeActivite()}</code>
                                    <div class="text-muted mt-1" style="font-size:.78rem;">${el.getIntituleActivite()}</div>
                                </td>
                                <td class="text-center">
                                    <span class="badge rounded-pill text-bg-light border text-muted fw-normal">${el.getTaux()}%</span>
                                </td>
                                <td class="text-end text-body-secondary font-monospace">
                                    ${String.format(java.util.Locale.FRANCE, "%,d", el.getMontant())}
                                </td>
                                <td class="text-end fw-semibold text-success font-monospace">
                                    ${String.format(java.util.Locale.FRANCE, "%,d", el.getMontant() * (100 + el.getTaux()) / 100)}
                                </td>
                                <td class="text-center">
                                    <div class="btn-group btn-group-sm">
                                        <button class="btn btn-outline-secondary border-0 px-2"
                                                onclick="edit_activite('${el.getId()}','${el.getMarcheId()}','${el.getCodeActivite()}','${el.getMontant()}','${el.getTaux()}')"
                                                data-bs-toggle="modal" data-bs-target="#activiteEditModal"
                                                title="Modifier">
                                            <i class="bi bi-pencil"></i>
                                        </button>
                                        <button class="btn btn-outline-danger border-0 px-2"
                                                onclick="supprimer_activite('${el.getId()}','${el.getCodeActivite()}')"
                                                data-bs-toggle="modal" data-bs-target="#activiteDeleteModal"
                                                title="Supprimer">
                                            <i class="bi bi-trash"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        @endfor
                        @if(marcheActiviteDTOs.isEmpty())
                            <tr>
                                <td colspan="5" class="text-center text-muted py-4" style="font-size:.85rem;">
                                    <i class="bi bi-inbox me-2"></i>Aucune activité enregistrée
                                </td>
                            </tr>
                        @endif
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- NIF -->
        <div class="col-lg-4">
            <div class="card border shadow-none h-100">
                <div class="card-header bg-white d-flex justify-content-between align-items-center py-3 border-bottom">
                    <h6 class="mb-0 fw-semibold">NIF associés</h6>
                    <button class="btn btn-sm btn-success" data-bs-toggle="modal" data-bs-target="#nifAddModal">
                        <i class="bi bi-plus-lg me-1"></i> Ajouter
                    </button>
                </div>
                <ul class="list-group list-group-flush">
                    @for(var el : marcheNifDTOs)
                        <li class="list-group-item d-flex align-items-center gap-3 py-3">
                            <div class="flex-grow-1 min-width-0">
                                <div class="fw-semibold small font-monospace">${el.getIdentifiant()}</div>
                                <div class="text-muted text-truncate" style="font-size:.78rem;">${el.getRaisonSocial()}</div>
                            </div>
                            <button class="btn btn-sm btn-outline-danger border-0 flex-shrink-0"
                                    onclick="supprimer_nif('${el.getId()}','${el.getIdentifiant()}','${el.getRaisonSocial()}')"
                                    data-bs-toggle="modal" data-bs-target="#nifDeleteModal"
                                    title="Détacher">
                                <i class="bi bi-trash"></i>
                            </button>
                        </li>
                    @endfor
                    @if(marcheNifDTOs.isEmpty())
                        <li class="list-group-item text-center text-muted py-4" style="font-size:.85rem;">
                            <i class="bi bi-person-x me-2"></i>Aucun NIF associé
                        </li>
                    @endif
                </ul>
            </div>
        </div>
    </div>


    <!-- ══════════════════════════════════════════════════════════════════ -->
    <!--  MODALES ACTIVITÉ                                                 -->
    <!-- ══════════════════════════════════════════════════════════════════ -->

    <!-- Modal – Ajout Activité -->
    <div class="modal fade" id="activiteAddModal" tabindex="-1" aria-labelledby="activiteAddModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border-0 shadow">
                <div class="modal-header border-bottom py-3">
                    <h6 class="modal-title fw-semibold" id="activiteAddModalLabel">
                        <i class="bi bi-plus-circle me-2 text-success"></i>Nouvelle activité
                    </h6>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form action="/marche/savemarcheActivite" method="post">
                    <div class="modal-body p-4">
                        <input type="hidden" name="marcheId" value="${marcheDTO.getId()}">

                        <div class="mb-3">
                            <label class="form-label fw-semibold small text-uppercase text-muted" style="font-size:.68rem;letter-spacing:.05em;">Activité</label>
                            <select class="form-select form-select-sm" name="codeActivite" id="selectActivite" required>
                                <option value="">Choisir une activité...</option>
                            </select>
                        </div>

                        <div class="row g-3">
                            <div class="col-7">
                                <label class="form-label fw-semibold small text-uppercase text-muted" style="font-size:.68rem;letter-spacing:.05em;">Montant HT</label>
                                <div class="input-group input-group-sm">
                                    <input type="number" class="form-control" name="montant" min="0" required placeholder="0">
                                    <span class="input-group-text text-muted">XOF</span>
                                </div>
                            </div>
                            <div class="col-5">
                                <label class="form-label fw-semibold small text-uppercase text-muted" style="font-size:.68rem;letter-spacing:.05em;">Taux TVA (%)</label>
                                <div class="input-group input-group-sm">
                                    <input type="number" class="form-control" name="taux" min="0" max="19" required placeholder="0">
                                    <span class="input-group-text text-muted">%</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer bg-light border-top py-2">
                        <button type="button" class="btn btn-sm btn-outline-secondary" data-bs-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-sm btn-success px-4">
                            <i class="bi bi-check-lg me-1"></i> Enregistrer
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Modal – Modification Activité -->
    <div class="modal fade" id="activiteEditModal" tabindex="-1" aria-labelledby="activiteEditModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border-0 shadow">
                <div class="modal-header border-bottom py-3">
                    <h6 class="modal-title fw-semibold" id="activiteEditModalLabel">
                        <i class="bi bi-pencil me-2 text-primary"></i>Modifier l'activité
                    </h6>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form action="/marche/updatemarcheActivite" method="post">
                    <div class="modal-body p-4">
                        <input type="hidden" id="edit_marcheId" name="marcheId">
                        <input type="hidden" id="edit_id" name="id">

                        <div class="mb-3">
                            <label class="form-label fw-semibold small text-uppercase text-muted" style="font-size:.68rem;letter-spacing:.05em;">Activité</label>
                            <select class="form-select form-select-sm" name="codeActivite" id="edit_codeActivite" required>
                                <option value="">Choisir...</option>
                                @for(var el: dppActiviteList)
                                    <option value="${el.getCodeActivite()}">${el.getCodeActivite()} – ${el.getIntituleActivite()}</option>
                                @endfor
                            </select>
                        </div>

                        <div class="row g-3">
                            <div class="col-7">
                                <label class="form-label fw-semibold small text-uppercase text-muted" style="font-size:.68rem;letter-spacing:.05em;">Montant HT</label>
                                <div class="input-group input-group-sm">
                                    <input type="number" class="form-control" name="montant" id="edit_montant" min="0" required>
                                    <span class="input-group-text text-muted">XOF</span>
                                </div>
                            </div>
                            <div class="col-5">
                                <label class="form-label fw-semibold small text-uppercase text-muted" style="font-size:.68rem;letter-spacing:.05em;">Taux TVA (%)</label>
                                <div class="input-group input-group-sm">
                                    <input type="number" class="form-control" name="taux" id="edit_taux" min="0" max="19" required>
                                    <span class="input-group-text text-muted">%</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer bg-light border-top py-2">
                        <button type="button" class="btn btn-sm btn-outline-secondary" data-bs-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-sm btn-success px-4">
                            <i class="bi bi-check-lg me-1"></i> Enregistrer
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Modal – Suppression Activité -->
    <div class="modal fade" id="activiteDeleteModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-sm">
            <div class="modal-content border-0 shadow">
                <div class="modal-body p-4 text-center">
                    <div class="rounded-circle bg-danger-subtle d-inline-flex align-items-center justify-content-center mb-3"
                         style="width:56px;height:56px;">
                        <i class="bi bi-trash text-danger fs-4"></i>
                    </div>
                    <p class="text-muted mb-1 small">Supprimer l'activité de <code id="activiteToDelete" class="text-danger"></code> ?</p>
                    <div class="d-flex gap-2 justify-content-center mt-3">
                        <button type="button" class="btn btn-sm btn-outline-secondary px-4" data-bs-dismiss="modal">Non</button>
                        <a id="btn-confirm-delete-activite" href="#" class="btn btn-sm btn-danger px-4">Oui</a>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Modal – Ajout NIF -->
    <div class="modal fade" id="nifAddModal" tabindex="-1" aria-labelledby="nifAddModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border-0 shadow">
                <div class="modal-header border-bottom py-3">
                    <h6 class="modal-title fw-semibold" id="nifAddModalLabel">
                        <i class="bi bi-person-plus me-2 text-success"></i>Associer un NIF
                    </h6>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <form action="/marche/savemarcheNif" method="post">
                    <div class="modal-body p-4">
                        <input type="hidden" name="marcheId" value="${marcheDTO.getId()}">
                        <div class="mb-1">
                            <label class="form-label fw-semibold small text-uppercase text-muted" style="font-size:.68rem;letter-spacing:.05em;">
                                Numéro d'Identification fiscal (NIF)
                            </label>
                            <select class="form-select form-select-sm" name="identifiant" id="selectNif" required>
                                <option value="">Rechercher un NIF...</option>
                                @for(var el : nifList)
                                    <option value="${el.getIdentifiant()}">${el.getIdentifiant()} – ${el.getRaisonSociale()}</option>
                                @endfor
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer bg-light border-top py-2">
                        <button type="button" class="btn btn-sm btn-outline-secondary" data-bs-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-sm btn-success px-4">
                            <i class="bi bi-check-lg me-1"></i> Enregistrer
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Modal – Suppression NIF -->
    <div class="modal fade" id="nifDeleteModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-sm">
            <div class="modal-content border-0 shadow">
                <div class="modal-body p-4 text-center">
                    <div class="rounded-circle bg-warning-subtle d-inline-flex align-items-center justify-content-center mb-3"
                         style="width:56px;height:56px;">
                        <i class="bi bi-person-dash text-warning fs-4"></i>
                    </div>
                    <p class="text-muted small mb-1">
                        <span id="nifToDelete" class="fw-semibold text-body"></span>
                    </p>
                    <h6 class="fw-semibold mb-0">Détacher ce NIF du marhé?</h6>
                    <div class="d-flex gap-2 justify-content-center mt-3">
                        <button type="button" class="btn btn-sm btn-outline-secondary px-4" data-bs-dismiss="modal">Non</button>
                        <a id="btn-confirm-delete-nif" href="#" class="btn btn-sm btn-danger px-4">Oui</a>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <script>
        (function () {

            /* ── Chargement des activités filtrées par imputation ── */
            const imputation = document.getElementById("marcheImputation").dataset.imputation;

            fetch('/marche/activites-by-imputation/' + encodeURIComponent(imputation))
                .then(res => res.json())
                .then(activites => {
                    const select = document.getElementById("selectActivite");
                    select.innerHTML = '<option value="">Choisir une activité...</option>';
                    activites.forEach(a => {
                        const opt = document.createElement("option");
                        opt.value = a.codeActivite;
                        opt.textContent = a.codeActivite + " – " + a.intituleActivite;
                        select.appendChild(opt);
                    });
                    initSlimSelect('#selectActivite', 'Rechercher une activité...');
                })
                .catch(() => initSlimSelect('#selectActivite', 'Rechercher une activité...'));

            /* ── SlimSelect helper ── */
            function initSlimSelect(selector, placeholder) {
                if (typeof SlimSelect === 'undefined') return;
                new SlimSelect({ select: selector, placeholder: placeholder });
            }

            initSlimSelect('#selectNif', 'Rechercher un NIF...');
            initSlimSelect('#edit_codeActivite', 'Choisir...');

            /* ── Modales NIF ── */
            window.supprimer_nif = function (id, identifiant, rs) {
                document.getElementById("nifToDelete").textContent = identifiant + " – " + rs;
                document.getElementById("btn-confirm-delete-nif").href = "/marche/nif/delete/" + id;
            };

            /* ── Modales Activité ── */
            window.supprimer_activite = function (id, codeActivite) {
                document.getElementById("activiteToDelete").textContent = codeActivite;
                document.getElementById("btn-confirm-delete-activite").href = "/marche/activite/delete/" + id;
            };

            window.edit_activite = function (id, marcheId, codeActivite, montant, taux) {
                document.getElementById('edit_id').value = id;
                document.getElementById('edit_marcheId').value = marcheId;
                document.getElementById('edit_montant').value = montant;
                document.getElementById('edit_taux').value = taux;

                const sel = document.getElementById('edit_codeActivite');
                if (sel) {
                    sel.value = codeActivite;
                    /* Rafraîchir SlimSelect si initialisé */
                    if (sel.slim) sel.slim.setSelected(codeActivite);
                }
            };

        })();
    </script>
`)