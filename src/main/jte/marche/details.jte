@import com.advinteck.cegib.dto.ActiviteDTO
@import com.advinteck.cegib.dto.MarcheDTO
@import com.advinteck.cegib.generated.marche.tables.MarcheActivite
@import com.advinteck.cegib.generated.referentiel.tables.pojos.*
@import com.advinteck.cegib.dto.NifDTO
@import com.advinteck.cegib.generated.marche.tables.pojos.*
@import java.util.Map
@import java.util.List
@import org.springframework.validation.BindingResult

@param List<Nifs>  nifList
@param List<DppdActivite>  dppActiviteList
@param BindingResult  bindingResult
@param MarcheDTO marcheDTO
@param NifDTO nifDTO
@param Map<String, String> messages
@param List<NifDTO> marcheNifDTOs
@param List<ActiviteDTO> marcheActiviteDTOs
@template.layout(
title = "Détail du marché",
messages = messages,
content = @`
    <div class="card">
        <div class="mt-2 mb-3 text-end">
            <a href="/marche/list" class="btn btn-warning">Retour</a>
        </div>
        <div class="card mb-5">
            <div class="card-header">Information générale</div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <b>ID : </b> ${marcheDTO.getId()}
                </li>

                <li class="list-group-item">
                    <b>Num de marché : </b> ${marcheDTO.getNumMarche()}
                </li>

                <li class="list-group-item">
                    <b>Imputation : </b> ${marcheDTO.getImputation()}
                </li>

                <li class="list-group-item">
                    <b>Objet du marché : </b> ${marcheDTO.getObjetMarche()}
                </li>

                <li class="list-group-item">
                    <b>Date d'approbation : </b> ${marcheDTO.getDateApprobation().toString()}
                </li>

                <li class="list-group-item">
                    <b>Autorite contractante : </b> ${marcheDTO.getAutoriteContractanteIntitule()}
                </li>

                <li class="list-group-item">
                    <b>Structure de l'autorite contractante
                        : </b> ${marcheDTO.getStructureAutoriteContractanteIntutule()}
                </li>

                <li class="list-group-item">
                    <b>Approuvé ar : </b> ${marcheDTO.getApprouvePar()}
                </li>

                <li class="list-group-item">
                    <b>Titulaire du marché : </b> ${marcheDTO.getTitulaireMarche()}
                </li>

                <li class="list-group-item">
                    <b>Type de marché : </b> ${marcheDTO.getTypeMarcheIntitule()}
                </li>

                <li class="list-group-item">
                    <b>Mode de passation : </b> ${ marcheDTO.getModePassationIntitule()}
                </li>

            </ul>
        </div>
    </div>


    <div class="row">
        <div class="col-md-6 ">
            <div class="card">
                <div class="card-header">Activités</div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        @for(var el : marcheActiviteDTOs)

                            <li class="list-group-item">
                                <b>CodeActivite : </b> ${el.getCodeActivite()}  |  ${el.getIntituleActivite()}  |  ${el.getTaux()}  |  ${el.getMontant()}  |
                                <i data-bs-toggle="modal" onclick="supprimer_activite( '${el.getId()}','${el.getCodeActivite()}')"
                                   data-bs-target="#activiteDeleteModal" class="bi bi-trash text-danger"></i> |

                                <i data-bs-toggle="modal"
                                   data-bs-target="#activiteEditModal"
                                   onclick="edit_activite('${el.getId()}', '${el.getMarcheId()}', '${el.getCodeActivite()}', '${el.getMontant()}', '${el.getTaux()}')"
                                   class="bi bi-pencil-square text-primary me-2"
                                   style="cursor: pointer;">
                                </i>



                            </li>







                        @endfor

                        <li class="list-group-item text-center">
                            <span class="btn btn-success">
                               <span href="#" class="btn" data-bs-toggle="modal"
                                     data-bs-target="#activiteAddModal">Ajouter</span>
                            </span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">NIF</div>
                <div class="card-body">
                    <ul class="list-group list-group-flush">

                        @for(var el : marcheNifDTOs)

                            <li class="list-group-item">
                                <b>Identifiant : </b> ${el.getIdentifiant()} | ${el.getRaisonSociale()} |
                                <i data-bs-toggle="modal" onclick="supprimer_nif( '${el.getId()}','${el.getIdentifiant()}', '${el.getRaisonSociale()}')"
                                   data-bs-target="#nifDeleteModal" class="bi bi-trash text-danger"></i>
                            </li>
                        @endfor

                        <li class="list-group-item text-center">
                            <span class="btn btn-success">
                               <span href="#" class="btn" data-bs-toggle="modal"
                                     data-bs-target="#nifAddModal">Ajouter</span>
                            </span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="activiteAddModal" tabindex="-1"
         aria-labelledby="activiteAddModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-success"> Ajout d'une activité au marché</div>
                <div class="card-body">
                    <form action="/marche/savemarcheActivite" method="post">
                        <div class="row mb-3">

                            <input type="hidden" name="marcheId" value="${marcheDTO.getId()}">

                            <div class="form-floating mb-3 col-md-6">
                                <select class="form-select" name="codeActivite" id="codeActivite">
                                    <option value="">Veuillez selectionner
                                    </option>
                                    @for(var el: dppActiviteList)
                                        <option value="${el.getCodeActivite()}">
                                            ${el.getCodeActivite()}
                                        </option>
                                    @endfor
                                </select>
                                <label for="codeActivite"> Activité  </label>
                            </div>

                            <div class="form-floating mb-3 col-md-6">
                                <input type="number" class="form-control" id="montant" name="montant" placeholder="Montant" >
                                <label for="montant">Montant </label>


                            </div>


                            <div class="form-floating mb-3 col-md-6">
                                <input type="number" class="form-control" id="taux" name="taux" placeholder="Taux" >
                                <label for="taux"> Taux </label>


                            </div>



                            <div>
                                <button type="submit" class="btn btn-primary">Enregistrer</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                    Annuler
                                </button>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="activiteDeleteModal" tabindex="-1"
         aria-labelledby="activiteDeleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-danger"> suppression d'une activité du marché</div>
                <div class="card-body">
                    Voulez-vous supprimer l'activité : <span id="activiteToDelete" class="fw-bold">Code_activité à supprimer</span>
                </div>
                <div>
                    <a href="#" id="activiteId" class="btn btn-danger">Supprimer</a>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                        Annuler
                    </button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="activiteEditModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-primary text-white"> Modification de l'activité </div>
                <div class="card-body">
                    <!-- L'ACTION DOIT ÊTRE L'URL DE TON @PostMapping -->
                    <form action="/marche/updatemarcheActivite" method="post">
                        <div class="row mb-3">
                            <!-- Les names doivent être EXACTEMENT ceux de ton ActiviteDTO -->
                            <input type="hidden" name="id" id="edit_id">
                            <input type="hidden" name="marcheId" id="edit_marcheId">

                            <div class="form-floating mb-3 col-md-12">
                                <input type="text" class="form-control" id="edit_codeActivite" name="codeActivite" readonly>
                                <label for="edit_codeActivite"> Code de l'activité </label>
                            </div>

                            <div class="form-floating mb-3 col-md-6">
                                <input type="number" class="form-control" id="edit_montant" name="montant" required>
                                <label for="edit_montant">Montant</label>
                            </div>

                            <div class="form-floating mb-3 col-md-6">
                                <input type="number" class="form-control" id="edit_taux" name="taux" required>
                                <label for="edit_taux">Taux</label>
                            </div>

                            <div class="mt-3">
                                <button type="submit" class="btn btn-primary">Enregistrer</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>








    <div class="modal fade" id="nifAddModal" tabindex="-1"
         aria-labelledby="nifAddModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-success"> Ajout d'un nif au marché</div>
                <div class="card-body">
                    <form action="/marche/savemarcheNif" method="post">
                        <div class="row mb-3">

                            <input type="hidden" name="marcheId" value="${marcheDTO.getId()}">

                            <div class="form-floating mb-3 col-md-6">
                                <select class="form-select" name="identifiant" id="identifiant">
                                    <option value="">Veuillez selectionner
                                    </option>
                                    @for(var el: nifList)
                                        <option value="${el.getIdentifiant()}">
                                            ${el.getIdentifiant()} - ${el.getRaisonSociale()}
                                        </option>
                                    @endfor
                                </select>
                                <label for="identifiant"> Nif  </label>
                            </div>
                            <div>
                                <button type="submit" class="btn btn-primary">Enregistrer</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                    Annuler
                                </button>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="nifDeleteModal" tabindex="-1"
         aria-labelledby="nifDeleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-danger"> suppression d'un nif du marché</div>
                <div class="card-body">
                    Voulez-vous supprimer ce nif : <span id="nifToDelete" class="fw-bold">Identifiant à supprimer</span>
                    </div>
                <div>
                    <a href="#" id="nifId" class="btn btn-danger">Supprimer</a>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                        Annuler
                    </button>
                </div>
            </div>
        </div>
    </div>

    <script>
        function supprimer_nif(id, identifiant, rs) {
            const text = identifiant + " - " + rs
           const nifToDelete = document.getElementById("nifToDelete");
           nifToDelete.innerHTML = text;

            const nifId = document.getElementById("nifId");
            nifId.setAttribute("href", "/marche/nif/delete/" + id);


        }



        function supprimer_activite(id, codeActivite) {
            const text = codeActivite
            const activiteToDelete = document.getElementById("activiteToDelete");
            activiteToDelete.innerHTML = text;

            const activiteId = document.getElementById("activiteId");
            activiteId.setAttribute("href", "/marche/activite/delete/" + id);


        }



        function edit_activite(id, marcheId, codeActivite, montant, taux) {
            document.getElementById('edit_id').value = id;
            document.getElementById('edit_marcheId').value = marcheId;
            document.getElementById('edit_codeActivite').value = codeActivite;
            document.getElementById('edit_montant').value = montant;
            document.getElementById('edit_taux').value = taux;
        }








    </script>
`)



