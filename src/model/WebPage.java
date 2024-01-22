package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebPage implements Comparable<WebPage> {
    private String title;
    private List<Element> elements;
    private static boolean enableId = false;

    public WebPage(String title) {
        this.title = title;
        this.elements = new ArrayList<Element>();
    }

    public int addElement(Element element) {
        if (element instanceof TagElement) {
            elements.add(element);
            if (enableId) {
                return ((TagElement) element).getId();//casting and adding elements
            }
        }
        return -1;
    }

    public String getWebPageHTML(int indentation) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html>\n<html>\n<head>\n<meta charset=\"utf-8\"/>\n<title>")//this is the specific format
                //that the .txt files ask for.
                .append(title)
                .append("</title>\n</head>\n<body>\n");

        for (Element element : elements) {
            sb.append(element.genHTML(indentation));
            sb.append("\n");
        }

        sb.append("</body>\n</html>");
        return sb.toString();
    }

    public void writeToFile(String filename, int indentation) {
        String html = getWebPageHTML(indentation);
        Utilities.writeToFile(filename, html);
    }

    public Element findElem(int id) {
        for (Element element : elements) {
            if (element instanceof TagElement && ((TagElement) element).getId() == id) {//matching the id's
                return element;
            }
        }
        return null;
    }

    public String stats() {
        int numLists = 0;
        int numParagraphs = 0;
        int numTables = 0;
        int usedTableCells = 0;
        int totalTableCells = 0;

        for (Element element : elements) {
            if (element instanceof ListElement) {
                numLists++;
            } else if (element instanceof ParagraphElement) {
                numParagraphs++;
            } else if (element instanceof TableElement) {
                numTables++;
                TableElement table = (TableElement) element;
                usedTableCells += table.getTableUtilization() * table.getRows() * table.getCols();//using TableElement class
                totalTableCells += table.getRows() * table.getCols();
            }
        }

        double tableUtilization = (totalTableCells != 0) ? (double) usedTableCells / totalTableCells : 0.0;

        return "List Count: " + numLists +
                "\nParagraph Count: " + numParagraphs +
                "\nTable Count: " + numTables +
                "\nTableElement Utilization: " + tableUtilization;
    }

    public static void enableId(boolean choice) {
        enableId = choice;
    }

    @Override
    public int compareTo(WebPage webPage) {//simple compareTo
        return this.title.compareTo(webPage.title);
    }
}
