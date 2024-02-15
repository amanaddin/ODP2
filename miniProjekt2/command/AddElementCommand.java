package command;

import document.Document;
import documentElement.DocumentElement;

public class AddElementCommand implements Command {

	private Document document;
	private DocumentElement element;

	public AddElementCommand(Document document, DocumentElement element) {
		this.document = document;
		this.element = element;
	}

	@Override
	public void execute() {
		document.addElement(element);
	}

	@Override
	public void undo() {
		document.removeElement(element);
	}

}
