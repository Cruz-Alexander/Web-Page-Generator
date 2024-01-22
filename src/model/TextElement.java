package model;

public class TextElement implements Element {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    public String genHTML(int indentation) {
        String indent = " ".repeat(indentation * 4);
        return indent + text;
    }
}
