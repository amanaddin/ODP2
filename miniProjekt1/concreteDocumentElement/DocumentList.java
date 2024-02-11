package miniProjekt1.concreteDocumentElement;

import miniProjekt1.documentElement.DocumentElement;

import java.util.ArrayList;
import java.util.List;

public class DocumentList implements DocumentElement {

	private List<DocumentElement> elements;
	private String contetn;
	
	public DocumentList(String content) {
		this.elements = new ArrayList<>();
		this.contetn = content;
	}

	public void addElement(DocumentElement element) {
		elements.add(element);
	}

	public void removeElement(DocumentElement docElement) {
		if (elements.isEmpty()) {
            throw new IllegalStateException("The List is empty, cannot remove element.");
        }
        elements.remove(docElement);
	}
	
	public List<DocumentElement> getElements() {
		return new ArrayList<DocumentElement>(elements);
	}

	@Override
	public String getContent() {
		StringBuilder result = new StringBuilder();
		result.append(this.contetn);
		for (DocumentElement element : elements) {
			result.append("\n" + element.getContent()).append("\n");
		}
		return result.toString();
	}

}
