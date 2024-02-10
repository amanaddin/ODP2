package miniProjekt1.documentBuilder;

import miniProjekt1.document.Document;
import miniProjekt1.documentElement.DocumentElement;

public interface DocumentBuilder {
	void addElement(DocumentElement element);
	Document build();
}
