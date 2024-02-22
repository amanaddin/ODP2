package documentElement;

import visitor.Visitor;

public interface DocumentElement {
	String getContent();
	String accept(Visitor visitor);
}
