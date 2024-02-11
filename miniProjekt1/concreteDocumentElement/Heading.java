package miniProjekt1.concreteDocumentElement;

import miniProjekt1.documentElement.DocumentElement;

public class Heading implements DocumentElement {
	
	private String content;
	
	public Heading(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}

}
