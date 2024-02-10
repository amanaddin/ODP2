package miniProjekt1.documentBuilder;

import miniProjekt1.concreteDocument.TextDocument;
import miniProjekt1.document.Document;
import miniProjekt1.documentElement.DocumentElement;

public class TextDocumentBuilder implements DocumentBuilder {
	private Document document;

	public TextDocumentBuilder() {
		this.document = new TextDocument();
	}

	@Override
	public void addElement(DocumentElement element) {
		document.addElement(element);
	}

	@Override
	public Document build() {
		return document;
	}

}
