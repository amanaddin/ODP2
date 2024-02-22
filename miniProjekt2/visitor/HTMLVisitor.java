package visitor;

import java.util.List;

import concreteDocumentElement.DocumentList;
import concreteDocumentElement.Heading;
import concreteDocumentElement.Paragraph;
import concreteDocumentElement.Table;
import documentElement.DocumentElement;

public class HTMLVisitor implements Visitor {

	@Override
	public String visitHeading(Heading heading) {
		return "  <h1>" + heading.getContent() + "</h1>\n";
	}

	@Override
	public String visitParagraph(Paragraph paragraph) {
		return "  <p>" + paragraph.getContent() + "</p>\n";
	}

	@Override
	public String visitList(DocumentList documentList) {
		StringBuilder htmlContent = new StringBuilder("  <ul>\n");
		for (DocumentElement element : documentList.getElements()) {
			htmlContent.append("    <li>").append(element.getContent()).append("</li>\n");
			element.accept(this);
		}
		htmlContent.append("  </ul>");
		return htmlContent.toString();
	}

	@Override
	public String visitTable(Table table) {
	    StringBuilder htmlContent = new StringBuilder("<table>\n");
	    htmlContent.append(" <caption>").append(table.getContent()).append("</caption>\n");

	    if (!table.getCells().isEmpty()) {
	        for (List<DocumentElement> row : table.getCells()) {
	            htmlContent.append("  <tr>\n");
	            for (DocumentElement cell : row) {
	                htmlContent.append("   <td>").append(cell.getContent()).append("</td>\n");
	            }
	            htmlContent.append("  </tr>\n");
	        }
	    } else {
	        htmlContent.append("  <tr><td>No data available for the table.</td></tr>\n");
	    }

	    htmlContent.append("</table>");
	    return htmlContent.toString();
	}

}
