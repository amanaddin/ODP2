
import command.AddElementCommand;
import command.DocumentOperations;
import command.RemoveElementCommand;
import command.UpdateElementCommand;
import concreteDocument.TextDocument;
import concreteDocumentElement.DocumentList;
import converterBuilder.ConverterBuilder;
import converterBuilder.HTMLBuilder;
import converterBuilder.MarkdownBuilder;
import document.Document;
import documentElement.DocumentElement;
import documentFacade.DocElement;
import documentFacade.DocumentElementsAPI;

public class Client {

	public static void main(String[] args) {
		DocumentElementsAPI documentFacade = new DocumentElementsAPI();

		DocumentOperations docop = new DocumentOperations();
		Document txt = new TextDocument();

		DocumentElement heading = documentFacade.createPrimitiveDocElement(DocElement.HEADING, "This is first element 'heading'");
		DocumentElement para = documentFacade.createPrimitiveDocElement(DocElement.PARAGRAPH, "this is the second element 'paragraph'");

		docop.executeCommand(new AddElementCommand(txt, heading));
		docop.executeCommand(new AddElementCommand(txt, para));
		
		
		  System.out.
		  println("------------------Document efter två addElement Command------------------"
		  ); System.out.println(); txt.render();
		  
		  docop.undoLastCommand(); System.out.println(); System.out.
		  println("------------------Document efter undo Command----------------------------"
		  ); System.out.println(); txt.render(); docop.redoLastCommand();
		  System.out.println(); System.out.
		  println("------------------Document efter redo Command----------------------------"
		  ); System.out.println(); txt.render(); DocumentElement heading2 =
		  documentFacade.createPrimitiveDocElement(DocElement.HEADING,
		  "the updated heading"); docop.executeCommand(new UpdateElementCommand(txt,
		  heading, heading2)); System.out.println(); System.out.
		  println("------------------Document efter update Command---------------------------"
		  ); System.out.println(); txt.render();
		  
		  docop.executeCommand(new RemoveElementCommand(txt, heading2));
		  System.out.println(); System.out.
		  println("------------------Document efter Remove Command---------------------------"
		  ); System.out.println(); txt.render();
		  
		  docop.undoLastCommand(); System.out.println(); System.out.
		  println("------------------Document efter undo Command----------------------------"
		  ); System.out.println(); txt.render();
		 
		  System.out.println();
		  System.out.println();
		  
		  DocumentElement listItme = documentFacade.createPrimitiveDocElement(DocElement.HEADING, "first itme in the list");
		  DocumentElement listItem2 = documentFacade.createPrimitiveDocElement(DocElement.HEADING, "second itme in the list");
		  DocumentList list = documentFacade.createListItem("this is the list");
		  list.addElement(listItme);
		  list.addElement(listItem2);
		
		  System.out.println("----HTML----");
		  ConverterBuilder builder;
		  builder = new HTMLBuilder(); 
		  builder.buildElement(heading);
		  builder.buildElement(para);
		  builder.buildElement(list);
		  System.out.println(builder.getResult());
		  
		  System.out.println();
		  System.out.println();
		  System.out.println("----markdown----");
		  
		  builder = new MarkdownBuilder();
		  builder.buildElement(heading);
		  builder.buildElement(para); 
		  builder.buildElement(list);
		  System.out.println(builder.getResult());
		 

	}

}
