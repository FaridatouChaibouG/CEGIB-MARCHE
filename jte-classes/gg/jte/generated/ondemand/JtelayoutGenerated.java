package gg.jte.generated.ondemand;
import gg.jte.Content;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,12,12,12,12,16,25,29,49,57,57,57,57,62,62,62,62,67,68,69,70,71,77,77,77,78,82,82,84,84,85,85,85,85,86,86,86,88,88,90,90,94,94,94,105,105,105,3,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content content, Map<String, String> messages) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"fr\" class=\"h-100\">\n<head>\n    <meta charset=\"utf-8\"/>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"/>\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent(" | CEGIB </title>\n\n    <script src=\"/jquery.min.js\"></script>\n\n    ");
		jteOutput.writeContent("\n    <link href=\"/dataTables/dataTables.min.css\" rel=\"stylesheet\">\n\n    <link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n    <script src=\"/bootstrap/js/bootstrap.bundle.min.js\"></script>\n    <link rel=\"stylesheet\" href=\"/bootstrap-icons/bootstrap-icons.min.css\">\n    <script src=\"/slimselect/slimselect.js\"></script>\n    <link rel=\"stylesheet\" href=\"/slimselect/slimselect.css\">\n\n    ");
		jteOutput.writeContent("\n    <script src=\"/dataTables/dataTables.min.js\"></script>\n\n    <style>\n        ");
		jteOutput.writeContent("\n        :root {\n            --cegib-green: #198754;\n            --cegib-light-green: #e9f5ee;\n            --sidebar-width: 260px;\n        }\n        body { background-color: #f4f7f6; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }\n        .sidebar { width: var(--sidebar-width); min-height: 100vh; background: var(--cegib-green); color: white; box-shadow: 4px 0 10px rgba(0,0,0,0.1); }\n        .sidebar .nav-link { color: rgba(255,255,255,0.8); padding: 12px 20px; margin: 5px 15px; border-radius: 8px; font-weight: 500; }\n        .sidebar .nav-link:hover { background: rgba(255,255,255,0.1); color: #fff; }\n        .sidebar .nav-link.active { background: #fff; color: var(--cegib-green) !important; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }\n        .main-wrapper { flex-grow: 1; display: flex; flex-direction: column; }\n        .top-navbar { background: #fff; border-bottom: 2px solid var(--cegib-green); padding: 12px 25px; }\n        .card { border: none; border-top: 4px solid var(--cegib-green); border-radius: 10px; box-shadow: 0 5px 15px rgba(0,0,0,0.05); }\n        .card-header { background: #fff; font-weight: bold; color: var(--cegib-green); }\n        .alert { border: none; border-left: 5px solid; }\n    </style>\n</head>\n\n<body class=\"d-flex h-100\">\n");
		jteOutput.writeContent("\n<nav class=\"sidebar d-none d-md-block\">\n    <div class=\"p-4 text-center border-bottom border-white border-opacity-25 mb-3\">\n        <h4 class=\"text-white fw-bold mb-0\">CEGIB MARCHE</h4>\n        <small class=\"text-white-50\">Gestion des Marchés</small>\n    </div>\n    <ul class=\"nav flex-column\">\n        <li class=\"nav-item\">\n            <a class=\"nav-link ");
		if (title.equals("Accueil")) {
			jteOutput.writeContent(" active ");
		}
		jteOutput.writeContent("\" href=\"/\">\n                <i class=\"bi bi-house-door-fill me-2\"></i> Accueil\n            </a>\n        </li>\n        <li class=\"nav-item\">\n            <a class=\"nav-link ");
		if (title.contains("Marche")) {
			jteOutput.writeContent(" active ");
		}
		jteOutput.writeContent("\" href=\"/marche/list\">\n                <i class=\"bi bi-file-earmark-text-fill me-2\"></i> Marchés\n            </a>\n        </li>\n\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n");
		jteOutput.writeContent("\n    </ul>\n</nav>\n\n<div class=\"main-wrapper\">\n    <header class=\"top-navbar d-flex justify-content-between align-items-center\">\n        <h5 class=\"mb-0 fw-bold text-uppercase\" style=\"color: var(--cegib-green);\">");
		jteOutput.setContext("h5", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</h5>\n        ");
		jteOutput.writeContent("\n    </header>\n\n    <main class=\"container-fluid p-4\">\n        ");
		if (null != messages && !messages.isEmpty()) {
			jteOutput.writeContent("\n            <div class=\"mb-4\">\n                ");
			for (var el: messages.entrySet()) {
				jteOutput.writeContent("\n                    <div class=\"alert alert-");
				jteOutput.setContext("div", "class");
				jteOutput.writeUserContent(el.getKey());
				jteOutput.setContext("div", null);
				jteOutput.writeContent(" shadow-sm bg-white\" role=\"alert\">\n                        <i class=\"bi bi-info-circle me-2\"></i> ");
				jteOutput.setContext("div", null);
				jteOutput.writeUserContent(el.getValue());
				jteOutput.writeContent("\n                    </div>\n                ");
			}
			jteOutput.writeContent("\n            </div>\n        ");
		}
		jteOutput.writeContent("\n\n        <div class=\"card\">\n            <div class=\"card-body p-4\">\n                ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n            </div>\n        </div>\n    </main>\n\n    <footer class=\"mt-auto bg-white py-3 border-top text-center text-muted small\">\n        &copy; 2026 <strong>CEGIB</strong> - Système de Gestion <span class=\"ms-2 badge bg-success\">v0.0.1</span>\n    </footer>\n</div>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		Content content = (Content)params.get("content");
		Map<String, String> messages = (Map<String, String>)params.get("messages");
		render(jteOutput, jteHtmlInterceptor, title, content, messages);
	}
}
