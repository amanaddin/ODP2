package documentBuilder;

import concreteDocument.TextDocument;
import document.Document;
import documentElement.DocumentElement;

public class TextDocumentBuilder implements DocumentBuilder {
	private Document document;

	public TextDocumentBuilder() {
		this.document = new TextDocument();
	}

	@Override
	public DocumentBuilder addElement(DocumentElement element) {
		document.addElement(element);
		return this;
	}

	@Override
	public Document build() {
		return document;
	}

}
