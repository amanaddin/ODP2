package documentFacade;

import concreteDocumentElement.DocumentList;
import concreteDocumentElement.Heading;
import concreteDocumentElement.Paragraph;
import concreteDocumentElement.Table;
import documentElement.DocumentElement;

public class DocumentElementsAPI {

	public DocumentElement createPrimitiveDocElement(DocElement type, String content) {
		switch (type) {
		case HEADING:
			return new Heading(content);
		case PARAGRAPH:
			return new Paragraph(content);
		}
		return null;
	}

	public DocumentList createListItem(String title) {
		return new DocumentList(title);
	}

	public Table createTable(String title) {
		return new Table(title);
	}
}
