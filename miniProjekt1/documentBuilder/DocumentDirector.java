package miniProjekt1.documentBuilder;


import java.util.Arrays;

import miniProjekt1.concreteDocumentElement.DocumentList;
import miniProjekt1.concreteDocumentElement.Table;
import miniProjekt1.document.Document;
import miniProjekt1.documentElement.DocumentElement;
import miniProjekt1.documentFacade.DocumentElementsAPI;

public class DocumentDirector {
	private DocumentBuilder builder;

    public DocumentDirector(DocumentBuilder builder) {
        this.builder = builder;
    }

    public Document construct(DocumentElementsAPI api) {
    	
    	//composite List 
        DocumentList list = api.createListItem("This is the listItem");
        list.addElement(api.createPrimitiveDocElement("heading", "\n    HEADING IN THE LIST "));
        list.addElement(api.createPrimitiveDocElement("paragraph", "\n    paragraph in the list"));
       
        //composite Table
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
        
        //constructing the document both from primitive and composite elements 
        builder.addElement(api.createPrimitiveDocElement("heading", "\n    THIS IS THE HEADING\n"));
        builder.addElement(api.createPrimitiveDocElement("paragraph", "\n    this is the paragraph\n"));
        builder.addElement(list);
        builder.addElement(table);
        return builder.build();
    }

}
