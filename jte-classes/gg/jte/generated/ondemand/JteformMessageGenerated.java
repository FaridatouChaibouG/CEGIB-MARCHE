package gg.jte.generated.ondemand;
import org.springframework.validation.BindingResult;
@SuppressWarnings("unchecked")
public final class JteformMessageGenerated {
	public static final String JTE_NAME = "formMessage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,2,6,6,8,8,8,10,10,11,11,11,2,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BindingResult bindingResult, String field) {
		if (bindingResult != null && bindingResult.hasErrors() && bindingResult.getFieldError(field) != null) {
			jteOutput.writeContent("\n    <small class=\"text-danger \">\n        ");
			jteOutput.setContext("small", null);
			jteOutput.writeUserContent(bindingResult.getFieldError(field).getDefaultMessage());
			jteOutput.writeContent("\n    </small>\n");
		}
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BindingResult bindingResult = (BindingResult)params.get("bindingResult");
		String field = (String)params.get("field");
		render(jteOutput, jteHtmlInterceptor, bindingResult, field);
	}
}
