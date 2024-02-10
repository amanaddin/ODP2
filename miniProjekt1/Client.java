package miniProjekt1;

import java.util.Iterator;

import miniProjekt1.concreteDocumentElement.Paragraph;
import miniProjekt1.document.Document;
import miniProjekt1.documentBuilder.DocumentBuilder;
import miniProjekt1.documentBuilder.DocumentDirector;
import miniProjekt1.documentBuilder.TextDocumentBuilder;
import miniProjekt1.documentElement.DocumentElement;
import miniProjekt1.documentFacade.DocumentElementsAPI;

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
	            doc.updateElement(element, new Paragraph("\n  this is updated paragraph \n"));
	            index++;
	        }
	    }
	    
	    System.out.println("|--------------------------------------------------------------------------------|");
	    System.out.println("  The document after removing the first heading and updating the first paragraph ");
	    System.out.println("|--------------------------------------------------------------------------------|");
	    System.out.println();
	    doc.render();
	}


}
