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
                <div class="modal-dialog modal-dialog-centered text-start">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-dark fs-6"  >Êtes-vous sûr de vouloir supprimer ce marché ?</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <%--                                        <div class="modal-body">--%>
                        <%--                                            Voulez-vous supprimer le marché : <b>${marche.getNumMarche()}</b> ?--%>
                        <%--                                        </div>--%>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                            <a href="/marche/delete/Delete/${marcheDTO.getId()}" class="btn btn-outline-danger shadow-sm">
                                <i class="bi bi-arrow me-1"></i> Oui supprimer définitivement

                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </h4>

        <div class="d-flex gap-2">

            <a type="button" class="btn btn-outline-danger shadow-sm" data-bs-toggle="modal" data-bs-target="#del${marcheDTO.getId()}">
                <i class="bi  me-1"></i>Supprimer
            </a>

            <a href="/marche/list" class="btn btn-outline-secondary shadow-sm">
                <i class="bi bi-arrow-left me-1"></i>Retour à la liste
            </a>

        </div>
    </div>



    <!-- Infos Générales -->
    <div class="card border-0 shadow-sm mb-4">
        <div class="card-header bg-white py-3">
            <h5 class="mb-0 text-dark fw-bold">
                Informations Générales
            </h5>
        </div>

        <div class="card-body">
            <div class="row g-3">

                <div class="col-md-3 col-6">
                    <small class="fw-bold d-block">ID Interne</small>
                    <span class="small text-dark">
                        ${marcheDTO.getId()}
                    </span>
                </div>

                <div class="col-md-5">
                    <small class="fw-bold d-block">
                        Objet du Marché
                    </small>

                    <p class="mb-0 fw-medium">
                        ${marcheDTO.getObjetMarche()}
                    </p>
                </div>

                <div class="col-md-3 col-6">
                    <small class="fw-bold d-block">
                        Imputation
                    </small>

                    <span class="small">
                        ${marcheDTO.getImputationIntitule()}
                    </span>
                </div>

                <div class="col-md-4">
                    <small class="fw-bold d-block">Type</small>

                    <span class="small">
                        ${marcheDTO.getTypeMarcheIntitule()}
                    </span>
                </div>

                <div class="col-md-4">
                    <small class="fw-bold d-block">Mode</small>

                    <span class="small">
                        ${marcheDTO.getModePassationIntitule()}
                    </span>
                </div>

                <div class="col-md-4">
                    <small class="fw-bold d-block">
                        Autorité Contractante
                    </small>

                    <span class="small">
                        ${marcheDTO.getAutoriteContractanteIntitule()}
                    </span>
                </div>

                <div class="col-md-4">
                    <small class="fw-bold d-block">
                        Structure Autorité Contractante
                    </small>

                    <span class="small">
                        ${marcheDTO.getStructureAutoriteContractanteIntutule()}
                    </span>
                </div>

                <div class="col-md-3 col-6">
                    <small class="fw-bold d-block">
                        Date Approbation
                    </small>

                    <span class="small">
                        ${marcheDTO.getDateApprobation().toString()}
                    </span>
                </div>

                <div class="col-md-3 col-6">
                    <small class="fw-bold d-block">
                        Approuvé par
                    </small>

                    <span class="badge bg-light text-dark border">
                        ${marcheDTO.getApprouvePar()}
                    </span>
                </div>

            </div>
        </div>
    </div>

    <div class="row g-4">

        <!-- ACTIVITES -->
        <div class="col-lg-8">

            <div class="card border-0 shadow-sm h-100">

                <div class="card-header bg-white py-3">
                    <h5 class="mb-0 fw-bold">
                        Activités Associées
                    </h5>
                </div>

                <div class="table-responsive">

                    <table class="table table-hover align-middle mb-0">

                        <thead class="table-light">
                        <tr class="small text-uppercase">
                            <th class="ps-4">
                                Code / Intitulé
                            </th>

                            <th class="text-center">
                                Taux (%)
                            </th>

                            <th class="text-end">
                                Montant HT
                            </th>

                            <th class="text-end">
                                Montant TTC
                            </th>
                        </tr>
                        </thead>

                        <tbody>

                        @for(var el : marcheActiviteDTOs)

                            <tr>

                                <td class="ps-4">
                                    <div class="fw-bold text-dark">
                                        ${el.getCodeActivite()}
                                    </div>

                                    <div class="small text-muted">
                                        ${el.getIntituleActivite()}
                                    </div>
                                </td>

                                <td class="text-center">
                                    <span class="badge bg-light text-dark">
                                        ${el.getTaux()}
                                    </span>
                                </td>

                                <td class="text-end fw-medium">
                                    ${String.format(java.util.Locale.FRANCE, "%,d", el.getMontant())}
                                </td>

                                <td class="text-end fw-bold text-success">
                                    ${String.format(java.util.Locale.FRANCE, "%,d", el.getMontant() * (100 + el.getTaux()) / 100)}
                                </td>

                            </tr>

                        @endfor

                        </tbody>

                    </table>

                </div>

            </div>

        </div>

        <!-- NIFS -->
        <div class="col-lg-4">

            <div class="card border-0 shadow-sm h-100">

                <div class="card-header bg-white py-3">
                    <h5 class="mb-0 fw-bold">
                        NIF Associés
                    </h5>
                </div>

                <div class="card-body p-0">

                    <div class="list-group list-group-flush">

                        @for(var el : marcheNifDTOs)

                            <div class="list-group-item py-3">

                                <div class="fw-bold text-dark">
                                    ${el.getIdentifiant()}
                                </div>

                                <div class="small text-muted">
                                    ${el.getRaisonSociale()}
                                </div>

                            </div>

                        @endfor

                    </div>

                </div>

            </div>

        </div>

    </div>

`)