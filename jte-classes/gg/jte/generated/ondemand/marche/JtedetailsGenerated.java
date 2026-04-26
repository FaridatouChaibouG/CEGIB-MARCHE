package gg.jte.generated.ondemand.marche;
import com.advinteck.cegib.dto.ActiviteDTO;
import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.generated.marche.tables.MarcheActivite;
import com.advinteck.cegib.generated.referentiel.tables.pojos.*;
import com.advinteck.cegib.dto.NifDTO;
import com.advinteck.cegib.generated.marche.tables.pojos.*;
import java.util.Map;
import java.util.List;
import org.springframework.validation.BindingResult;
@SuppressWarnings("unchecked")
public final class JtedetailsGenerated {
	public static final String JTE_NAME = "marche/details.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,5,6,7,8,10,10,10,10,18,21,21,30,30,30,34,34,34,38,38,38,42,42,42,46,46,46,50,50,50,55,55,55,59,59,59,63,63,63,67,67,67,71,71,71,85,85,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,89,89,89,89,89,89,89,89,94,94,94,94,94,94,94,94,94,94,94,94,94,94,94,94,94,94,94,94,109,109,127,127,130,130,130,130,130,130,131,131,131,131,131,131,131,131,131,131,131,131,134,134,157,157,157,157,157,157,157,157,157,163,163,164,164,164,164,164,164,164,164,164,165,165,165,167,167,275,275,275,275,275,275,275,275,275,281,281,282,282,282,282,282,282,282,282,282,283,283,283,283,283,283,285,285,364,364,364,368,368,368,10,11,12,13,14,15,16,17,17,17,17};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Nifs> nifList, List<DppdActivite> dppActiviteList, BindingResult bindingResult, MarcheDTO marcheDTO, NifDTO nifDTO, Map<String, String> messages, List<NifDTO> marcheNifDTOs, List<ActiviteDTO> marcheActiviteDTOs) {
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Détail du marché", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"card\">\n        <div class=\"mt-2 mb-3 text-end\">\n            <a href=\"/marche/list\" class=\"btn btn-warning\">Retour</a>\n        </div>\n        <div class=\"card mb-5\">\n            <div class=\"card-header\">Information générale</div>\n            <ul class=\"list-group list-group-flush\">\n                <li class=\"list-group-item\">\n                    <b>ID : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getId());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Num de marché : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getNumMarche());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Imputation : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getImputation());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Objet du marché : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getObjetMarche());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Date d'approbation : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getDateApprobation().toString());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Autorite contractante : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getAutoriteContractanteIntitule());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Structure de l'autorite contractante\n                        : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getStructureAutoriteContractanteIntutule());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Approuvé ar : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getApprouvePar());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Titulaire du marché : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getTitulaireMarche());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Type de marché : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(marcheDTO.getTypeMarcheIntitule());
				jteOutput.writeContent("\n                </li>\n\n                <li class=\"list-group-item\">\n                    <b>Mode de passation : </b> ");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent( marcheDTO.getModePassationIntitule());
				jteOutput.writeContent("\n                </li>\n\n            </ul>\n        </div>\n    </div>\n\n\n    <div class=\"row\">\n        <div class=\"col-md-6 \">\n            <div class=\"card\">\n                <div class=\"card-header\">Activités</div>\n                <div class=\"card-body\">\n                    <ul class=\"list-group list-group-flush\">\n                        ");
				for (var el : marcheActiviteDTOs) {
					jteOutput.writeContent("\n\n                            <li class=\"list-group-item\">\n                                <b>CodeActivite : </b> ");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.writeContent("  |  ");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(el.getIntituleActivite());
					jteOutput.writeContent("  |  ");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(el.getTaux());
					jteOutput.writeContent("  |  ");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(el.getMontant());
					jteOutput.writeContent("  | ");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(el.getMontant() * (100 + el.getTaux() / 100));
					jteOutput.writeContent(" |\n                                <i data-bs-toggle=\"modal\" onclick=\"supprimer_activite( '");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getId());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("','");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("')\"\n                                   data-bs-target=\"#activiteDeleteModal\" class=\"bi bi-trash text-danger\"></i> |\n\n                                <i data-bs-toggle=\"modal\"\n                                   data-bs-target=\"#activiteEditModal\"\n                                   onclick=\"edit_activite('");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getId());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getMarcheId());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getMontant());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getTaux());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("')\"\n                                   class=\"bi bi-pencil-square text-primary me-2\"\n                                   style=\"cursor: pointer;\">\n                                </i>\n\n\n\n                            </li>\n\n\n\n\n\n\n\n                        ");
				}
				jteOutput.writeContent("\n\n                        <li class=\"list-group-item text-center\">\n                            <span class=\"btn btn-success\">\n                               <span href=\"#\" class=\"btn\" data-bs-toggle=\"modal\"\n                                     data-bs-target=\"#activiteAddModal\">Ajouter</span>\n                            </span>\n                        </li>\n                    </ul>\n                </div>\n            </div>\n        </div>\n        <div class=\"col-md-6\">\n            <div class=\"card\">\n                <div class=\"card-header\">NIF</div>\n                <div class=\"card-body\">\n                    <ul class=\"list-group list-group-flush\">\n\n                        ");
				for (var el : marcheNifDTOs) {
					jteOutput.writeContent("\n\n                            <li class=\"list-group-item\">\n                                <b>Identifiant : </b> ");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(el.getIdentifiant());
					jteOutput.writeContent(" | ");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(el.getRaisonSociale());
					jteOutput.writeContent(" |\n                                <i data-bs-toggle=\"modal\" onclick=\"supprimer_nif( '");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getId());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("','");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getIdentifiant());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("i", "onclick");
					jteOutput.writeUserContent(el.getRaisonSociale());
					jteOutput.setContext("i", null);
					jteOutput.writeContent("')\"\n                                   data-bs-target=\"#nifDeleteModal\" class=\"bi bi-trash text-danger\"></i>\n                            </li>\n                        ");
				}
				jteOutput.writeContent("\n\n                        <li class=\"list-group-item text-center\">\n                            <span class=\"btn btn-success\">\n                               <span href=\"#\" class=\"btn\" data-bs-toggle=\"modal\"\n                                     data-bs-target=\"#nifAddModal\">Ajouter</span>\n                            </span>\n                        </li>\n                    </ul>\n                </div>\n            </div>\n        </div>\n    </div>\n\n    <div class=\"modal fade\" id=\"activiteAddModal\" tabindex=\"-1\"\n         aria-labelledby=\"activiteAddModalLabel\" aria-hidden=\"true\">\n        <div class=\"modal-dialog\">\n            <div class=\"modal-content\">\n                <div class=\"modal-header bg-success\"> Ajout d'une activité au marché</div>\n                <div class=\"card-body\">\n                    <form action=\"/marche/savemarcheActivite\" method=\"post\">\n                        <div class=\"row mb-3\">\n\n                            <input type=\"hidden\" name=\"marcheId\"");
				var __jte_html_attribute_0 = marcheDTO.getId();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n\n                            <div class=\"form-floating mb-3 col-md-6\">\n                                <select class=\"form-select\" name=\"codeActivite\" id=\"codeActivite\">\n                                    <option value=\"\">Veuillez selectionner\n                                    </option>\n                                    ");
				for (var el: dppActiviteList) {
					jteOutput.writeContent("\n                                        <option");
					var __jte_html_attribute_1 = el.getCodeActivite();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                            ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.writeContent("\n                                        </option>\n                                    ");
				}
				jteOutput.writeContent("\n                                </select>\n                                <label for=\"codeActivite\"> Activité  </label>\n                            </div>\n\n                            <div class=\"form-floating mb-3 col-md-6\">\n                                <input type=\"number\" class=\"form-control\" id=\"montant\" name=\"montant\" placeholder=\"Montant\" >\n                                <label for=\"montant\">Montant </label>\n\n\n                            </div>\n\n\n                            <div class=\"form-floating mb-3 col-md-6\">\n                                <input type=\"number\" class=\"form-control\" id=\"taux\" name=\"taux\" placeholder=\"Taux\" >\n                                <label for=\"taux\"> Taux </label>\n\n\n                            </div>\n\n\n\n                            <div>\n                                <button type=\"submit\" class=\"btn btn-primary\">Enregistrer</button>\n                                <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">\n                                    Annuler\n                                </button>\n                            </div>\n\n                        </div>\n                    </form>\n                </div>\n            </div>\n        </div>\n    </div>\n\n    <div class=\"modal fade\" id=\"activiteDeleteModal\" tabindex=\"-1\"\n         aria-labelledby=\"activiteDeleteModalLabel\" aria-hidden=\"true\">\n        <div class=\"modal-dialog\">\n            <div class=\"modal-content\">\n                <div class=\"modal-header bg-danger\"> suppression d'une activité du marché</div>\n                <div class=\"card-body\">\n                    Voulez-vous supprimer l'activité : <span id=\"activiteToDelete\" class=\"fw-bold\">Code_activité à supprimer</span>\n                </div>\n                <div>\n                    <a href=\"#\" id=\"activiteId\" class=\"btn btn-danger\">Supprimer</a>\n                    <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">\n                        Annuler\n                    </button>\n                </div>\n            </div>\n        </div>\n    </div>\n\n    <div class=\"modal fade\" id=\"activiteEditModal\" tabindex=\"-1\" aria-hidden=\"true\">\n        <div class=\"modal-dialog\">\n            <div class=\"modal-content\">\n                <div class=\"modal-header bg-primary text-white\"> Modification de l'activité </div>\n                <div class=\"card-body\">\n\n                    <form action=\"/marche/updatemarcheActivite\" method=\"post\">\n                        <div class=\"row mb-3\">\n\n                            <input type=\"hidden\" name=\"id\" id=\"edit_id\">\n                            <input type=\"hidden\" name=\"marcheId\" id=\"edit_marcheId\">\n\n                            <div class=\"form-floating mb-3 col-md-12\">\n                                <input type=\"text\" class=\"form-control\" id=\"edit_codeActivite\" name=\"codeActivite\" readonly>\n                                <label for=\"edit_codeActivite\"> Code de l'activité </label>\n                            </div>\n\n                            <div class=\"form-floating mb-3 col-md-6\">\n                                <input type=\"number\" class=\"form-control\" id=\"edit_montant\" name=\"montant\" required>\n                                <label for=\"edit_montant\">Montant</label>\n                            </div>\n\n                            <div class=\"form-floating mb-3 col-md-6\">\n                                <input type=\"number\" class=\"form-control\" id=\"edit_taux\" name=\"taux\" required>\n                                <label for=\"edit_taux\">Taux</label>\n                            </div>\n\n                            <div class=\"mt-3\">\n                                <button type=\"submit\" class=\"btn btn-primary\">Enregistrer</button>\n                                <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Annuler</button>\n                            </div>\n                        </div>\n                    </form>\n                </div>\n            </div>\n        </div>\n    </div>\n\n\n\n\n\n\n\n\n    <div class=\"modal fade\" id=\"nifAddModal\" tabindex=\"-1\"\n         aria-labelledby=\"nifAddModalLabel\" aria-hidden=\"true\">\n        <div class=\"modal-dialog\">\n            <div class=\"modal-content\">\n                <div class=\"modal-header bg-success\"> Ajout d'un nif au marché</div>\n                <div class=\"card-body\">\n                    <form action=\"/marche/savemarcheNif\" method=\"post\">\n                        <div class=\"row mb-3\">\n\n                            <input type=\"hidden\" name=\"marcheId\"");
				var __jte_html_attribute_2 = marcheDTO.getId();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n\n                            <div class=\"form-floating mb-3 col-md-6\">\n                                <select class=\"form-select\" name=\"identifiant\" id=\"identifiant\">\n                                    <option value=\"\">Veuillez selectionner\n                                    </option>\n                                    ");
				for (var el: nifList) {
					jteOutput.writeContent("\n                                        <option");
					var __jte_html_attribute_3 = el.getIdentifiant();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_3);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                            ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIdentifiant());
					jteOutput.writeContent(" - ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getRaisonSociale());
					jteOutput.writeContent("\n                                        </option>\n                                    ");
				}
				jteOutput.writeContent("\n                                </select>\n                                <label for=\"identifiant\"> Nif  </label>\n                            </div>\n                            <div>\n                                <button type=\"submit\" class=\"btn btn-primary\">Enregistrer</button>\n                                <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">\n                                    Annuler\n                                </button>\n                            </div>\n\n                        </div>\n                    </form>\n                </div>\n            </div>\n        </div>\n    </div>\n\n    <div class=\"modal fade\" id=\"nifDeleteModal\" tabindex=\"-1\"\n         aria-labelledby=\"nifDeleteModalLabel\" aria-hidden=\"true\">\n        <div class=\"modal-dialog\">\n            <div class=\"modal-content\">\n                <div class=\"modal-header bg-danger\"> suppression d'un nif du marché</div>\n                <div class=\"card-body\">\n                    Voulez-vous supprimer ce nif : <span id=\"nifToDelete\" class=\"fw-bold\">Identifiant à supprimer</span>\n                    </div>\n                <div>\n                    <a href=\"#\" id=\"nifId\" class=\"btn btn-danger\">Supprimer</a>\n                    <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">\n                        Annuler\n                    </button>\n                </div>\n            </div>\n        </div>\n    </div>\n\n    <script>\n        function supprimer_nif(id, identifiant, rs) {\n            const text = identifiant + \" - \" + rs\n           const nifToDelete = document.getElementById(\"nifToDelete\");\n           nifToDelete.innerHTML = text;\n\n            const nifId = document.getElementById(\"nifId\");\n            nifId.setAttribute(\"href\", \"/marche/nif/delete/\" + id);\n\n\n        }\n\n\n\n        function supprimer_activite(id, codeActivite) {\n            const text = codeActivite\n            const activiteToDelete = document.getElementById(\"activiteToDelete\");\n            activiteToDelete.innerHTML = text;\n\n            const activiteId = document.getElementById(\"activiteId\");\n            activiteId.setAttribute(\"href\", \"/marche/activite/delete/\" + id);\n\n\n        }\n\n\n\n        function edit_activite(id, marcheId, codeActivite, montant, taux) {\n            document.getElementById('edit_id').value = id;\n            document.getElementById('edit_marcheId').value = marcheId;\n            document.getElementById('edit_codeActivite').value = codeActivite;\n            document.getElementById('edit_montant').value = montant;\n            document.getElementById('edit_taux').value = taux;\n        }\n\n\n\n\n\n\n\n\n    </script>\n");
			}
		}, messages);
		jteOutput.writeContent("\n\n\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Nifs> nifList = (List<Nifs>)params.get("nifList");
		List<DppdActivite> dppActiviteList = (List<DppdActivite>)params.get("dppActiviteList");
		BindingResult bindingResult = (BindingResult)params.get("bindingResult");
		MarcheDTO marcheDTO = (MarcheDTO)params.get("marcheDTO");
		NifDTO nifDTO = (NifDTO)params.get("nifDTO");
		Map<String, String> messages = (Map<String, String>)params.get("messages");
		List<NifDTO> marcheNifDTOs = (List<NifDTO>)params.get("marcheNifDTOs");
		List<ActiviteDTO> marcheActiviteDTOs = (List<ActiviteDTO>)params.get("marcheActiviteDTOs");
		render(jteOutput, jteHtmlInterceptor, nifList, dppActiviteList, bindingResult, marcheDTO, nifDTO, messages, marcheNifDTOs, marcheActiviteDTOs);
	}
}
