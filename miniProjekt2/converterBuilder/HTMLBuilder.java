package converterBuilder;

import document.Document;
import documentElement.DocumentElement;
import visitor.HTMLVisitor;
import visitor.Visitor;

public class HTMLBuilder implements ConverterBuilder {

	private final Visitor visitor;
	private final StringBuilder htmlContent;

	public HTMLBuilder() {
		this.visitor = new HTMLVisitor();
		this.htmlContent = new StringBuilder();
	}

	@Override
	public String buildElement(DocumentElement docElement) {
		String elementHtml = docElement.accept(visitor);
		htmlContent.append(elementHtml);
		return elementHtml;
	}

	@Override
	public String buildDocument(Document document) {
		if (document == null || document.getElements() == null) {
			throw new IllegalArgumentException("Invalid document or document elements.");
		}
		StringBuilder documentContent = new StringBuilder();
		for (DocumentElement element : document.getElements()) {
			String elementHtml = element.accept(visitor);
			documentContent.append(elementHtml);
			htmlContent.append(elementHtml);
		}
		return wrapHtmlBody(documentContent.toString());
	}

	@Override
	public String getResult() {
		return wrapHtmlBody(htmlContent.toString());
	}

	private String wrapHtmlBody(String content) {
		return "<html>\n <body>\n\n" + content + "\n </body>\n</html>";
	}
}
