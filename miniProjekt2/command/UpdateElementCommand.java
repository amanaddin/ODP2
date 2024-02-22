package command;

import document.Document;
import documentElement.DocumentElement;

public class UpdateElementCommand implements Command {

	private Document document;
	private DocumentElement oldElement, newElement;

	public UpdateElementCommand(Document document, DocumentElement oldElement, DocumentElement newElement) {
		this.document = document;
		this.oldElement = oldElement;
		this.newElement = newElement;
	}
	
	@Override
	public void execute() {
		document.updateElement(oldElement, newElement);
	}

	@Override
	public void undo() {
		document.updateElement(newElement, oldElement);
	}

}
