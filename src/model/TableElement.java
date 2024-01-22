package model;

public class TableElement extends TagElement {
    private Element[][] table;
    private int rowCount;
    private int colCount;

    public TableElement(int rows, int cols, String attributes) {
        super("table", true, null, attributes);
        table = new Element[rows][cols];
        rowCount = rows;
        colCount = cols;
    }

    public void addItem(int rowIndex, int colIndex, Element item) {
        table[rowIndex][colIndex] = item;
    }

    public double getTableUtilization() {
        int cellsInUse = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (table[i][j] != null) {
                    cellsInUse++;
                }
            }
        }
        return (double) cellsInUse / (rowCount * colCount) * 100;
    }

    public String genHTML(int indentation) {
        StringBuilder sb = new StringBuilder();
        sb.append(getStartTag()).append("\n");
        String indent = " ".repeat((indentation + 1) * 4);

        for (int i = 0; i < rowCount; i++) {
            sb.append(indent).append("<tr>\n");
            for (int j = 0; j < colCount; j++) {
                Element item = table[i][j];
                if (item != null) {
                    sb.append(indent).append("  <td>").append(item.genHTML(indentation + 2)).append("</td>\n");
                } else {
                    sb.append(indent).append("  <td></td>\n");
                }
            }
            sb.append(indent).append("</tr>\n");
        }

        sb.append(getEndTag()).append("\n");
        return sb.toString();
    }

    public int getRows() {
        return rowCount;
    }

    public int getCols() {
        return colCount;
    }
}
