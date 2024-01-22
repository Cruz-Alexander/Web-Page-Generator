package model;

import java.util.ArrayList;
import java.util.List;

public class ParagraphElement extends TagElement {
    private List<Element> items;

    public ParagraphElement(String attributes) {
        super("p", true, null, attributes);
        items = new ArrayList<Element>();
    }

    public void addItem(Element item) {
        items.add(item);
    }

    public String genHTML(int indentation) {
        StringBuilder sb = new StringBuilder();
        sb.append(getStartTag()).append("\n");
        String indent = " ".repeat((indentation + 1) * 4);

        for (Element item : items) {
            sb.append(indent).append(item.genHTML(indentation + 1)).append("\n");
        }

        sb.append(getEndTag()).append("\n");
        return sb.toString();
    }
}
