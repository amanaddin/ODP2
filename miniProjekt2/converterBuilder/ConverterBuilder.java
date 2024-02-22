package converterBuilder;

import document.Document;
import documentElement.DocumentElement;

public interface ConverterBuilder {
	String buildElement(DocumentElement docelement);
	String buildDocument(Document document);
	String getResult();
}
