@import com.advinteck.cegib.dto.MarcheDTO
@import java.util.List
@import java.util.Map

@param List<MarcheDTO> marches
@param Map<String, String> messages

@template.layout(
title = "Liste des marchés",
messages = messages,
content = @`
    <div class="d-flex justify-content-between align-items-center mb-3">
        <div>

            <small class="text-muted">${marches.size()} éléments trouvés dans la liste</small>
        </div>
        <a href="/marche/addForm" class="btn btn-success px-4">
            <i class="bi bi-plus-lg me-1"></i> Nouveau marché
        </a>
    </div>

    <div class="card shadow-sm border-0">
        <div class="card-body p-0">
            <table id="marches" class="table table-hover align-middle mb-0">
                <thead class="table-light">
                <tr>
<%--                    <th class="ps-3">Numéro</th>--%>
                    <th>Objet</th>
                    <th>Type</th>
                    <th>Passation</th>
                    <!-- Colonne Structure avec largeur fixe et troncature -->
<%--                    <th style="max-width: 150px;">Structure</th>--%>
                    <th>Approbation</th>
<%--                    <th>Titulaire</th>--%>
                    <th class="text-end pe-3">Actions</th>
                </tr>
                </thead>
                <tbody>
                @for(var marche : marches)
                    <tr>
<%--                        <td class="ps-3 fw-bold text-nowrap">${marche.getNumMarche()}</td>--%>
                        <td><div class="text-truncate" style="max-width: 180px;" title="${marche.getObjetMarche()}">${marche.getObjetMarche()}</div></td>
                        <td><span class="badge bg-secondary-soft text-dark border">${marche.getTypeMarcheIntitule()}</span></td>
                        <td><small>${marche.getModePassationIntitule()}</small></td>

                        <!-- * les pointillés -->
<%--                        <td>--%>
<%--                            <div class="text-truncate" style="max-width: 150px;" title="${marche.getStructureAutoriteContractanteIntutule()}">--%>
<%--                                ${marche.getStructureAutoriteContractanteIntutule()}--%>
<%--                            </div>--%>
<%--                        </td>--%>

                      <td><small>${marche.getDateApprobation().toString()}</small></td>
<%--                        <td>${marche.getTitulaireMarche()}</td>--%>
                        <td class="text-end pe-3 text-nowrap">
                            <div class="btn-group">
                                <a href="/marche/details/${marche.getId()}" class="btn btn-sm btn-outline-info">Détails</a>
                                <a href="/marche/edit/${marche.getId()}" class="btn btn-sm btn-outline-warning">Modifier</a>
                                <button type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#del${marche.getId()}">
                                    Supprimer
                                </button>
                            </div>

                            <!-- Modal de suppression -->
                            <div class="modal fade" id="del${marche.getId()}" tabindex="-1" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered text-start">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">Confirmer la suppression</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                        </div>
<%--                                        <div class="modal-body">--%>
<%--                                            Voulez-vous supprimer le marché : <b>${marche.getNumMarche()}</b> ?--%>
<%--                                        </div>--%>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                                            <a href="/marche/delete/${marche.getId()}" class="btn btn-danger">Supprimer définitivement</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                @endfor
                </tbody>
            </table>
        </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            new DataTable('#marches', {
                // Traduction intégrée directement pour éviter l'erreur i18n
                language: {
                    processing:     "Traitement en cours...",
                    search:         "Rechercher&nbsp;:",
                    lengthMenu:    "Afficher _MENU_ éléments",
                    info:           "Affichage de l'élément _START_ à _END_ sur _TOTAL_ éléments",
                    infoEmpty:      "Affichage de l'élément 0 à 0 sur 0 élément",
                    infoFiltered:   "(filtré de _MAX_ éléments au total)",
                    loadingRecords: "Chargement en cours...",
                    zeroRecords:    "Aucun élément à afficher",
                    emptyTable:     "Aucune donnée disponible dans le tableau",
                    paginate: {
                        first:      "Premier",
                        previous:   "Précédent",
                        next:       "Suivant",
                        last:       "Dernier"
                    }
                },
                pageLength: 10,
                columnDefs: [
                    { targets: [7], orderable: false } // Désactive le tri sur la colonne Actions
                ]
            });
        });
    </script>

`)
