package concreteDocument;

import java.util.ArrayList;
import java.util.List;

import document.Document;
import documentElement.DocumentElement;

public class TextDocument implements Document {
	private List<DocumentElement> elements;

	public TextDocument() {
		this.elements = new ArrayList<>();
	}

	@Override
	public void addElement(DocumentElement docElement) {
		elements.add(docElement);
	}

	@Override
	public void removeElement(DocumentElement docElement) {
		if (elements.isEmpty()) {
            throw new IllegalStateException("Document is empty, cannot remove element.");
        }
        elements.remove(docElement);
	}

	@Override
	public void updateElement(DocumentElement oldElement, DocumentElement newElement) {
		int index = elements.indexOf(oldElement);
		if (index != -1) {
			elements.set(index, newElement);
		}
	}

	@Override
	public List<DocumentElement> getElements() {
		 return new ArrayList<>(elements);
	}

	@Override
	public void render() {
		for (DocumentElement element : elements) {
			System.out.println(element.getContent());
		}
	}
}
