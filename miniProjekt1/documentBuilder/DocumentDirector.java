package documentBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import concreteDocumentElement.DocumentList;
import concreteDocumentElement.Table;
import document.Document;
import documentElement.DocumentElement;
import documentFacade.DocumentElementsAPI;

public class DocumentDirector {
	private DocumentBuilder builder;

	public DocumentDirector(DocumentBuilder builder) {
		this.builder = builder;
	}

	public Document construct(DocumentElementsAPI api) {

		DocumentList list = getHardcodedList(api);
		Table table = getHardcodedTable(api);
		
		return builder.addElement(api.createPrimitiveDocElement("heading", "Heading:\n    THIS IS THE HEADING\n"))
				.addElement(api.createPrimitiveDocElement("paragraph", "Paragraph:\n    this is the paragraph\n"))
				.addElement(list)
				.addElement(table)
				.build();
	}
	

	public Document constructLetterTemplate(DocumentElementsAPI api) {
		DocumentList list = api.createListItem("-----------------------Title----------------------------");
		list.addElement(api.createPrimitiveDocElement("heading", "\nname:"));
		list.addElement(api.createPrimitiveDocElement("paragraph", "address:"));

		return builder.addElement(list)
				.addElement(api.createPrimitiveDocElement("paragraph",
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
	
	private Table getHardcodedTable(DocumentElementsAPI api) {
		Table table = api.createTable("This is the table");
		DocumentElement heading = api.createPrimitiveDocElement("heading", "Name");
		DocumentElement heading2 = api.createPrimitiveDocElement("heading", "Age");

		DocumentElement para1 = api.createPrimitiveDocElement("paragraph", "Ali");
		DocumentElement para2 = api.createPrimitiveDocElement("paragraph", "20");

		DocumentElement para3 = api.createPrimitiveDocElement("paragraph", "Anders");
		DocumentElement para4 = api.createPrimitiveDocElement("paragraph", "40");

		table.addRow(Arrays.asList(heading, heading2));
		table.addRow(Arrays.asList(para1, para2));
		table.addRow(Arrays.asList(para3, para4));
		return table;
		
	}
	
	private DocumentList getHardcodedList(DocumentElementsAPI api) {
		DocumentList list = api.createListItem("This is the listItem");
		list.addElement(api.createPrimitiveDocElement("heading", "Heading:\n    HEADING IN THE LIST "));
		list.addElement(api.createPrimitiveDocElement("paragraph", "Paragraph:\n    paragraph in the list"));
		return list;
	}


	private void addWeekDays(DocumentElementsAPI api, Table table) {
		String[] days = { "Mon", "Tis", "Wen", "Thr", "Fri", "Sat", "Sun" };
		List<DocumentElement> headings = new ArrayList<>();
		for (String day : days) {
			headings.add(api.createPrimitiveDocElement("heading", day));
		}
		table.addRow(headings);
	}

	private void addEmptyDays(DocumentElementsAPI api, Table table) {
		for (int i = 0; i < 5; i++) {
			List<DocumentElement> columns = new ArrayList<>();
			for (int r = 0; r < 7; r++) {
				columns.add(api.createPrimitiveDocElement("paragraph", ""));
			}
			table.addRow(columns);
		}
	}

}
