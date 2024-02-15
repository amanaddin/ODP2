
import command.AddElementCommand;
import command.DocumentOperations;
import command.UpdateElementCommand;
import concreteDocument.TextDocument;
import document.Document;
import documentElement.DocumentElement;
import documentFacade.DocumentElementsAPI;

public class Client {

	public static void main(String[] args) {
	    DocumentElementsAPI documentFacade = new DocumentElementsAPI();
	    
	    DocumentOperations docop = new DocumentOperations();
	    Document txt = new TextDocument();
	    DocumentElement heading = documentFacade.createPrimitiveDocElement("heading", "hallo world");
	    docop.executeCommand(new AddElementCommand(txt, heading));
	    txt.render();
	    
	    docop.undoLastCommand();
	    txt.render();
	    docop.redoLastCommand();
	    txt.render();
	    DocumentElement heading2 = documentFacade.createPrimitiveDocElement("heading", "the updated heading");
	    docop.executeCommand(new UpdateElementCommand(txt, heading, heading2));
	    txt.render();
	    docop.undoLastCommand();
	    txt.render();
	    
	}


}
