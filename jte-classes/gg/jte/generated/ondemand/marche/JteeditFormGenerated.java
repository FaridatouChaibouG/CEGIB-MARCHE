package gg.jte.generated.ondemand.marche;
import com.advinteck.cegib.dto.MarcheDTO;
import com.advinteck.cegib.generated.referentiel.tables.pojos.*;
import org.springframework.validation.BindingResult;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JteeditFormGenerated {
	public static final String JTE_NAME = "marche/editForm.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,6,15,15,18,18,34,34,34,34,34,34,34,34,34,36,42,42,42,42,42,42,42,42,42,44,44,53,53,53,53,53,53,53,53,53,55,55,62,62,62,62,62,62,62,62,62,64,64,71,71,71,71,71,71,71,71,71,73,73,78,86,86,87,87,87,87,87,87,87,87,87,87,87,87,87,88,88,88,88,88,88,90,90,93,93,101,101,102,102,102,102,102,102,102,102,102,102,102,102,102,103,103,103,105,105,108,108,116,116,117,117,117,117,117,117,117,117,117,117,117,117,117,118,118,118,120,120,123,123,131,131,132,132,132,132,132,132,132,132,132,132,132,132,132,133,133,133,135,135,138,138,146,146,147,147,147,147,147,147,147,147,147,147,147,147,147,148,148,148,150,150,153,153,160,160,160,160,160,160,160,160,160,162,162,181,193,193,193,194,194,194,6,7,8,9,10,11,12,13,13,13,13};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BindingResult bindingResult, MarcheDTO marcheDTO, Map<String, String> messages, List<Imputation> imputationList, List<AutoriteContractante> autoriteContractanteList, List<AutoriteContractanteStructures> autoriteContractanteStructuresList, List<TypesMarche> typesMarcheList, List<ModesPassation> modesPassationList) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Modification du Marché", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"d-flex justify-content-between align-items-center mb-4\">\n        <h4 class=\"text-success fw-bold\">\n            <i class=\"bi bi-pencil-square me-2\"></i> Modification du Marché\n        </h4>\n        <a href=\"/marche/list\" class=\"btn btn-outline-secondary shadow-sm\">\n            <i class=\"bi bi-arrow-left me-1\"></i> Retour à la liste\n        </a>\n    </div>\n\n    <div class=\"card border-0 shadow-sm\">\n        <div class=\"card-header bg-white py-3 border-bottom\">\n            <h5 class=\"mb-0 text-dark fw-bold\">Détails du Formulaire</h5>\n        </div>\n        <div class=\"card-body p-4\">\n            <form action=\"/marche/update\" method=\"post\">\n                <input type=\"hidden\" name=\"id\"");
				var __jte_html_attribute_0 = marcheDTO.getId();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n\n                ");
				jteOutput.writeContent("\n\n                <div class=\"row g-3 mb-4\">\n                    <div class=\"col-md-12\">\n                        <div class=\"form-floating mb-3\">\n                            <input type=\"text\" class=\"form-control border-success-subtle\" id=\"numMarche\" name=\"numMarche\"\n                                   placeholder=\"Num de marché provisoire\"");
				var __jte_html_attribute_1 = marcheDTO.getNumMarche();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_1);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" readonly>\n                            <label for=\"numMarche\"><i class=\"bi  me-2\"></i>Num de marché provisoire</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "numMarche");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n                </div>\n\n                <div class=\"row g-3 mb-4\">\n                    <div class=\"col-md-12\">\n                        <div class=\"form-floating mb-3\">\n                            <input type=\"text\" class=\"form-control border-success-subtle\" id=\"objetMarche\" name=\"objetMarche\"\n                                   placeholder=\"Objet\"");
				var __jte_html_attribute_2 = marcheDTO.getObjetMarche();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_2);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n                            <label for=\"objetMarche\"><i class=\"bi bi-info-circle me-2\"></i>Objet du Marché</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "objetMarche");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n\n                    <div class=\"col-md-6\">\n                        <div class=\"form-floating mb-3\">\n                            <input type=\"text\" class=\"form-control\" id=\"approuvePar\" name=\"approuvePar\"\n                                   placeholder=\"Approuvé par\"");
				var __jte_html_attribute_3 = marcheDTO.getApprouvePar();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_3);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n                            <label for=\"approuvePar\"><i class=\"bi bi-person-check me-2\"></i>Approuvé Par</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "approuvePar");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n\n                    <div class=\"col-md-6\">\n                        <div class=\"form-floating mb-3\">\n                            <input type=\"date\" class=\"form-control\" id=\"dateApprobation\" name=\"dateApprobation\"\n                                  ");
				var __jte_html_attribute_4 = marcheDTO.getDateApprobation() != null ? marcheDTO.getDateApprobation().toString() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_4);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n                            <label for=\"dateApprobation\"><i class=\"bi bi-calendar-event me-2\"></i>Date Approbation</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "dateApprobation");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n                </div>\n\n                ");
				jteOutput.writeContent("\n                <h6 class=\"text-success text-uppercase small fw-bold mb-3 border-bottom pb-2\">Configuration & Codes</h6>\n\n                <div class=\"row g-3\">\n                    <div class=\"col-md-6\">\n                        <div class=\"form-floating mb-3\">\n                            <select class=\"form-select\" name=\"imputation\" id=\"imputation\">\n                                <option value=\"\">Choisir une imputation...</option>\n                                ");
				for (var el: imputationList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_5 = el.getImputation().equals(marcheDTO.getImputation());
					if (__jte_html_attribute_5) {
					jteOutput.writeContent(" selected");
					}
					var __jte_html_attribute_6 = el.getImputation();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_6)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_6);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getImputation());
					jteOutput.writeContent(" - ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n                                    </option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                            <label for=\"imputation\">Imputation Budgétaire</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "imputation");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n\n                    <div class=\"col-md-6\">\n                        <div class=\"form-floating mb-3\">\n                            <select class=\"form-select\" name=\"autoriteContractanteCode\" id=\"autoriteContractante\">\n                                <option value=\"\">Choisir une autorité...</option>\n                                ");
				for (var el: autoriteContractanteList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_7 = el.getCode().equals(marcheDTO.getAutoriteContractanteCode());
					if (__jte_html_attribute_7) {
					jteOutput.writeContent(" selected");
					}
					var __jte_html_attribute_8 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_8)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_8);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n                                    </option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                            <label for=\"autoriteContractante\">Autorité Contractante</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "autoriteContractanteCode");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n\n                    <div class=\"col-md-6\">\n                        <div class=\"form-floating mb-3\">\n                            <select class=\"form-select\" name=\"structureAutoriteContractanteCode\" id=\"structureAutoriteContractanteCode\">\n                                <option value=\"\">Sélectionner...</option>\n                                ");
				for (var el: autoriteContractanteStructuresList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_9 = el.getCode().equals(marcheDTO.getStructureAutoriteContractanteCode());
					if (__jte_html_attribute_9) {
					jteOutput.writeContent(" selected");
					}
					var __jte_html_attribute_10 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_10)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_10);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n                                    </option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                            <label for=\"structureAutoriteContractanteCode\">Structure AC</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "structureAutoriteContractanteCode");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n\n                    <div class=\"col-md-6\">\n                        <div class=\"form-floating mb-3\">\n                            <select class=\"form-select\" name=\"typeMarcheCode\" id=\"typeMarcheCode\">\n                                <option value=\"\">Sélectionner...</option>\n                                ");
				for (var el: typesMarcheList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_11 = marcheDTO.getTypeMarcheCode() != null && marcheDTO.getTypeMarcheCode().equals(el.getCode());
					if (__jte_html_attribute_11) {
					jteOutput.writeContent(" selected");
					}
					var __jte_html_attribute_12 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_12)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_12);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n                                    </option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                            <label for=\"typeMarcheCode\">Type de Marché</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "typeMarcheCode");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n\n                    <div class=\"col-md-6\">\n                        <div class=\"form-floating mb-3\">\n                            <select class=\"form-select\" name=\"modePassationCode\" id=\"modePassationCode\">\n                                <option value=\"\">Sélectionner...</option>\n                                ");
				for (var el: modesPassationList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_13 = marcheDTO.getModePassationCode() != null && marcheDTO.getModePassationCode().equals(el.getCode());
					if (__jte_html_attribute_13) {
					jteOutput.writeContent(" selected");
					}
					var __jte_html_attribute_14 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_14)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_14);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n                                    </option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                            <label for=\"modePassationCode\">Mode de Passation</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "modePassationCode");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n\n                    <div class=\"col-md-6\">\n                        <div class=\"form-floating mb-3\">\n                            <input type=\"text\" class=\"form-control\" id=\"titulaireMarche\" name=\"titulaireMarche\"\n                                   placeholder=\"Titulaire du  marché\"");
				var __jte_html_attribute_15 = marcheDTO.getTitulaireMarche();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_15)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_15);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n                            <label for=\"titulaireMarche\"><i class=\"bi bi-person-check me-2\"></i>Titulaire du  marché</label>\n                            ");
				gg.jte.generated.ondemand.JteformMessageGenerated.render(jteOutput, jteHtmlInterceptor, bindingResult, "titulaireMarche");
				jteOutput.writeContent("\n                        </div>\n                    </div>\n\n                </div>\n\n                <div class=\"mt-4 pt-3 border-top d-flex gap-2\">\n                    <button type=\"submit\" class=\"btn btn-success px-5 shadow-sm\">\n                        <i class=\"bi bi-check-circle me-2\"></i>Enregistrer les modifications\n                    </button>\n                    <a href=\"/marche/list\" class=\"btn btn-light px-4 border\">\n                        Annuler\n                    </a>\n                </div>\n            </form>\n        </div>\n    </div>\n\n    <script>\n        ");
				jteOutput.writeContent("\n        const config = { showSearch: true, searchPlaceholder: 'Rechercher...' };\n        new SlimSelect({ select: '#imputation', ...config });\n        new SlimSelect({ select: '#autoriteContractante', ...config });\n        new SlimSelect({ select: '#structureAutoriteContractanteCode', ...config });\n        new SlimSelect({ select: '#typeMarcheCode', ...config });\n        new SlimSelect({ select: '#modePassationCode', ...config });\n\n\n\n\n    </script>\n");
			}
		}, messages);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BindingResult bindingResult = (BindingResult)params.get("bindingResult");
		MarcheDTO marcheDTO = (MarcheDTO)params.get("marcheDTO");
		Map<String, String> messages = (Map<String, String>)params.get("messages");
		List<Imputation> imputationList = (List<Imputation>)params.get("imputationList");
		List<AutoriteContractante> autoriteContractanteList = (List<AutoriteContractante>)params.get("autoriteContractanteList");
		List<AutoriteContractanteStructures> autoriteContractanteStructuresList = (List<AutoriteContractanteStructures>)params.get("autoriteContractanteStructuresList");
		List<TypesMarche> typesMarcheList = (List<TypesMarche>)params.get("typesMarcheList");
		List<ModesPassation> modesPassationList = (List<ModesPassation>)params.get("modesPassationList");
		render(jteOutput, jteHtmlInterceptor, bindingResult, marcheDTO, messages, imputationList, autoriteContractanteList, autoriteContractanteStructuresList, typesMarcheList, modesPassationList);
	}
}
