package concreteDocumentElement;

import documentElement.DocumentElement;

public class Paragraph implements DocumentElement {

	private String content;

	public Paragraph(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}

}
