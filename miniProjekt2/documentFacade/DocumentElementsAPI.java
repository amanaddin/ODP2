package documentFacade;

import concreteDocumentElement.DocumentList;
import concreteDocumentElement.Heading;
import concreteDocumentElement.Paragraph;
import concreteDocumentElement.Table;
import documentElement.DocumentElement;

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
