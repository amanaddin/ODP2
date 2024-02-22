package concreteDocumentElement;

import java.util.ArrayList;
import java.util.List;

import documentElement.DocumentElement;
import visitor.Visitor;

public class Table implements DocumentElement {
	private List<List<DocumentElement>> cells;
	private String title;

	public Table(String title) {
		this.title = title;
		this.cells = new ArrayList<>();
	}

	public void addRow(List<DocumentElement> row) {

		if (!cells.isEmpty() && cells.get(0).size() != row.size()) {
			throw new IllegalArgumentException("The row has a different number of columns " + row.size()
					+ " than the table " + cells.get(0).size());
		}
		this.cells.add(row);
	}
	
	public List<List<DocumentElement>> getCells(){
		return cells;
	}
	 @Override
	    public String getContent() {
	        StringBuilder tableContent = new StringBuilder();
	        tableContent.append(title).append("\n\n");

	        if (cells.isEmpty()) {
	            tableContent.append("No data available for the table.\n");
	        } else {
	            for (List<DocumentElement> row : cells) {
	                for (DocumentElement cell : row) {
	                    tableContent.append(cell.getContent()).append("\t");
	                }
	                tableContent.append("\n");
	            }
	        }
	        return tableContent.toString();
	    }

	@Override
	public String accept(Visitor visitor) {
		return visitor.visitTable(this);		
	}

}
