package concreteDocumentElement;

import documentElement.DocumentElement;
import visitor.Visitor;

public class Heading implements DocumentElement {

	private String content;

	public Heading(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visitHeading(this);
	}

}
