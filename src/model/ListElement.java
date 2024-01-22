package model;

import java.util.ArrayList;
import java.util.List;

public class ListElement extends TagElement {
    private boolean ordered;
    private List<Element> items;

    public ListElement(boolean ordered, String attributes) {
        super(ordered ? "ol" : "ul", true, null, attributes);
        this.ordered = ordered;
        this.items = new ArrayList<Element>();
    }

    public void addItem(Element item) {
        items.add(item);
    }

    public String genHTML(int indentation) {
        StringBuilder sb = new StringBuilder();
        String indent = " ".repeat(indentation * 3);

        sb.append(indent).append(getStartTag()).append("\n");

        for (Element item : items) {
            sb.append(indent).append("   ").append("<li>").append("\n");
            sb.append(indent).append("      ").append(item.genHTML(indentation + 3).trim()).append("\n");
            sb.append(indent).append("   ").append("</li>").append("\n");
        }

        sb.append(indent).append(getEndTag()).append("\n");

        return sb.toString();
    }
}
