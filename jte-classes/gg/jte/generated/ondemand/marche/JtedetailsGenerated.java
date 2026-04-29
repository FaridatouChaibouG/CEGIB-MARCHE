package gg.jte.generated.ondemand.marche;
import com.advinteck.cegib.dto.ActiviteDTO;
import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.generated.referentiel.tables.pojos.*;
import com.advinteck.cegib.dto.NifDTO;
import java.util.Map;
import java.util.List;
@SuppressWarnings("unchecked")
public final class JtedetailsGenerated {
	public static final String JTE_NAME = "marche/details.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,5,7,7,7,7,14,14,17,17,18,21,27,36,36,36,41,41,41,47,47,47,53,53,53,57,57,57,59,60,61,62,65,65,65,70,70,70,75,75,75,79,79,79,84,85,86,87,96,118,118,121,121,121,122,122,122,124,124,124,127,127,127,131,131,131,136,136,136,136,136,136,136,136,136,136,136,136,136,136,136,136,136,136,136,136,141,141,141,141,141,141,141,141,147,147,154,166,166,169,169,169,170,170,170,173,173,173,173,173,173,173,173,173,173,173,173,177,178,179,180,181,182,183,185,185,192,202,202,202,202,202,202,202,202,202,208,208,209,209,209,209,209,209,209,209,209,209,209,209,210,210,210,211,211,256,256,257,257,257,257,257,257,257,257,257,257,257,257,258,258,258,259,259,312,322,322,322,322,322,322,322,322,322,328,328,329,329,329,329,329,329,329,329,329,329,329,329,329,329,329,330,330,364,364,365,365,365,365,365,365,365,365,365,365,365,365,366,366,366,367,367,457,457,457,461,461,461,7,8,9,10,11,12,12,12,12};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Nifs> nifList, List<DppdActivite> dppActiviteList, MarcheDTO marcheDTO, Map<String, String> messages, List<NifDTO> marcheNifDTOs, List<ActiviteDTO> marcheActiviteDTOs) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Détail du Marché", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				jteOutput.writeContent("\n    <div class=\"d-flex justify-content-between align-items-center mb-4\">\n        <h4 class=\"text-success fw-bold\"><i ></i>   </h4>\n");
				jteOutput.writeContent("\n        <a href=\"/marche/list\" class=\"btn btn-outline-secondary shadow-sm\">\n            <i class=\"bi bi-arrow-left me-1\"></i> Retour à la liste\n        </a>\n    </div>\n\n    ");
				jteOutput.writeContent("\n    <div class=\"card border-0 shadow-sm mb-4\">\n        <div class=\"card-header bg-white py-3\">\n            <h5 class=\"mb-0 text-dark fw-bold\">Informations Générales</h5>\n        </div>\n        <div class=\"card-body\">\n            <div class=\"row g-3\">\n                <div class=\"col-md-3 col-6\">\n                    <small class=\"fw-bold d-block\">ID Interne</small>\n                    <span class=\"small text-dark\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getId());
				jteOutput.writeContent("</span>\n                </div>\n\n                <div class=\"col-md-5\">\n                    <small class=\"fw-bold d-block\">Objet du Marché</small>\n                    <p class=\"mb-0 fw-medium\">");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(marcheDTO.getObjetMarche());
				jteOutput.writeContent("</p>\n                </div>\n\n\n                <div class=\"col-md-3 col-6\">\n                    <small class=\"fw-bold d-block\">Imputation Budgétaire</small>\n                    <span class=\"small\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getImputationIntitule());
				jteOutput.writeContent("</span>\n                </div>\n\n\n                <div class=\"col-md-4\">\n                    <small class=\"fw-bold d-block\">Type de Marché</small>\n                    <span class=\"small\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getTypeMarcheIntitule());
				jteOutput.writeContent("</span>\n                </div>\n                <div class=\"col-md-4\">\n                    <small class=\"fw-bold d-block\">Mode de Passation</small>\n                    <span class=\"small\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getModePassationIntitule());
				jteOutput.writeContent("</span>\n                </div>\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n                <div class=\"col-md-4\">\n                    <small class=\"fw-bold d-block\">Autorité Contractante</small>\n                    <span class=\"small\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getAutoriteContractanteIntitule());
				jteOutput.writeContent("</span>\n                </div>\n\n                <div class=\"col-md-4\">\n                    <small class=\"fw-bold d-block\"> Structure Autorité Contractante</small>\n                    <span class=\"small\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getStructureAutoriteContractanteIntutule());
				jteOutput.writeContent("</span>\n                </div>\n\n                <div class=\"col-md-3 col-6\">\n                    <small class=\"fw-bold d-block\">Date d'approbation</small>\n                    <span class=\"small\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getDateApprobation().toString());
				jteOutput.writeContent("</span>\n                </div>\n                <div class=\"col-md-3 col-6\">\n                    <small class=\"fw-bold d-block\">Approuvé par</small>\n                    <span class=\"badge bg-light text-dark border\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getApprouvePar());
				jteOutput.writeContent("</span>\n                </div>\n\n\n\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n\n\n\n            </div>\n        </div>\n    </div>\n\n    <div class=\"row g-4\">\n        ");
				jteOutput.writeContent("\n        <div class=\"col-lg-8\">\n            <div class=\"card border-0 shadow-sm h-100\">\n                <div class=\"card-header bg-white d-flex justify-content-between align-items-center py-3\">\n                    <h5 class=\"mb-0 fw-bold\">Activités</h5>\n                    <button class=\"btn btn-sm btn-success rounded-pill\" data-bs-toggle=\"modal\"\n                            data-bs-target=\"#activiteAddModal\">\n                        <i class=\"bi bi-plus-lg me-1\"></i> Ajouter\n                    </button>\n                </div>\n                <div class=\"table-responsive\">\n                    <table class=\"table table-hover align-middle mb-0\">\n                        <thead class=\"table-light\">\n                        <tr class=\"small text-uppercase\">\n                            <th class=\"ps-4\">Code / Intitulé</th>\n                            <th class=\"text-center\">Taux (%)</th>\n                            <th class=\"text-end\">Montant HT</th>\n                            <th class=\"text-end\">Montant TTC</th>\n                            <th class=\"text-center\">Actions</th>\n                        </tr>\n                        </thead>\n                        <tbody>\n                        ");
				for (var el : marcheActiviteDTOs) {
					jteOutput.writeContent("\n                            <tr>\n                                <td class=\"ps-4\">\n                                    <div class=\"fw-bold text-dark\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.writeContent("</div>\n                                    <div class=\"small text-muted\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(el.getIntituleActivite());
					jteOutput.writeContent("</div>\n                                </td>\n                                <td class=\"text-center\"><span class=\"badge bg-light text-dark\">");
					jteOutput.setContext("span", null);
					jteOutput.writeUserContent(el.getTaux());
					jteOutput.writeContent("</span>\n                                </td>\n                                <td class=\"text-end fw-medium\">\n                                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(String.format(java.util.Locale.FRANCE, "%,d", el.getMontant()));
					jteOutput.writeContent("\n                                </td>\n\n                                <td class=\"text-end fw-bold text-success\">\n                                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(String.format(java.util.Locale.FRANCE, "%,d", el.getMontant() * (100 + el.getTaux()) / 100));
					jteOutput.writeContent("\n                                </td>\n\n                                <td class=\"text-center\">\n                                    <button class=\"btn btn-sm btn-outline-primary border-0\"\n                                            onclick=\"edit_activite('");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getId());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getMarcheId());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getMontant());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getTaux());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("')\"\n                                            data-bs-toggle=\"modal\" data-bs-target=\"#activiteEditModal\">\n                                        <i class=\"bi bi-pencil\"></i>\n                                    </button>\n                                    <button class=\"btn btn-sm btn-outline-danger border-0\"\n                                            onclick=\"supprimer_activite('");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getId());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("','");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("')\"\n                                            data-bs-toggle=\"modal\" data-bs-target=\"#activiteDeleteModal\">\n                                        <i class=\"bi bi-trash\"></i>\n                                    </button>\n                                </td>\n                            </tr>\n                        ");
				}
				jteOutput.writeContent("\n                        </tbody>\n                    </table>\n                </div>\n            </div>\n        </div>\n\n        ");
				jteOutput.writeContent("\n        <div class=\"col-lg-4\">\n            <div class=\"card border-0 shadow-sm h-100\">\n                <div class=\"card-header bg-white d-flex justify-content-between align-items-center py-3\">\n                    <h5 class=\"mb-0 fw-bold\">NIF Associés</h5>\n                    <button class=\"btn btn-sm btn-success rounded-pill\" data-bs-toggle=\"modal\"\n                            data-bs-target=\"#nifAddModal\">\n                        <i class=\"bi bi-plus-lg me-1\"></i> Ajouter\n                    </button>\n                </div>\n                <div class=\"card-body p-0\">\n                    <div class=\"list-group list-group-flush\">\n                        ");
				for (var el : marcheNifDTOs) {
					jteOutput.writeContent("\n                            <div class=\"list-group-item py-3 d-flex justify-content-between align-items-center\">\n                                <div>\n                                    <div class=\"fw-bold text-dark\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(el.getIdentifiant());
					jteOutput.writeContent("</div>\n                                    <div class=\"small text-muted\">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(el.getRaisonSociale());
					jteOutput.writeContent("</div>\n                                </div>\n                                <button class=\"btn btn-link text-danger p-0\"\n                                        onclick=\"supprimer_nif('");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getId());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("','");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getIdentifiant());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("', '");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(el.getRaisonSociale());
					jteOutput.setContext("button", null);
					jteOutput.writeContent("')\"\n                                        data-bs-toggle=\"modal\" data-bs-target=\"#nifDeleteModal\">\n                                    <i class=\"bi bi-trash text-danger\"></i>\n                                </button>\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n                            </div>\n                        ");
				}
				jteOutput.writeContent("\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n\n    ");
				jteOutput.writeContent("\n    <div class=\"modal fade\" id=\"activiteAddModal\" tabindex=\"-1\">\n        <div class=\"modal-dialog modal-dialog-centered\">\n            <div class=\"modal-content border-0 shadow\">\n                <div class=\"modal-header bg-success text-white\">\n                    <h5 class=\"modal-title\">Nouvelle Activité</h5>\n                    <button type=\"button\" class=\"btn-close btn-close-white\" data-bs-dismiss=\"modal\"></button>\n                </div>\n                <form action=\"/marche/savemarcheActivite\" method=\"post\">\n                    <div class=\"modal-body p-4\">\n                        <input type=\"hidden\" name=\"marcheId\"");
				var __jte_html_attribute_0 = marcheDTO.getId();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n\n                        <div class=\"mb-3\">\n                            <label class=\"form-label fw-bold small\">Sélectionner l'Activité</label>\n                            <select class=\"form-select border-success-subtle\" name=\"codeActivite\" id=\"selectActivite\" required>\n                                <option value=\"\">Choisir...</option>\n                                ");
				for (var el: dppActiviteList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_1 = el.getCodeActivite();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.writeContent("\n                                        - ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntituleActivite());
					jteOutput.writeContent("</option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                        </div>\n\n                        <div class=\"row\">\n                            <div class=\"col-md-6 mb-3\">\n                                <label class=\"form-label fw-bold small\">Montant HT</label>\n                                <div class=\"input-group\">\n                                    <input type=\"number\" class=\"form-control border-success-subtle\" name=\"montant\"\n                                           required>\n                                    <span class=\"input-group-text\">CFA</span>\n                                </div>\n                            </div>\n                            <div class=\"col-md-6 mb-3\">\n                                <label class=\"form-label fw-bold small\">Taux (%)</label>\n                                <input type=\"number\" class=\"form-control border-success-subtle\" name=\"taux\" value=\"\"\n                                       required>\n                            </div>\n                        </div>\n                    </div>\n                    <div class=\"modal-footer bg-light border-0\">\n                        <button type=\"button\" class=\"btn btn-secondary px-4\" data-bs-dismiss=\"modal\">Annuler</button>\n                        <button type=\"submit\" class=\"btn btn-success px-4\">Enregistrer</button>\n                    </div>\n                </form>\n            </div>\n        </div>\n    </div>\n\n    <div class=\"modal fade\" id=\"activiteEditModal\" tabindex=\"-1\">\n        <div class=\"modal-dialog modal-dialog-centered\">\n            <div class=\"modal-content border-0 shadow\">\n                <div class=\"modal-header bg-success text-white\">\n                    <h5 class=\"modal-title\">Modifier Activité</h5>\n                    <button type=\"button\" class=\"btn-close btn-close-white\" data-bs-dismiss=\"modal\"></button>\n                </div>\n                <form action=\"/marche/updatemarcheActivite\" method=\"post\">\n                    <div class=\"modal-body p-4\">\n                        <input type=\"hidden\" id=\"edit_marcheId\" name=\"marcheId\">\n                        <input type=\"hidden\" id=\"edit_id\" name=\"id\">\n\n                        <div class=\"mb-3\">\n                            <label class=\"form-label fw-bold small\">Sélectionner l'Activité</label>\n                            <select class=\"form-select border-success-subtle\" name=\"codeActivite\" id=\"edit_codeActivite\" required readonly>\n                                <option value=\"\">Choisir...</option>\n                                ");
				for (var el: dppActiviteList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_2 = el.getCodeActivite();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_2);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.writeContent("\n                                        - ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntituleActivite());
					jteOutput.writeContent("</option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                        </div>\n\n                        <div class=\"row\">\n                            <div class=\"col-md-6 mb-3\">\n                                <label class=\"form-label fw-bold small\">Montant HT</label>\n                                <div class=\"input-group\">\n                                    <input type=\"number\" class=\"form-control border-success-subtle\" name=\"montant\" id=\"edit_montant\"\n                                           required>\n                                    <span class=\"input-group-text\">CFA</span>\n                                </div>\n                            </div>\n                            <div class=\"col-md-6 mb-3\">\n                                <label class=\"form-label fw-bold small\">Taux (%)</label>\n                                <input type=\"number\" class=\"form-control border-success-subtle\" name=\"taux\" id=\"edit_taux\"\n                                       required>\n                            </div>\n                        </div>\n                    </div>\n                    <div class=\"modal-footer bg-light border-0\">\n                        <button type=\"button\" class=\"btn btn-secondary px-4\" data-bs-dismiss=\"modal\">Annuler</button>\n                        <button type=\"submit\" class=\"btn btn-success px-4\">Enregistrer</button>\n                    </div>\n                </form>\n            </div>\n        </div>\n    </div>\n\n    <div class=\"modal fade\" id=\"activiteDeleteModal\" tabindex=\"-1\" aria-hidden=\"true\">\n        <div class=\"modal-dialog modal-dialog-centered\">\n            <div class=\"modal-content border-0 shadow-lg\">\n                <div class=\"modal-body p-4 text-center\">\n                    <div class=\"mb-3\">\n                        <i class=\"bi bi-x-circle text-danger\" style=\"font-size: 3.5rem;\"></i>\n                    </div>\n\n                    <h5 class=\"fw-bold text-dark\">Supprimer l'activité  : <span id=\"activiteToDelete\"></span> ?</h5>\n                    <p class=\"text-muted small\" id=\"deleteActiviteMsg\">\n                        Cette action est irréversible.\n                    </p>\n\n                    <div class=\"d-grid gap-2 d-md-flex justify-content-center mt-4\">\n                        <button type=\"button\" class=\"btn btn-light px-4 border\" data-bs-dismiss=\"modal\">Annuler</button>\n                        <a id=\"btn-confirm-delete-activite\" href=\"#\" class=\"btn btn-danger px-4 shadow-sm\">\n                            Confirmer\n                        </a>\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n\n    ");
				jteOutput.writeContent("\n    <div class=\"modal fade\" id=\"nifAddModal\" tabindex=\"-1\" aria-hidden=\"true\">\n        <div class=\"modal-dialog modal-dialog-centered\">\n            <div class=\"modal-content border-0 shadow\">\n                <div class=\"modal-header bg-success text-white\">\n                    <h5 class=\"modal-title\"><i class=\"bi bi-person-plus me-2\"></i>Associer un NIF</h5>\n                    <button type=\"button\" class=\"btn-close btn-close-white\" data-bs-dismiss=\"modal\"></button>\n                </div>\n                <form action=\"/marche/savemarcheNif\" method=\"post\">\n                    <div class=\"modal-body p-4\">\n                        <input type=\"hidden\" name=\"marcheId\"");
				var __jte_html_attribute_3 = marcheDTO.getId();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n\n                        <div class=\"mb-3\">\n                            <label class=\"form-label fw-bold small text-uppercase\">Sélectionner l'Identifiant Fiscal (NIF)</label>\n                            <select class=\"form-select border-success-subtle\" name=\"identifiant\" id=\"selectNif\" required>\n                                <option value=\"\">Rechercher un NIF...</option>\n                                ");
				for (var el : nifList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_4 = el.getIdentifiant();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_4);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIdentifiant());
					jteOutput.writeContent(" - ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getRaisonSociale());
					jteOutput.writeContent("</option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                        </div>\n                    </div>\n                    <div class=\"modal-footer bg-light border-0\">\n                        <button type=\"button\" class=\"btn btn-secondary px-4\" data-bs-dismiss=\"modal\">Annuler</button>\n                        <button type=\"submit\" class=\"btn btn-success px-4\">\n                            <i class=\"bi bi-check-circle me-1\"></i> Valider l'association\n                        </button>\n                    </div>\n                </form>\n            </div>\n        </div>\n    </div>\n\n\n\n\n    <div class=\"modal fade\" id=\"nifEditModal\" tabindex=\"-1\">\n        <div class=\"modal-dialog modal-dialog-centered\">\n            <div class=\"modal-content border-0 shadow\">\n                <div class=\"modal-header bg-success text-white\">\n                    <h5 class=\"modal-title\">Modifier Nif</h5>\n                    <button type=\"button\" class=\"btn-close btn-close-white\" data-bs-dismiss=\"modal\"></button>\n                </div>\n                <form action=\"/marche/updatemarcheNif\" method=\"post\">\n                    <div class=\"modal-body p-4\">\n                        <input type=\"hidden\" id=\"edit_marcheId\" name=\"marcheId\">\n                        <input type=\"hidden\" id=\"edit_id\" name=\"id\">\n\n                        <div class=\"mb-3\">\n                            <label class=\"form-label fw-bold small\">Sélectionner le nif</label>\n                            <select class=\"form-select border-success-subtle\" name=\"codeActivite\" id=\"edit_identifiant\" >\n                                <option value=\"\">Choisir...</option>\n                                ");
				for (var el: nifList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_5 = el.getIdentifiant();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_5);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIdentifiant());
					jteOutput.writeContent("\n                                        - ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getRaisonSociale());
					jteOutput.writeContent("</option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                        </div>\n\n                        <div class=\"modal-footer bg-light border-0\">\n                            <button type=\"button\" class=\"btn btn-secondary px-4\" data-bs-dismiss=\"modal\">Annuler</button>\n                            <button type=\"submit\" class=\"btn btn-success px-4\">Enregistrer</button>\n                        </div>\n\n                    </div>\n                </form>\n            </div>\n        </div>\n    </div>\n\n\n\n\n\n    <div class=\"modal fade\" id=\"nifDeleteModal\" tabindex=\"-1\" aria-hidden=\"true\">\n        <div class=\"modal-dialog modal-dialog-centered\">\n            <div class=\"modal-content border-0 shadow\">\n                <div class=\"modal-body p-4 text-center\">\n                    <i class=\"bi bi-exclamation-triangle text-danger\" style=\"font-size: 3rem;\"></i>\n                    <h5 class=\"mt-3 fw-bold\">Confirmation</h5>\n                    <p class=\"text-muted\" id=\"deleteMsgNif\">Voulez-vous détacher ce NIF :<span id=\"nifToDelete\"></span> ?</p>\n                    <div class=\"d-flex gap-2 justify-content-center mt-4\">\n                        <button type=\"button\" class=\"btn btn-light px-4\" data-bs-dismiss=\"modal\">Non</button>\n                        <a id=\"btn-confirm-delete-nif\" href=\"#\" class=\"btn btn-danger px-4\">Oui, Supprimer</a>\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n\n    <script>\n        function supprimer_nif(id, identifiant, rs) {\n            const text = identifiant + \" - \" + rs\n            const c = document.getElementById(\"nifToDelete\");\n            nifToDelete.innerHTML = text;\n\n            const nifId = document.getElementById(\"btn-confirm-delete-nif\");\n            nifId.setAttribute(\"href\", \"/marche/nif/delete/\" + id);\n\n\n        }\n\n        function edit_nif(id, identifiant) {\n            document.getElementById('edit_id').value = id;\n            document.getElementById('edit_identifiant').value = identifiant;\n\n        }\n\n\n\n        function supprimer_activite(id, codeActivite) {\n            const text = codeActivite\n            const activiteToDelete = document.getElementById(\"activiteToDelete\");\n            activiteToDelete.innerHTML = text;\n\n            const activiteId = document.getElementById(\"btn-confirm-delete-activite\");\n            activiteId.setAttribute(\"href\", \"/marche/activite/delete/\" + id);\n\n\n        }\n\n\n        function edit_activite(id, marcheId, codeActivite, montant, taux) {\n            document.getElementById('edit_id').value = id;\n            document.getElementById('edit_marcheId').value = marcheId;\n            document.getElementById('edit_codeActivite').value = codeActivite;\n            document.getElementById('edit_montant').value = montant;\n            document.getElementById('edit_taux').value = taux;\n        }\n\n        new SlimSelect({\n            select: '#selectActivite',\n            placeholder: 'Rechercher une activité...'\n        });\n\n\n        new SlimSelect({\n            select: '#selectNif',\n            placeholder: 'Rechercher un NIF...'\n        });\n\n\n\n\n    </script>\n");
			}
		}, messages);
		jteOutput.writeContent("\n\n\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Nifs> nifList = (List<Nifs>)params.get("nifList");
		List<DppdActivite> dppActiviteList = (List<DppdActivite>)params.get("dppActiviteList");
		MarcheDTO marcheDTO = (MarcheDTO)params.get("marcheDTO");
		Map<String, String> messages = (Map<String, String>)params.get("messages");
		List<NifDTO> marcheNifDTOs = (List<NifDTO>)params.get("marcheNifDTOs");
		List<ActiviteDTO> marcheActiviteDTOs = (List<ActiviteDTO>)params.get("marcheActiviteDTOs");
		render(jteOutput, jteHtmlInterceptor, nifList, dppActiviteList, marcheDTO, messages, marcheNifDTOs, marcheActiviteDTOs);
	}
}
