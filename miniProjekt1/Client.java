
import java.util.Iterator;

import concreteDocumentElement.Paragraph;
import document.Document;
import documentBuilder.DocumentBuilder;
import documentBuilder.DocumentDirector;
import documentBuilder.TextDocumentBuilder;
import documentElement.DocumentElement;
import documentFacade.DocumentElementsAPI;

public class Client {

	public static void main(String[] args) {
	    DocumentElementsAPI documentFacade = new DocumentElementsAPI();
	    DocumentBuilder builder = new TextDocumentBuilder();
	    DocumentDirector director = new DocumentDirector(builder);
	    Document doc = director.construct(documentFacade);
	    doc.render();

	    Iterator<DocumentElement> iterator = doc.iterator();
	    int index = 0;
	    while (iterator.hasNext()) {
	        DocumentElement element = iterator.next();
	        if (index == 0) {
	            doc.removeElement(element);
	            index++;
	            System.out.println();
	        } else if (index == 1) {
	            doc.updateElement(element, new Paragraph("Paragraph:\n  this is updated paragraph \n"));
	            index++;
	        }
	    }
	    
	    System.out.println("|--------------------------------------------------------------------------------|");
	    System.out.println("  The document after removing the first heading and updating the first paragraph ");
	    System.out.println("|--------------------------------------------------------------------------------|");
	    System.out.println();
	    doc.render();
	    
	    
	    Document brevMall = director.constructLetterTemplate(documentFacade);
	    brevMall.render();
	    
	    Document calendarMall = director.constructCalendarTemplate(documentFacade);
	    calendarMall.render();
	    
	}


}
