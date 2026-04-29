package gg.jte.generated.ondemand.marche;
import com.advinteck.cegib.generated.referentiel.tables.pojos.*;
import org.springframework.validation.BindingResult;
import java.util.List;
import java.util.Map;
import com.advinteck.cegib.dto.MarcheDTO;
@SuppressWarnings("unchecked")
public final class JteformGenerated {
	public static final String JTE_NAME = "marche/form.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,6,15,15,18,18,69,72,73,74,75,76,80,80,80,86,86,86,86,86,87,87,88,88,88,88,88,88,88,88,88,88,88,88,88,89,89,89,89,89,89,91,91,99,102,103,104,105,109,109,109,109,109,110,110,111,111,111,111,111,111,111,111,111,111,111,111,111,112,112,112,114,114,120,120,120,120,120,121,121,122,122,122,122,122,122,122,122,122,122,122,122,122,123,123,123,125,125,131,137,137,137,137,137,138,138,139,139,139,139,139,139,139,139,139,139,139,139,139,140,140,140,142,142,148,148,148,148,148,149,149,150,150,150,150,150,150,150,150,150,150,150,150,150,151,151,151,153,153,160,160,160,160,160,160,160,160,160,191,191,191,192,192,192,6,7,8,9,10,11,12,13,13,13,13};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BindingResult bindingResult, MarcheDTO marcheDTO, Map<String, String> messages, List<TypesMarche> typeMarcheList, List<Imputation> imputationList, List<AutoriteContractante> autoriteContractanteList, List<AutoriteContractanteStructures> structureAutoriteContractanteList, List<ModesPassation> modePassationList) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Nouveau Marché", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <style>\n        .form-section-title {\n            font-size: 0.9rem;\n            font-weight: 700;\n            text-transform: uppercase;\n            letter-spacing: 1px;\n            color: #4e73df;\n            margin-bottom: 1.5rem;\n            display: flex;\n            align-items: center;\n        }\n        .form-section-title::after {\n            content: \"\";\n            flex: 1;\n            height: 1px;\n            background: #e3e6f0;\n            margin-left: 1rem;\n        }\n        .card-custom { border-radius: 12px; border: none; }\n        .form-control, .form-select {\n            border-color: #d1d3e2;\n            border-radius: 8px;\n            padding: 0.75rem 1rem;\n        }\n        .form-control:focus, .form-select:focus {\n            border-color: #4e73df;\n            box-shadow: 0 0 0 0.2rem rgba(78, 115, 223, 0.1);\n        }\n        .btn-save {\n            background: linear-gradient(135deg, #198754 0%, #157347 100%);\n            border: none;\n            padding: 10px 30px;\n            border-radius: 8px;\n            font-weight: 600;\n            color: white;\n        }\n    </style>\n\n    <div class=\"container-fluid py-4\">\n        <div class=\"d-flex justify-content-between align-items-center mb-4\">\n            <h1 class=\"h3 mb-0 text-gray-800\"></h1>\n            <a href=\"/marche/list\" class=\"btn btn-outline-secondary shadow-sm\">\n                <i class=\"bi bi-arrow-left me-1\"></i> Annuler et retourner\n            </a>\n        </div>\n\n        <div class=\"card card-custom shadow\">\n            <div class=\"card-body p-lg-5\">\n                <form action=\"/marche/save\" method=\"post\">\n\n                    ");
				jteOutput.writeContent("\n                    <div class=\"form-section-title\">01. Informations Générales</div>\n                    <div class=\"row g-4 mb-5\">\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\">Objet du Marché</label>\n                            <textarea class=\"form-control\" name=\"objetMarche\" rows=\"2\" placeholder=\"Description du marché...\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(marcheDTO.getObjetMarche());
				jteOutput.writeContent("</textarea>\n                        </div>\n\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\">Imputation Budgétaire</label>\n                            <select class=\"form-select select-slim\" name=\"imputation\">\n                                <option value=\"\" disabled");
				var __jte_html_attribute_0 = marcheDTO.getImputation() == null;
				if (__jte_html_attribute_0) {
				jteOutput.writeContent(" selected");
				}
				jteOutput.writeContent(">Choisir...</option>\n                                ");
				for (var el: imputationList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_1 = marcheDTO.getImputation() != null && marcheDTO.getImputation().equals(el.getImputation());
					if (__jte_html_attribute_1) {
					jteOutput.writeContent(" selected");
					}
					var __jte_html_attribute_2 = el.getImputation();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_2);
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
				jteOutput.writeContent("\n                            </select>\n                        </div>\n\n                    </div>\n\n\n\n                    ");
				jteOutput.writeContent("\n                    <div class=\"form-section-title\">02. Caractéristiques du marché </div>\n                    <div class=\"row g-4 mb-5\">\n                        ");
				jteOutput.writeContent("\n                        ");
				jteOutput.writeContent("\n                        ");
				jteOutput.writeContent("\n                        ");
				jteOutput.writeContent("\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\">Type de Marché</label>\n                            <select class=\"form-select select-slim\" name=\"typeMarcheCode\">\n                                <option value=\"\" disabled");
				var __jte_html_attribute_3 = marcheDTO.getTypeMarcheCode() == null;
				if (__jte_html_attribute_3) {
				jteOutput.writeContent(" selected");
				}
				jteOutput.writeContent(">Choisir...</option>\n                                ");
				for (var el: typeMarcheList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_4 = marcheDTO.getTypeMarcheCode() != null && marcheDTO.getTypeMarcheCode().equals(el.getCode());
					if (__jte_html_attribute_4) {
					jteOutput.writeContent(" selected");
					}
					var __jte_html_attribute_5 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_5);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n                                    </option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                        </div>\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\">Mode de Passation</label>\n                            <select class=\"form-select select-slim\" name=\"modePassationCode\">\n                                <option value=\"\" disabled");
				var __jte_html_attribute_6 = marcheDTO.getModePassationCode() == null;
				if (__jte_html_attribute_6) {
				jteOutput.writeContent(" selected");
				}
				jteOutput.writeContent(">Choisir...</option>\n                                ");
				for (var el: modePassationList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_7 = marcheDTO.getModePassationCode() != null && marcheDTO.getModePassationCode().equals(el.getCode());
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
				jteOutput.writeContent("\n                            </select>\n                        </div>\n                    </div>\n\n\n                    ");
				jteOutput.writeContent("\n                    <div class=\"form-section-title\">03.  Autorités</div>\n                    <div class=\"row g-4 mb-5\">\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\">Autorité Contractante</label>\n                            <select class=\"form-select select-slim\" name=\"autoriteContractanteCode\">\n                                <option value=\"\" disabled");
				var __jte_html_attribute_9 = marcheDTO.getAutoriteContractanteCode() == null;
				if (__jte_html_attribute_9) {
				jteOutput.writeContent(" selected");
				}
				jteOutput.writeContent(">Choisir...</option>\n                                ");
				for (var el: autoriteContractanteList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_10 = marcheDTO.getAutoriteContractanteCode() != null && marcheDTO.getAutoriteContractanteCode().equals(el.getCode());
					if (__jte_html_attribute_10) {
					jteOutput.writeContent(" selected");
					}
					var __jte_html_attribute_11 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_11)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_11);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n                                    </option>\n                                ");
				}
				jteOutput.writeContent("\n                            </select>\n                        </div>\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\">Structure Bénéficiaire</label>\n                            <select class=\"form-select select-slim\" name=\"structureAutoriteContractanteCode\">\n                                <option value=\"\" disabled");
				var __jte_html_attribute_12 = marcheDTO.getStructureAutoriteContractanteCode() == null;
				if (__jte_html_attribute_12) {
				jteOutput.writeContent(" selected");
				}
				jteOutput.writeContent(">Choisir...</option>\n                                ");
				for (var el: structureAutoriteContractanteList) {
					jteOutput.writeContent("\n                                    <option");
					var __jte_html_attribute_13 = marcheDTO.getStructureAutoriteContractanteCode() != null && marcheDTO.getStructureAutoriteContractanteCode().equals(el.getCode());
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
				jteOutput.writeContent("\n                            </select>\n                        </div>\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\" >Approuvé par</label>\n                            <div class=\"input-group\">\n                                <span class=\"input-group-text bg-light\"><i class=\"bi bi-person\"></i></span>\n                                <input type=\"text\" class=\"form-control\" name=\"approuvePar\"");
				var __jte_html_attribute_15 = marcheDTO.getApprouvePar();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_15)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_15);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">\n                            </div>\n                        </div>\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\">Date d'approbation</label>\n                            <input type=\"date\" class=\"form-control\" name=\"dateApprobation\">\n                        </div>\n                    </div>\n\n\n                    <div class=\"d-flex justify-content-between align-items-center mt-5\">\n                        <button type=\"reset\" class=\"btn btn-link text-muted text-decoration-none\"></button>\n                        <button type=\"submit\" class=\"btn btn-success btn-save shadow\">\n                            <i class=\"bi bi-check2-all me-2\"></i> Enregistrer\n                        </button>\n                    </div>\n                </form>\n            </div>\n        </div>\n    </div>\n\n    <script>\n        document.querySelectorAll('.select-slim').forEach(el => {\n            new SlimSelect({\n                select: el,\n                settings: {\n                    placeholderText: 'Choisir...',\n                }\n            });\n        });\n    </script>\n");
			}
		}, messages);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BindingResult bindingResult = (BindingResult)params.get("bindingResult");
		MarcheDTO marcheDTO = (MarcheDTO)params.get("marcheDTO");
		Map<String, String> messages = (Map<String, String>)params.get("messages");
		List<TypesMarche> typeMarcheList = (List<TypesMarche>)params.get("typeMarcheList");
		List<Imputation> imputationList = (List<Imputation>)params.get("imputationList");
		List<AutoriteContractante> autoriteContractanteList = (List<AutoriteContractante>)params.get("autoriteContractanteList");
		List<AutoriteContractanteStructures> structureAutoriteContractanteList = (List<AutoriteContractanteStructures>)params.get("structureAutoriteContractanteList");
		List<ModesPassation> modePassationList = (List<ModesPassation>)params.get("modePassationList");
		render(jteOutput, jteHtmlInterceptor, bindingResult, marcheDTO, messages, typeMarcheList, imputationList, autoriteContractanteList, structureAutoriteContractanteList, modePassationList);
	}
}
