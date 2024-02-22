package documentBuilder;

import java.util.ArrayList;
import java.util.List;

import concreteDocumentElement.DocumentList;
import concreteDocumentElement.Table;
import document.Document;
import documentElement.DocumentElement;
import documentFacade.DocElement;
import documentFacade.DocumentElementsAPI;

public class DocumentDirector {
	private DocumentBuilder builder;

	public DocumentDirector(DocumentBuilder builder) {
		this.builder = builder;
	}

	public Document construct(DocumentElementsAPI api) {

		DocumentList list = getHardcodedList(api);
		
		return builder.addElement(api.createPrimitiveDocElement(DocElement.HEADING, "Heading:\n    THIS IS THE HEADING\n"))
				.addElement(api.createPrimitiveDocElement(DocElement.PARAGRAPH, "Paragraph:\n    this is the paragraph\n"))
				.addElement(list)
				.build();
	}
	

	public Document constructLetterTemplate(DocumentElementsAPI api) {
		DocumentList list = api.createListItem("-----------------------Title----------------------------");
		list.addElement(api.createPrimitiveDocElement(DocElement.HEADING, "\nname:"));
		list.addElement(api.createPrimitiveDocElement(DocElement.PARAGRAPH, "address:"));

		return builder.addElement(list)
				.addElement(api.createPrimitiveDocElement(DocElement.PARAGRAPH,
						"--------------------------------------------------------\n"
								+ "--------------------------------------------------------\n"
								+ "--------------------------------------------------------\n"
								+ "--------------------------------------------------------\n\n"))
				.build();
	}

	public Document constructCalendarTemplate(DocumentElementsAPI api) {
		Table table = api.createTable("\nMonth  Week");
		addWeekDays(api, table);
		addEmptyDays(api, table);
		return builder
				.addElement(table)
				.build();
	}
	
	
	private DocumentList getHardcodedList(DocumentElementsAPI api) {
		DocumentList list = api.createListItem("This is the listItem");
		list.addElement(api.createPrimitiveDocElement(DocElement.HEADING, "Heading:\n    HEADING IN THE LIST "));
		list.addElement(api.createPrimitiveDocElement(DocElement.PARAGRAPH, "Paragraph:\n    paragraph in the list"));
		return list;
	}


	private void addWeekDays(DocumentElementsAPI api, Table table) {
		String[] days = { "Mon", "Tis", "Wen", "Thr", "Fri", "Sat", "Sun" };
		List<DocumentElement> headings = new ArrayList<>();
		for (String day : days) {
			headings.add(api.createPrimitiveDocElement(DocElement.HEADING, day));
		}
		table.addRow(headings);
	}

	private void addEmptyDays(DocumentElementsAPI api, Table table) {
		for (int i = 0; i < 5; i++) {
			List<DocumentElement> columns = new ArrayList<>();
			for (int r = 0; r < 7; r++) {
				columns.add(api.createPrimitiveDocElement(DocElement.PARAGRAPH, ""));
			}
			table.addRow(columns);
		}
	}

}
