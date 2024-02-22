package converterBuilder;

import document.Document;
import documentElement.DocumentElement;
import visitor.MarkdownVisitor;
import visitor.Visitor;

public class MarkdownBuilder implements ConverterBuilder {

	private Visitor visitor;
	private StringBuilder markdownContent;

	public MarkdownBuilder() {
		visitor = new MarkdownVisitor();
		markdownContent = new StringBuilder();
	}

	@Override
	public String buildElement(DocumentElement docelement) {
		String markdownElement = docelement.accept(visitor);
		markdownContent.append(markdownElement);
		return markdownElement;
	}

	@Override
	public String buildDocument(Document document) {
		if (document == null || document.getElements() == null) {
			throw new IllegalArgumentException("Invalid document or document elements.");
		}
		StringBuilder documentContetn = new StringBuilder();
		for (DocumentElement element : document.getElements()) {
			String markdownElement = element.accept(visitor);
			documentContetn.append(markdownElement);
			markdownContent.append(markdownElement);
		}
		return documentContetn.toString();
	}

	@Override
	public String getResult() {
		return markdownContent.toString();
	}

}
