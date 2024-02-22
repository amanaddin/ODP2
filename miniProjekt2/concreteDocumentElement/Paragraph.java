package concreteDocumentElement;

import documentElement.DocumentElement;
import visitor.Visitor;

public class Paragraph implements DocumentElement {

	private String content;

	public Paragraph(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visitParagraph(this);
	}

}
