package miniProjekt1.documentFacade;

import miniProjekt1.concreteDocumentElement.Heading;
import miniProjekt1.concreteDocumentElement.DocumentList;
import miniProjekt1.concreteDocumentElement.Paragraph;
import miniProjekt1.concreteDocumentElement.Table;
import miniProjekt1.documentElement.DocumentElement;

public class DocumentElementsAPI {

	public DocumentElement createPrimitiveDocElement(String type, String content) {
		switch (type.toLowerCase()) {
		case "heading":
			return new Heading(content);
		case "paragraph":
			return new Paragraph(content);
		default:
			throw new IllegalArgumentException("Invalid document element type: " + type);
		}
	}

	public DocumentList createListItem(String title) {
		return new DocumentList(title);
	}

	public Table createTable(String title) {
		return new Table(title);
	}
}
