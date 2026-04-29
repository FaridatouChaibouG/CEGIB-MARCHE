package gg.jte.generated.ondemand.marche;
import com.advinteck.cegib.dto.MarcheDTO;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtelistGenerated {
	public static final String JTE_NAME = "marche/list.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,7,7,10,10,16,16,16,28,32,33,35,40,40,42,43,43,43,43,43,43,43,43,43,43,43,43,44,44,44,45,45,45,47,48,49,50,51,52,54,54,54,55,58,58,58,58,59,59,59,59,60,60,60,60,68,68,77,97,103,103,103,104,104,104,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<MarcheDTO> marches, Map<String, String> messages) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Liste des marchés", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n\n    <div class=\"d-flex justify-content-between align-items-center mb-3\">\n        <div>\n\n            <small class=\"text-muted\">");
				jteOutput.setContext("small", null);
				jteOutput.writeUserContent(marches.size());
				jteOutput.writeContent(" éléments trouvés dans la liste</small>\n        </div>\n        <a href=\"/marche/addForm\" class=\"btn btn-success px-4\">\n            <i class=\"bi bi-plus-lg me-1\"></i> Nouveau marché\n        </a>\n    </div>\n\n    <div class=\"card shadow-sm border-0\">\n        <div class=\"card-body p-0\">\n            <table id=\"marches\" class=\"table table-hover align-middle mb-0\">\n                <thead class=\"table-light\">\n                <tr>\n");
				jteOutput.writeContent("\n                    <th >Objet</th>\n                    <th>Type</th>\n                    <th>Passation</th>\n                    ");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n                    <th>Approbation</th>\n");
				jteOutput.writeContent("\n                    <th class=\"text-center\">Actions</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
				for (var marche : marches) {
					jteOutput.writeContent("\n                    <tr>\n");
					jteOutput.writeContent("\n                        <td><div class=\"text-truncate\" style=\"max-width: 180px;\"");
					var __jte_html_attribute_0 = marche.getObjetMarche();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" title=\"");
						jteOutput.setContext("div", "title");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("div", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(marche.getObjetMarche());
					jteOutput.writeContent("</div></td>\n                        <td><span class=\"badge bg-secondary-soft text-dark border\">");
					jteOutput.setContext("span", null);
					jteOutput.writeUserContent(marche.getTypeMarcheIntitule());
					jteOutput.writeContent("</span></td>\n                        <td><small>");
					jteOutput.setContext("small", null);
					jteOutput.writeUserContent(marche.getModePassationIntitule());
					jteOutput.writeContent("</small></td>\n\n                        ");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n");
					jteOutput.writeContent("\n\n                      <td><small>");
					jteOutput.setContext("small", null);
					jteOutput.writeUserContent(marche.getDateApprobation().toString());
					jteOutput.writeContent("</small></td>\n");
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
				jteOutput.writeContent("\n                </tbody>\n            </table>\n        </div>\n    </div>\n\n    <script>\n        document.addEventListener('DOMContentLoaded', function() {\n            new DataTable('#marches', {\n                ");
				jteOutput.writeContent("\n                language: {\n                    processing:     \"Traitement en cours...\",\n                    search:         \"Rechercher&nbsp;:\",\n                    lengthMenu:    \"Afficher _MENU_ éléments\",\n                    info:           \"Affichage de l'élément _START_ à _END_ sur _TOTAL_ éléments\",\n                    infoEmpty:      \"Affichage de l'élément 0 à 0 sur 0 élément\",\n                    infoFiltered:   \"(filtré de _MAX_ éléments au total)\",\n                    loadingRecords: \"Chargement en cours...\",\n                    zeroRecords:    \"Aucun élément à afficher\",\n                    emptyTable:     \"Aucune donnée disponible dans le tableau\",\n                    paginate: {\n                        first:      \"Premier\",\n                        previous:   \"Précédent\",\n                        next:       \"Suivant\",\n                        last:       \"Dernier\"\n                    }\n                },\n                pageLength: 10,\n                columnDefs: [\n                    { targets: [4], orderable: false } ");
				jteOutput.writeContent("\n                ]\n            });\n        });\n    </script>\n\n");
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
