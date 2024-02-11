package documentBuilder;

import document.Document;
import documentElement.DocumentElement;

public interface DocumentBuilder {
	DocumentBuilder addElement(DocumentElement element);
	Document build();
}
