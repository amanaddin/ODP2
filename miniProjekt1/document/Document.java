package document;

import java.util.Iterator;
import java.util.List;

import documentElement.DocumentElement;

public interface Document extends Iterable<DocumentElement> {
	void addElement(DocumentElement docElement);
	void removeElement(DocumentElement docElement);
	void updateElement(DocumentElement oldElement, DocumentElement newElement);
	List<DocumentElement> getElements();
	void render();
	
	@Override
    default Iterator<DocumentElement> iterator() {
        return getElements().iterator();
    }
}
