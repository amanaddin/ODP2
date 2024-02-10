package miniProjekt1.concreteDocumentElement;

import java.util.ArrayList;
import java.util.List;
import miniProjekt1.documentElement.DocumentElement;

public class Table implements DocumentElement {
    private List<List<DocumentElement>> cells;
    private String title;

    public Table(String title) {
        this.title = title;
        this.cells = new ArrayList<>();
    }

    public void addRow(List<DocumentElement> row) {
    	
    	if(!cells.isEmpty() && cells.get(0).size() != row.size()) {
    		throw new IllegalArgumentException("The row has a different number of columns than the table");
    	}
        this.cells.add(row);
    }

    @Override
    public String getContent() {
        StringBuilder tableContent = new StringBuilder();
        tableContent.append(title).append("\n\n");
        
        if (cells.isEmpty()) {
            tableContent.append("No data available for the table.\n");
            return "Table: \n" + tableContent.toString();
        }

        // Calculate column widths
        int numColumns = cells.get(0).size();
        int[] columnWidths = new int[numColumns];
        for (List<DocumentElement> row : cells) {
            for (int i = 0; i < numColumns; i++) {
                String cellContent = row.get(i).getContent();
                columnWidths[i] = Math.max(columnWidths[i], cellContent.length());
            }
        }

        // Draw table
        int index = 0;
        for (List<DocumentElement> row : cells) {
            tableContent.append("|");
            for (int i = 0; i < numColumns; i++) {
                String cellContent = row.get(i).getContent();
                tableContent.append(" ").append(cellContent);
                tableContent.append(" ".repeat(columnWidths[i] - cellContent.length()));
                tableContent.append(" |");
            }
            tableContent.append("\n");
            if (index == 0) {
            	tableContent.append("+");
                for (int width : columnWidths) {
                    tableContent.append("-".repeat(width + 2)).append("+");
                }
                tableContent.append("\n");
                index++;
            }
        }

        return "Table: \n" + tableContent.toString();
    }

}
