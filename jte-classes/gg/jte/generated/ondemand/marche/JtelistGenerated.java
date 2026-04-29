package gg.jte.generated.ondemand.marche;
import com.advinteck.cegib.dto.MarcheDTO;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtelistGenerated {
	public static final String JTE_NAME = "marche/list.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,7,7,10,10,16,16,16,32,33,35,40,40,42,42,42,45,45,45,45,45,45,45,45,45,46,46,46,50,50,50,50,50,50,50,50,50,51,51,51,53,53,53,55,56,57,58,59,60,64,64,64,67,70,70,70,70,71,71,71,71,72,72,72,72,80,80,116,116,116,117,117,117,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<MarcheDTO> marches, Map<String, String> messages) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Liste des marchés", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n\n    <div class=\"d-flex justify-content-between align-items-center mb-3\">\n        <div>\n\n            <small class=\"text-muted\">");
				jteOutput.setContext("small", null);
				jteOutput.writeUserContent(marches.size());
				jteOutput.writeContent(" éléments trouvés dans la liste</small>\n        </div>\n        <a href=\"/marche/addForm\" class=\"btn btn-success px-4\">\n            <i class=\"bi bi-plus-lg me-1\"></i> Nouveau marché\n        </a>\n    </div>\n\n    <div class=\"card shadow-sm border-0\">\n        <div class=\"card-body p-0\">\n            <table id=\"marches\" class=\"table table-hover align-middle mb-0\">\n                <thead class=\"table-light\">\n                <tr>\n                    <th class=\"ps-3\">Numéro provisoire</th>\n                    <th style=\"width: 20%;\">Objet du marché</th>\n                    <th style=\"width: 20%;\">Type de marché</th>\n                    <th style=\"width: 20%;\">Mode de passation</th>\n                    ");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n                    <th>Date d'approbation</th>\n");
				jteOutput.writeContent("\n                    <th class=\"text-center\">Actions</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
				for (var marche : marches) {
					jteOutput.writeContent("\n                    <tr>\n                     <td class=\" text-nowrap\">");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(marche.getNumMarche());
					jteOutput.writeContent("</td>\n                        <td>\n                            <div class=\"text-truncate\" style=\"max-width: 250px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;\"\n                                ");
					var __jte_html_attribute_0 = marche.getObjetMarche();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" title=\"");
						jteOutput.setContext("div", "title");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("div", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(marche.getObjetMarche());
					jteOutput.writeContent("\n                            </div>\n                        </td>\n                        <td><div class=\"text-truncate\" style=\"max-width: 250px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;\"\n                                ");
					var __jte_html_attribute_1 = marche.getTypeMarcheIntitule();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" title=\"");
						jteOutput.setContext("div", "title");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("div", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(marche.getTypeMarcheIntitule());
					jteOutput.writeContent("\n                            </div></td>\n                        <td><small>");
					jteOutput.setContext("small", null);
					jteOutput.writeUserContent(marche.getModePassationIntitule());
					jteOutput.writeContent("</small></td>\n\n                        ");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n\n                        <td>\n                            <small>\n                                ");
					jteOutput.setContext("small", null);
					jteOutput.writeUserContent(marche.getDateApprobation().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
					jteOutput.writeContent("\n                            </small>\n                        </td>\n");
					jteOutput.writeContent("\n                        <td class=\"text-center pe-3 text-nowrap\">\n                            <div class=\"btn-group\">\n                                <a href=\"/marche/details/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(marche.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\" class=\"btn btn-sm btn-outline-info\">Détails</a>\n                                <a href=\"/marche/edit/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(marche.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\" class=\"btn btn-sm btn-outline-warning\">Modifier</a>\n                                <a href=\"/marche/delete/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(marche.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\" class=\"btn btn-sm btn-danger\">\n                                    Supprimer\n                                </a>\n                            </div>\n\n\n                        </td>\n                    </tr>\n                ");
				}
				jteOutput.writeContent("\n                </tbody>\n            </table>\n        </div>\n    </div>\n\n    <script>\n        document.addEventListener('DOMContentLoaded', function() {\n            new DataTable('#marches', {\n\n                lengthChange: false,\n\n                language: {\n                    processing:     \"Traitement en cours...\",\n                    search:         \"Rechercher&nbsp;:\",\n                    info:           \"Affichage de l'élément _START_ à _END_ sur _TOTAL_ éléments\",\n                    infoEmpty:      \"Affichage de l'élément 0 à 0 sur 0 élément\",\n                    infoFiltered:   \"(filtré de _MAX_ éléments au total)\",\n                    loadingRecords: \"Chargement en cours...\",\n                    zeroRecords:    \"Aucun élément à afficher\",\n                    emptyTable:     \"Aucune donnée disponible dans le tableau\",\n                    paginate: {\n                        first:      \"Premier\",\n                        previous:   \"Précédent\",\n                        next:       \"Suivant\",\n                        last:       \"Dernier\"\n                    }\n                },\n                pageLength: 10,\n                columnDefs: [\n                    { targets: [5], orderable: false }\n                ]\n            });\n        });\n    </script>\n\n");
			}
		}, messages);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<MarcheDTO> marches = (List<MarcheDTO>)params.get("marches");
		Map<String, String> messages = (Map<String, String>)params.get("messages");
		render(jteOutput, jteHtmlInterceptor, marches, messages);
	}
}
