@import com.advinteck.cegib.dto.ActiviteDTO
@import com.advinteck.cegib.dto.MarcheDTO
@import com.advinteck.cegib.dto.NifDTO
@import java.util.Map
@import java.util.List

@param MarcheDTO marcheDTO
@param Map<String, String> messages
@param List<NifDTO> marcheNifDTOs
@param List<ActiviteDTO> marcheActiviteDTOs

@template.layout(
title = "Suppression Marché",
messages = messages,
content = @`



    <!-- Actions Bar -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h4 class="text-danger fw-bold">
<%--            <!-- Actions Bar -->--%>
<%--            <div class="d-flex justify-content-between align-items-center mb-4">--%>
<%--                <h4 class="text-danger fw-bold">--%>
<%--                    <i class=""></i>--%>
<%--                </h4>--%>

<%--            </div>--%>

            <!-- Modal de suppression -->
            <div class="modal fade" id="del${marcheDTO.getId()}" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-lg">
                    <div class="modal-content border-0 shadow">
                        <div class="modal-body p-4 text-center">
                            <div class="rounded-circle bg-danger-subtle d-inline-flex align-items-center justify-content-center mb-3"
                                 style="width:56px;height:56px;">
                                <i class="bi bi-trash text-danger fs-4"></i>
                            </div>
                            <p class="text-muted mb-1 small">Souhaitez-vous supprimer le marché de numéro provisoire <code class="text-danger">${marcheDTO.getNumMarche()}</code> ?</p>
                            <div class="d-flex gap-2 justify-content-center mt-3">
                                <button type="button" class="btn btn-sm btn-outline-secondary px-4" data-bs-dismiss="modal">Non</button>
                                <a href="/marche/delete/Delete/${marcheDTO.getId()}" class="btn btn-outline-danger shadow-sm">
                                    <i class="bi bi-arrow me-1"></i> Oui

                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </h4>

        <div class="d-flex gap-2">

            <a href="/marche/list" class="btn btn-outline-secondary shadow-sm">
                <i class="bi bi-arrow-left me-1"></i>Retour à la liste
            </a>

        </div>
    </div>




    <div class="card border shadow-none mb-4">
        <div class="card-header bg-white d-flex justify-content-between align-items-center py-3 border-bottom">
            <h6 class="mb-0 fw-semibold">Informations générales</h6>
            <a type="button" class="btn btn-outline-danger shadow-sm" data-bs-toggle="modal" data-bs-target="#del${marcheDTO.getId()}">
                <i class="bi bi-trash me-1"></i> Supprimer
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
                </div>
                <div class="table-responsive">
                    <table class="table table-hover align-middle mb-0 small">
                        <thead class="table-light">
                        <tr class="text-uppercase text-muted" style="font-size:.68rem;letter-spacing:.05em;">
                            <th class="ps-3 fw-semibold py-2">Code / Intitulé</th>
                            <th class="text-center fw-semibold py-2">Taux</th>
                            <th class="text-end fw-semibold py-2">Montant HT</th>
                            <th class="text-end fw-semibold py-2">Montant TTC</th>
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
                </div>
                <ul class="list-group list-group-flush">
                    @for(var el : marcheNifDTOs)
                        <li class="list-group-item d-flex align-items-center gap-3 py-3">
                            <div class="flex-grow-1 min-width-0">
                                <div class="fw-semibold small font-monospace">${el.getIdentifiant()}</div>
                                <div class="text-muted text-truncate" style="font-size:.78rem;">${el.getRaisonSocial()}</div>
                            </div>
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

`)