package gg.jte.generated.ondemand.marche;
import com.advinteck.cegib.dto.ActiviteDTO;
import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.dto.NifDTO;
import java.util.Map;
import java.util.List;
@SuppressWarnings("unchecked")
public final class JtedeleteGenerated {
	public static final String JTE_NAME = "marche/delete.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,6,11,11,14,14,18,21,22,23,24,25,27,29,30,30,30,30,37,38,39,42,42,42,42,54,54,54,54,67,87,87,87,97,97,97,107,107,107,115,115,115,123,123,123,133,133,133,143,143,143,154,154,154,165,165,165,175,175,175,185,222,222,228,228,228,232,232,232,238,238,238,243,243,243,247,247,247,252,252,264,279,279,284,284,284,288,288,288,293,293,305,305,305,305,305,6,7,8,9,9,9,9};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MarcheDTO marcheDTO, Map<String, String> messages, List<NifDTO> marcheNifDTOs, List<ActiviteDTO> marcheActiviteDTOs) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Suppression Marché", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n\n\n    ");
				jteOutput.writeContent("\n    <div class=\"d-flex justify-content-between align-items-center mb-4\">\n        <h4 class=\"text-danger fw-bold\">\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n\n");
				jteOutput.writeContent("\n\n            ");
				jteOutput.writeContent("\n            <div class=\"modal fade\" id=\"del");
				jteOutput.setContext("div", "id");
				jteOutput.writeUserContent(marcheDTO.getId());
				jteOutput.setContext("div", null);
				jteOutput.writeContent("\" tabindex=\"-1\" aria-hidden=\"true\">\n                <div class=\"modal-dialog modal-dialog-centered text-start\">\n                    <div class=\"modal-content\">\n                        <div class=\"modal-header\">\n                            <h5 class=\"modal-title text-dark fs-6\"  >Souhaitez-vous supprimer ce marché ?</h5>\n                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"></button>\n                        </div>\n                        ");
				jteOutput.writeContent("\n                        ");
				jteOutput.writeContent("\n                        ");
				jteOutput.writeContent("\n                        <div class=\"modal-footer\">\n                            <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">Non</button>\n                            <a href=\"/marche/delete/Delete/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(marcheDTO.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\" class=\"btn btn-outline-danger shadow-sm\">\n                                <i class=\"bi bi-arrow me-1\"></i> Oui\n\n                            </a>\n                        </div>\n                    </div>\n                </div>\n            </div>\n        </h4>\n\n        <div class=\"d-flex gap-2\">\n\n            <a type=\"button\" class=\"btn btn-outline-danger shadow-sm\" data-bs-toggle=\"modal\" data-bs-target=\"#del");
				jteOutput.setContext("a", "data-bs-target");
				jteOutput.writeUserContent(marcheDTO.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">\n                <i class=\"bi  me-1\"></i>Supprimer\n            </a>\n\n            <a href=\"/marche/list\" class=\"btn btn-outline-secondary shadow-sm\">\n                <i class=\"bi bi-arrow-left me-1\"></i>Retour à la liste\n            </a>\n\n        </div>\n    </div>\n\n\n\n    ");
				jteOutput.writeContent("\n    <div class=\"card border-0 shadow-sm mb-4\">\n        <div class=\"card-header bg-white py-3\">\n            <h5 class=\"mb-0 text-dark fw-bold\">\n                Informations Générales\n            </h5>\n        </div>\n\n        <div class=\"card-body\">\n            <div class=\"row g-3\">\n\n\n\n\n                <div class=\"col-md-6\">\n                    <small class=\"fw-bold d-block\">\n                        Num de marché provisoire\n                    </small>\n\n                    <p class=\"mb-0 fw-medium\">\n                        ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(marcheDTO.getNumMarche());
				jteOutput.writeContent("\n                    </p>\n                </div>\n\n                <div class=\"col-md-6\">\n                    <small class=\"fw-bold d-block\">\n                        Objet du Marché\n                    </small>\n\n                    <p class=\"mb-0 fw-medium\">\n                        ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(marcheDTO.getObjetMarche());
				jteOutput.writeContent("\n                    </p>\n                </div>\n\n                <div class=\"col-md-6\">\n                    <small class=\"fw-bold d-block\">\n                        Imputation Budgétaire\n                    </small>\n\n                    <span class=\"small\">\n                        ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getImputationIntitule());
				jteOutput.writeContent("\n                    </span>\n                </div>\n\n                <div class=\"col-md-6\">\n                    <small class=\"fw-bold d-block\">Type de marché</small>\n\n                    <span class=\"small\">\n                        ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getTypeMarcheIntitule());
				jteOutput.writeContent("\n                    </span>\n                </div>\n\n                <div class=\"col-md-6\">\n                    <small class=\"fw-bold d-block\">Mode de passation</small>\n\n                    <span class=\"small\">\n                        ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getModePassationIntitule());
				jteOutput.writeContent("\n                    </span>\n                </div>\n\n                <div class=\"col-md-6\">\n                    <small class=\"fw-bold d-block\">\n                        Autorité Contractante\n                    </small>\n\n                    <span class=\"small\">\n                        ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getAutoriteContractanteIntitule());
				jteOutput.writeContent("\n                    </span>\n                </div>\n\n                <div class=\"col-md-6\">\n                    <small class=\"fw-bold d-block\">\n                        Structure Autorité Contractante\n                    </small>\n\n                    <span class=\"small\">\n                        ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getStructureAutoriteContractanteIntutule());
				jteOutput.writeContent("\n                    </span>\n                </div>\n\n                <div class=\"col-md-6\">\n                    <small class=\"fw-bold d-block\">\n                        Date d'approbation\n                    </small>\n\n                    <td>\n                        <small>\n                            ");
				jteOutput.setContext("small", null);
				jteOutput.writeUserContent(marcheDTO.getDateApprobation().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				jteOutput.writeContent("\n                        </small>\n                    </td>\n                </div>\n\n                <div class=\"col-md-6 \">\n                    <small class=\"fw-bold d-block\">\n                        Approuvé par\n                    </small>\n\n                    <span class=\"small\">\n                        ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getApprouvePar());
				jteOutput.writeContent("\n                    </span>\n                </div>\n\n                <div class=\"col-md-6 \">\n                    <small class=\"fw-bold d-block\">\n                        Titulaire du marché\n                    </small>\n\n                    <span class=\"small\">\n                        ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(marcheDTO.getTitulaireMarche());
				jteOutput.writeContent("\n                    </span>\n                </div>\n\n            </div>\n        </div>\n    </div>\n\n    <div class=\"row g-4\">\n\n        ");
				jteOutput.writeContent("\n        <div class=\"col-lg-8\">\n\n            <div class=\"card border-0 shadow-sm h-100\">\n\n                <div class=\"card-header bg-white py-3\">\n                    <h5 class=\"mb-0 fw-bold\">\n                        Activités Associées\n                    </h5>\n                </div>\n\n                <div class=\"table-responsive\">\n\n                    <table class=\"table table-hover align-middle mb-0\">\n\n                        <thead class=\"table-light\">\n                        <tr class=\"small text-uppercase\">\n                            <th class=\"ps-4\">\n                                Code / Intitulé\n                            </th>\n\n                            <th class=\"text-center\">\n                                Taux (%)\n                            </th>\n\n                            <th class=\"text-end\">\n                                Montant HT\n                            </th>\n\n                            <th class=\"text-end\">\n                                Montant TTC\n                            </th>\n                        </tr>\n                        </thead>\n\n                        <tbody>\n\n                        ");
				for (var el : marcheActiviteDTOs) {
					jteOutput.writeContent("\n\n                            <tr>\n\n                                <td class=\"ps-4\">\n                                    <div class=\"fw-bold text-dark\">\n                                        ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(el.getCodeActivite());
					jteOutput.writeContent("\n                                    </div>\n\n                                    <div class=\"small text-muted\">\n                                        ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(el.getIntituleActivite());
					jteOutput.writeContent("\n                                    </div>\n                                </td>\n\n                                <td class=\"text-center\">\n                                    <span class=\"badge bg-light text-dark\">\n                                        ");
					jteOutput.setContext("span", null);
					jteOutput.writeUserContent(el.getTaux());
					jteOutput.writeContent("\n                                    </span>\n                                </td>\n\n                                <td class=\"text-end fw-medium\">\n                                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(String.format(java.util.Locale.FRANCE, "%,d", el.getMontant()));
					jteOutput.writeContent("\n                                </td>\n\n                                <td class=\"text-end fw-bold text-success\">\n                                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(String.format(java.util.Locale.FRANCE, "%,d", el.getMontant() * (100 + el.getTaux()) / 100));
					jteOutput.writeContent("\n                                </td>\n\n                            </tr>\n\n                        ");
				}
				jteOutput.writeContent("\n\n                        </tbody>\n\n                    </table>\n\n                </div>\n\n            </div>\n\n        </div>\n\n        ");
				jteOutput.writeContent("\n        <div class=\"col-lg-4\">\n\n            <div class=\"card border-0 shadow-sm h-100\">\n\n                <div class=\"card-header bg-white py-3\">\n                    <h5 class=\"mb-0 fw-bold\">\n                        NIF Associés\n                    </h5>\n                </div>\n\n                <div class=\"card-body p-0\">\n\n                    <div class=\"list-group list-group-flush\">\n\n                        ");
				for (var el : marcheNifDTOs) {
					jteOutput.writeContent("\n\n                            <div class=\"list-group-item py-3\">\n\n                                <div class=\"fw-bold text-dark\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(el.getIdentifiant());
					jteOutput.writeContent("\n                                </div>\n\n                                <div class=\"small text-muted\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(el.getRaisonSocial());
					jteOutput.writeContent("\n                                </div>\n\n                            </div>\n\n                        ");
				}
				jteOutput.writeContent("\n\n                    </div>\n\n                </div>\n\n            </div>\n\n        </div>\n\n    </div>\n\n");
			}
		}, messages);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MarcheDTO marcheDTO = (MarcheDTO)params.get("marcheDTO");
		Map<String, String> messages = (Map<String, String>)params.get("messages");
		List<NifDTO> marcheNifDTOs = (List<NifDTO>)params.get("marcheNifDTOs");
		List<ActiviteDTO> marcheActiviteDTOs = (List<ActiviteDTO>)params.get("marcheActiviteDTOs");
		render(jteOutput, jteHtmlInterceptor, marcheDTO, messages, marcheNifDTOs, marcheActiviteDTOs);
	}
}
