package gg.jte.generated.ondemand;
import gg.jte.Content;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,12,12,12,12,30,73,73,74,74,75,75,75,75,75,75,75,76,76,77,77,81,81,81,83,83,83,100,100,100,3,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content content, Map<String, String> messages) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"fr\" class=\"h-100\">\n<head>\n    <meta charset=\"utf-8\"/>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"/>\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\n\n    <script src=\"/jquery.min.js\"></script>\n\n    <link href=\"/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n    <script src=\"/bootstrap/js/bootstrap.bundle.min.js\"></script>\n\n    <link rel=\"stylesheet\" href=\"/bootstrap-icons/bootstrap-icons.min.css\">\n\n    <link href=\"/dataTables/dataTables.min.css\" rel=\"stylesheet\">\n    <script src=\"/dataTables/dataTables.min.js\"></script>\n\n    <link href=\"/slimselect/slimselect.css\" rel=\"stylesheet\">\n    <script src=\"/slimselect/slimselect.js\"></script>\n</head>\n\n<body id=\"page-top\" class=\"d-flex flex-column h-100\">\n\n");
		jteOutput.writeContent("\n<div id=\"content\" class=\"flex-grow-1 d-flex\">\n    <nav class=\"bg-light border-end p-3\" >\n        <ul class=\"nav flex-column gap-2\">\n\n            <li class=\"nav-item\">\n                <a class=\"nav-link text-primary border-bottom\" href=\"/\">\n                    <i class=\"bi bi-house-door me-2\"></i> Acceuil\n                </a>\n            </li>\n\n            <li class=\"nav-item\">\n                <a class=\"nav-link text-success border-bottom\" href=\"/marche/list\">\n                    <i class=\"bi bi-markdown-fill me-2\"></i>  Marche\n                </a>\n            </li>\n\n        </ul>\n    </nav>\n\n<div id=\"content\" class=\"flex-grow-1\">\n\n    <nav class=\"navbar navbar-expand-lg bg-success\">\n        <div class=\"container-fluid\">\n            <a class=\"navbar-brand\" href=\"/\">CEGIB-MARCHE</a>\n            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\"\n                    aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n                <span class=\"navbar-toggler-icon\"></span>\n            </button>\n            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n                <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n                    <li class=\"nav-item\">\n                        <a class=\"nav-link active\" aria-current=\"page\" href=\"/\"></a>\n                    </li>\n\n                </ul>\n            </div>\n        </div>\n    </nav>\n\n    <main class=\"container-fluid px-4\">\n        <div class=\"content-body animate-up pt-4\">\n            <div class=\"mb-3\">\n                ");
		if (null != messages && !messages.isEmpty()) {
			jteOutput.writeContent("\n                    ");
			for (var el: messages.entrySet()) {
				jteOutput.writeContent("\n                        <span class=\"alert alert-");
				jteOutput.setContext("span", "class");
				jteOutput.writeUserContent(el.getKey());
				jteOutput.setContext("span", null);
				jteOutput.writeContent("\"> ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(el.getValue());
				jteOutput.writeContent(" </span>\n                    ");
			}
			jteOutput.writeContent("\n                ");
		}
		jteOutput.writeContent("\n            </div>\n\n            <div class=\"card\">\n                <div class=\"card-header h3\"> ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent(" </div>\n                <div class=\"card-body\">\n                    ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n                </div>\n            </div>\n        </div>\n\n    </main>\n</div>\n</div>\n<footer class=\"bg-success border-top py-3\">\n    <div class=\"container-fluid px-4 d-flex justify-content-between align-items-center small text-muted\">\n        <span>&copy; 2026 <strong>CEGIB</strong></span>\n        <span class=\"d-none d-sm-inline\">Version 0.0.1-Dev</span>\n    </div>\n\n</footer>\n\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		Content content = (Content)params.get("content");
		Map<String, String> messages = (Map<String, String>)params.get("messages");
		render(jteOutput, jteHtmlInterceptor, title, content, messages);
	}
}
