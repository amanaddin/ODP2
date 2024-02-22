package visitor;

import java.util.List;

import concreteDocumentElement.DocumentList;
import concreteDocumentElement.Heading;
import concreteDocumentElement.Paragraph;
import concreteDocumentElement.Table;
import documentElement.DocumentElement;

public class MarkdownVisitor implements Visitor {

	@Override
	public String visitHeading(Heading heading) {
		return "# " + heading.getContent() + "\n\n";
	}

	@Override
	public String visitParagraph(Paragraph paragraph) {
		return paragraph.getContent() + "\n\n";
	}

	@Override
	public String visitList(DocumentList documentList) {
		StringBuilder markdownContent = new StringBuilder();
		for (DocumentElement element : documentList.getElements()) {
			markdownContent.append("- ").append(element.getContent()).append("\n");
		}
		return markdownContent.toString() + "\n";
	}

	@Override
	public String visitTable(Table table) {
		StringBuilder markdownContent = new StringBuilder();

		// Content rows
		for (List<DocumentElement> row : table.getCells()) {
			markdownContent.append("|");
			for (DocumentElement cell : row) {
				markdownContent.append(" ").append(cell.getContent()).append(" |");
			}
			markdownContent.append("\n");
		}
		markdownContent.append("\n");

		return markdownContent.toString();
	}

}
