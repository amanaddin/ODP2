package command;

import document.Document;
import documentElement.DocumentElement;

public class RemoveElementCommand implements Command {
	
	private Document document;
	private DocumentElement element;

	public RemoveElementCommand(Document document, DocumentElement element) {
		this.document = document;
		this.element = element;
	}

	@Override
	public void execute() {
		document.removeElement(element);
	}

	@Override
	public void undo() {
		document.addElement(element);
	}

}
