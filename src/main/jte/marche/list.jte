@import com.advinteck.cegib.dto.MarcheDTO
@import java.util.List
@import java.util.Map

@param List<MarcheDTO> marches
@param Map<String, String> messages

@template.layout(
title = "Liste des marchés",
messages = messages,
content = @`
    <div class="text-end">
        <a href="/marche/addForm" class="btn btn-primary">Formulaire d'ajout</a>

    </div>

    ${marches.size()} marchés

    <table id="marches" class="table table-striped border">
        <thead>
        <tr>
            <th>Numéro </th>
            <th class="text-center">Objet </th>
            <th class="text-center">Type </th>
            <th>Mode de passation</th>
            <th class="text-center">Structure  </th>
            <th>Approuvé par </th>
            <th>Date d'approbation</th>
            <th>Titulaire </th>
            <th >Actions</th>
        </tr>
        </thead>
        <tbody>
        @for(var marche : marches)
            <tr>
                <td> ${marche.getNumMarche()} </td>
                <td> ${marche.getObjetMarche()} </td>
                <td> ${marche.getTypeMarcheIntitule()} </td>
                <td> ${marche.getModePassationIntitule()} </td>
                <td> ${marche.getStructureAutoriteContractanteIntutule()} </td>
                <td> ${marche.getApprouvePar()} </td>
                <td> ${marche.getDateApprobation().toString()} </td>
                <td> ${marche.getTitulaireMarche()} </td>

                <td >



                    <div class="btn-group">
                        <div class="dropdown" >

                            <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                Choisir l'opération
                            </button>
                            <ul class="dropdown-menu">
                            <li class="bg-primary">
                                <a href="/marche/details/${marche.getId()}" class="dropdown-item">Details</a>
                            </li>

                            <li>
                                <a href="/marche/edit/${marche.getId()}" class="dropdown-item">Modifier</a>
                            </li>

                            <li>
                                <button type="button" class="dropdown-item" data-bs-toggle="modal"
                                        data-bs-target="#exampleModal${marche.getId()}">
                                    Supprimer
                                </button>
                            </li>

                            </ul>
                        </div>



                        <div class="modal fade" id="exampleModal${marche.getId()}" tabindex="-1"
                             aria-labelledby="exampleModalLabel${marche.getId()}" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel${marche.getId()}">Supprimer</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Êtes-vous sûr de vouloir supprimer cet marché : <b>${marche.getNumMarche()}</b> ?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                            Annuler
                                        </button>
                                        <a href="/marche/delete/${marche.getId()}" class="btn btn-danger">Suprimer</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        @endfor
        </tbody>
    </table>

    <script>
        new DataTable('#marchesList' , {
            language: {
                info: 'Page _PAGE_ sur _PAGES_',
                infoEmpty: ' ',
                infoFiltered: '(filtré depuis _MAX_ marches)',
                lengthMenu: 'Affichage _MENU_ marches par page',
                zeroRecords: 'Aucun marché trouvé.',
                search:'Recherche'
            },

            columnDefs: [
                {
                    target: 0,
                    className: "col-3"
                },
                {
                    target: 1,
                    className: "col-2"
                },

                {
                    target: 2,
                    className: "col-2"
                },
                {
                    target: 3,
                    className: "col-1"
                },
                {
                    target: 2,
                    className: "col-2"
                },

                {
                    target: 4,
                    className: "col-2 "
                },

                {
                    target: 5,
                    className: "col-3"
                },

                {
                    target: 6,
                    className: "col-3"
                },

                {
                    target: 7,
                    className: "col-3"
                },

                {
                    target: 8,
                    className: "col-3"
                },

                {
                    target: 9,
                    className: "col-3"
                },

                {
                    target: 10,
                    className: "col-3"
                },

                {
                    target: 11,
                    className: "col-3"
                },
                {
                    target: 12,
                    className: "col-3"
                }
            ]
        }) ;

    </script>
`)