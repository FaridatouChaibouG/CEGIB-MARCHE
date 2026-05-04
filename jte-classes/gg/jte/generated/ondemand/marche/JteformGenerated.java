package gg.jte.generated.ondemand.marche;
import com.advinteck.cegib.generated.referentiel.tables.pojos.*;
import org.springframework.validation.BindingResult;
import java.util.List;
import java.util.Map;
import com.advinteck.cegib.dto.MarcheDTO;
@SuppressWarnings("unchecked")
public final class JteformGenerated {
	public static final String JTE_NAME = "marche/form.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,4,6,6,6,6,15,15,18,18,89,90,91,99,109,109,109,109,109,109,109,109,109,110,110,110,110,112,112,114,114,114,116,116,119,129,129,129,129,129,129,129,131,131,133,133,133,135,135,138,147,147,147,147,151,151,154,154,154,154,154,154,154,154,154,155,155,155,155,155,157,157,157,157,157,157,161,161,165,165,167,167,167,169,169,174,175,176,184,194,194,194,194,198,198,201,201,201,201,201,201,201,201,201,202,202,202,202,202,204,204,204,208,208,212,212,214,214,214,216,216,220,230,230,230,230,234,234,237,237,237,237,237,237,237,237,237,238,238,238,238,238,240,240,240,244,244,248,248,250,250,250,252,252,258,268,268,268,268,268,268,268,268,268,270,270,270,270,272,272,274,274,274,276,276,280,281,282,290,300,300,300,300,304,304,307,307,307,307,307,307,307,307,307,308,308,308,308,308,310,310,310,314,314,318,318,320,320,320,322,322,326,336,336,336,336,340,340,343,343,343,343,343,343,343,343,343,344,344,344,344,344,346,346,346,350,350,354,354,356,356,356,358,358,362,372,372,372,372,372,372,372,372,372,373,373,373,373,375,375,377,377,377,379,379,383,393,393,393,393,395,395,397,397,397,399,399,405,433,433,433,433,433,6,7,8,9,10,11,12,13,13,13,13};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BindingResult bindingResult, MarcheDTO marcheDTO, Map<String, String> messages, List<TypesMarche> typeMarcheList, List<Imputation> imputationList, List<AutoriteContractante> autoriteContractanteList, List<AutoriteContractanteStructures> structureAutoriteContractanteList, List<ModesPassation> modePassationList) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Nouveau Marché", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n    <style>\n        .form-section-title {\n            font-size: 0.9rem;\n            font-weight: 700;\n            text-transform: uppercase;\n            letter-spacing: 1px;\n            color: #4e73df;\n            margin-bottom: 1.5rem;\n            display: flex;\n            align-items: center;\n        }\n\n        .form-section-title::after {\n            content: \"\";\n            flex: 1;\n            height: 1px;\n            background: #e3e6f0;\n            margin-left: 1rem;\n        }\n\n        .card-custom {\n            border-radius: 12px;\n            border: none;\n        }\n\n        .form-control,\n        .form-select {\n            border-color: #d1d3e2;\n            border-radius: 8px;\n            padding: 0.75rem 1rem;\n        }\n\n        .form-control:focus,\n        .form-select:focus {\n            border-color: #4e73df;\n            box-shadow: 0 0 0 0.2rem rgba(78, 115, 223, 0.1);\n        }\n\n        .btn-save {\n            background: linear-gradient(135deg, #198754 0%, #157347 100%);\n            border: none;\n            padding: 10px 30px;\n            border-radius: 8px;\n            font-weight: 600;\n            color: white;\n        }\n\n        .invalid-feedback {\n            display: block;\n            font-size: 0.85rem;\n        }\n    </style>\n\n    <div class=\"container-fluid py-4\">\n\n        <div class=\"d-flex justify-content-between align-items-center mb-4\">\n            <h1 class=\"h3 mb-0 text-gray-800\">Nouveau Marché</h1>\n\n            <a href=\"/marche/list\" class=\"btn btn-outline-secondary shadow-sm\">\n                <i class=\"bi bi-arrow-left me-1\"></i>\n                Retour à la liste\n            </a>\n        </div>\n\n        <div class=\"card card-custom shadow\">\n            <div class=\"card-body p-lg-5\">\n\n                <form action=\"/marche/save\" method=\"post\">\n\n                    ");
				jteOutput.writeContent("\n                    ");
				jteOutput.writeContent("\n                    ");
				jteOutput.writeContent("\n\n                    <div class=\"form-section-title\">\n                        01. Informations Générales\n                    </div>\n\n                    <div class=\"row g-4 mb-5\">\n\n                        ");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\">\n                                Numéro provisoire du marché\n                            </label>\n\n                            <input type=\"text\"\n                                   name=\"numMarche\"\n                                   placeholder=\"Ex: M0001\"\n                                  ");
				var __jte_html_attribute_0 = marcheDTO != null ? marcheDTO.getNumMarche() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("\n                                   class=\"form-control ");
				jteOutput.setContext("input", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("numMarche") ? "is-invalid" : "");
				jteOutput.setContext("input", null);
				jteOutput.writeContent("\">\n\n                            ");
				if (bindingResult != null && bindingResult.hasFieldErrors("numMarche")) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("numMarche").getDefaultMessage());
					jteOutput.writeContent("\n                                </div>\n                            ");
				}
				jteOutput.writeContent("\n                        </div>\n\n                        ");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-6\">\n                            <label class=\"form-label small fw-bold\">\n                                Objet du Marché\n                            </label>\n\n                            <textarea\n                                    name=\"objetMarche\"\n                                    rows=\"2\"\n                                    class=\"form-control ");
				jteOutput.setContext("textarea", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("objetMarche") ? "is-invalid" : "");
				jteOutput.setContext("textarea", null);
				jteOutput.writeContent("\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(marcheDTO != null ? marcheDTO.getObjetMarche() : "");
				jteOutput.writeContent("</textarea>\n\n                            ");
				if (bindingResult != null && bindingResult.hasFieldErrors("objetMarche")) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("objetMarche").getDefaultMessage());
					jteOutput.writeContent("\n                                </div>\n                            ");
				}
				jteOutput.writeContent("\n                        </div>\n\n                        ");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-12\">\n                            <label class=\"form-label small fw-bold\">\n                                Imputation Budgétaire\n                            </label>\n\n                            <select\n                                    name=\"imputation\"\n                                    class=\"form-select select-slim ");
				jteOutput.setContext("select", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("imputation") ? "is-invalid" : "");
				jteOutput.setContext("select", null);
				jteOutput.writeContent("\">\n\n                                <option value=\"\">Choisir...</option>\n\n                                ");
				for (var el : imputationList) {
					jteOutput.writeContent("\n\n                                    <option\n                                           ");
					var __jte_html_attribute_1 = el.getImputation();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent("\n                                           ");
					var __jte_html_attribute_2 = marcheDTO != null && marcheDTO.getImputation() != null && marcheDTO.getImputation().equals(el.getImputation());
					if (__jte_html_attribute_2) {
					jteOutput.writeContent(" selected");
					}
					jteOutput.writeContent(">\n\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getImputation());
					jteOutput.writeContent(" - ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n\n                                    </option>\n\n                                ");
				}
				jteOutput.writeContent("\n\n                            </select>\n\n                            ");
				if (bindingResult != null && bindingResult.hasFieldErrors("imputation")) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("imputation").getDefaultMessage());
					jteOutput.writeContent("\n                                </div>\n                            ");
				}
				jteOutput.writeContent("\n                        </div>\n\n                    </div>\n\n                    ");
				jteOutput.writeContent("\n                    ");
				jteOutput.writeContent("\n                    ");
				jteOutput.writeContent("\n\n                    <div class=\"form-section-title\">\n                        02. Caractéristiques du marché\n                    </div>\n\n                    <div class=\"row g-4 mb-2\">\n\n                        ");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-6\">\n\n                            <label class=\"form-label small fw-bold\">\n                                Type de Marché\n                            </label>\n\n                            <select\n                                    name=\"typeMarcheCode\"\n                                    class=\"form-select select-slim ");
				jteOutput.setContext("select", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("typeMarcheCode") ? "is-invalid" : "");
				jteOutput.setContext("select", null);
				jteOutput.writeContent("\">\n\n                                <option value=\"\">Choisir...</option>\n\n                                ");
				for (var el : typeMarcheList) {
					jteOutput.writeContent("\n\n                                    <option\n                                           ");
					var __jte_html_attribute_3 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_3);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent("\n                                           ");
					var __jte_html_attribute_4 = marcheDTO != null && marcheDTO.getTypeMarcheCode() != null && marcheDTO.getTypeMarcheCode().equals(el.getCode());
					if (__jte_html_attribute_4) {
					jteOutput.writeContent(" selected");
					}
					jteOutput.writeContent(">\n\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n\n                                    </option>\n\n                                ");
				}
				jteOutput.writeContent("\n\n                            </select>\n\n                            ");
				if (bindingResult != null && bindingResult.hasFieldErrors("typeMarcheCode")) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("typeMarcheCode").getDefaultMessage());
					jteOutput.writeContent("\n                                </div>\n                            ");
				}
				jteOutput.writeContent("\n\n                        </div>\n\n                        ");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-6\">\n\n                            <label class=\"form-label small fw-bold\">\n                                Mode de Passation\n                            </label>\n\n                            <select\n                                    name=\"modePassationCode\"\n                                    class=\"form-select select-slim ");
				jteOutput.setContext("select", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("modePassationCode") ? "is-invalid" : "");
				jteOutput.setContext("select", null);
				jteOutput.writeContent("\">\n\n                                <option value=\"\">Choisir...</option>\n\n                                ");
				for (var el : modePassationList) {
					jteOutput.writeContent("\n\n                                    <option\n                                           ");
					var __jte_html_attribute_5 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_5);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent("\n                                           ");
					var __jte_html_attribute_6 = marcheDTO != null && marcheDTO.getModePassationCode() != null && marcheDTO.getModePassationCode().equals(el.getCode());
					if (__jte_html_attribute_6) {
					jteOutput.writeContent(" selected");
					}
					jteOutput.writeContent(">\n\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n\n                                    </option>\n\n                                ");
				}
				jteOutput.writeContent("\n\n                            </select>\n\n                            ");
				if (bindingResult != null && bindingResult.hasFieldErrors("modePassationCode")) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("modePassationCode").getDefaultMessage());
					jteOutput.writeContent("\n                                </div>\n                            ");
				}
				jteOutput.writeContent("\n\n                        </div>\n\n                    </div>\n\n                    ");
				jteOutput.writeContent("\n\n                    <div class=\"col-md-12 mb-5\">\n\n                        <label class=\"form-label small fw-bold\">\n                            Titulaire du marché\n                        </label>\n\n                        <input type=\"text\"\n                               name=\"titulaireMarche\"\n                              ");
				var __jte_html_attribute_7 = marcheDTO != null ? marcheDTO.getTitulaireMarche() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_7)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_7);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("\n                               placeholder=\"Numéro d'Identification Fiscal de l'entreprise\"\n                               class=\"form-control ");
				jteOutput.setContext("input", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("titulaireMarche") ? "is-invalid" : "");
				jteOutput.setContext("input", null);
				jteOutput.writeContent("\">\n\n                        ");
				if (bindingResult != null && bindingResult.hasFieldErrors("titulaireMarche")) {
					jteOutput.writeContent("\n                            <div class=\"invalid-feedback\">\n                                ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("titulaireMarche").getDefaultMessage());
					jteOutput.writeContent("\n                            </div>\n                        ");
				}
				jteOutput.writeContent("\n\n                    </div>\n\n                    ");
				jteOutput.writeContent("\n                    ");
				jteOutput.writeContent("\n                    ");
				jteOutput.writeContent("\n\n                    <div class=\"form-section-title\">\n                        03. Autorités\n                    </div>\n\n                    <div class=\"row g-4 mb-5\">\n\n                        ");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-6\">\n\n                            <label class=\"form-label small fw-bold\">\n                                Autorité Contractante\n                            </label>\n\n                            <select\n                                    name=\"autoriteContractanteCode\"\n                                    class=\"form-select select-slim ");
				jteOutput.setContext("select", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("autoriteContractanteCode") ? "is-invalid" : "");
				jteOutput.setContext("select", null);
				jteOutput.writeContent("\">\n\n                                <option value=\"\">Choisir...</option>\n\n                                ");
				for (var el : autoriteContractanteList) {
					jteOutput.writeContent("\n\n                                    <option\n                                           ");
					var __jte_html_attribute_8 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_8)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_8);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent("\n                                           ");
					var __jte_html_attribute_9 = marcheDTO != null && marcheDTO.getAutoriteContractanteCode() != null && marcheDTO.getAutoriteContractanteCode().equals(el.getCode());
					if (__jte_html_attribute_9) {
					jteOutput.writeContent(" selected");
					}
					jteOutput.writeContent(">\n\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n\n                                    </option>\n\n                                ");
				}
				jteOutput.writeContent("\n\n                            </select>\n\n                            ");
				if (bindingResult != null && bindingResult.hasFieldErrors("autoriteContractanteCode")) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("autoriteContractanteCode").getDefaultMessage());
					jteOutput.writeContent("\n                                </div>\n                            ");
				}
				jteOutput.writeContent("\n\n                        </div>\n\n                        ");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-6\">\n\n                            <label class=\"form-label small fw-bold\">\n                                Structure\n                            </label>\n\n                            <select\n                                    name=\"structureAutoriteContractanteCode\"\n                                    class=\"form-select select-slim ");
				jteOutput.setContext("select", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("structureAutoriteContractanteCode") ? "is-invalid" : "");
				jteOutput.setContext("select", null);
				jteOutput.writeContent("\">\n\n                                <option value=\"\">Choisir...</option>\n\n                                ");
				for (var el : structureAutoriteContractanteList) {
					jteOutput.writeContent("\n\n                                    <option\n                                           ");
					var __jte_html_attribute_10 = el.getCode();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_10)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(__jte_html_attribute_10);
						jteOutput.setContext("option", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent("\n                                           ");
					var __jte_html_attribute_11 = marcheDTO != null && marcheDTO.getStructureAutoriteContractanteCode() != null && marcheDTO.getStructureAutoriteContractanteCode().equals(el.getCode());
					if (__jte_html_attribute_11) {
					jteOutput.writeContent(" selected");
					}
					jteOutput.writeContent(">\n\n                                        ");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(el.getIntitule());
					jteOutput.writeContent("\n\n                                    </option>\n\n                                ");
				}
				jteOutput.writeContent("\n\n                            </select>\n\n                            ");
				if (bindingResult != null && bindingResult.hasFieldErrors("structureAutoriteContractanteCode")) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("structureAutoriteContractanteCode").getDefaultMessage());
					jteOutput.writeContent("\n                                </div>\n                            ");
				}
				jteOutput.writeContent("\n\n                        </div>\n\n                        ");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-6\">\n\n                            <label class=\"form-label small fw-bold\">\n                                Approuvé par\n                            </label>\n\n                            <input type=\"text\"\n                                   name=\"approuvePar\"\n                                  ");
				var __jte_html_attribute_12 = marcheDTO != null ? marcheDTO.getApprouvePar() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_12)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_12);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent("\n                                   class=\"form-control ");
				jteOutput.setContext("input", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("approuvePar") ? "is-invalid" : "");
				jteOutput.setContext("input", null);
				jteOutput.writeContent("\">\n\n                            ");
				if (bindingResult != null && bindingResult.hasFieldErrors("approuvePar")) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("approuvePar").getDefaultMessage());
					jteOutput.writeContent("\n                                </div>\n                            ");
				}
				jteOutput.writeContent("\n\n                        </div>\n\n                        ");
				jteOutput.writeContent("\n\n                        <div class=\"col-md-6\">\n\n                            <label class=\"form-label small fw-bold\">\n                                Date d'approbation\n                            </label>\n\n                            <input type=\"date\"\n                                   name=\"dateApprobation\"\n                                   class=\"form-control ");
				jteOutput.setContext("input", "class");
				jteOutput.writeUserContent(bindingResult != null && bindingResult.hasFieldErrors("dateApprobation") ? "is-invalid" : "");
				jteOutput.setContext("input", null);
				jteOutput.writeContent("\">\n\n                            ");
				if (bindingResult != null && bindingResult.hasFieldErrors("dateApprobation")) {
					jteOutput.writeContent("\n                                <div class=\"invalid-feedback\">\n                                    ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(bindingResult.getFieldError("dateApprobation").getDefaultMessage());
					jteOutput.writeContent("\n                                </div>\n                            ");
				}
				jteOutput.writeContent("\n\n                        </div>\n\n                    </div>\n\n                    ");
				jteOutput.writeContent("\n\n                    <div class=\"d-flex justify-content-end mt-5\">\n\n                        <button type=\"submit\" class=\"btn btn-success btn-save shadow\">\n                            <i class=\"bi bi-check2-all me-2\"></i>\n                            Enregistrer\n                        </button>\n\n                    </div>\n\n                </form>\n\n            </div>\n        </div>\n    </div>\n\n    <script>\n        document.querySelectorAll('.select-slim').forEach(el => {\n            new SlimSelect({\n                select: el,\n                settings: {\n                    placeholderText: 'Choisir...',\n                }\n            });\n        });\n    </script>\n\n");
			}
		}, messages);
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
