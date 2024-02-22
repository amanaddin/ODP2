package visitor;

import concreteDocumentElement.DocumentList;
import concreteDocumentElement.Heading;
import concreteDocumentElement.Paragraph;
import concreteDocumentElement.Table;

public interface Visitor {
	String visitHeading(Heading heading);
	String visitParagraph(Paragraph paragraph);
	String visitList(DocumentList documentList);
	String visitTable(Table table);
}
