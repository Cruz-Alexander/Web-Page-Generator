package model;

public class HeadingElement extends TagElement {
    private Element content;
    private int level;

    public HeadingElement(Element content, int level, String attributes) {
        super("h" + level, true, content, attributes);
        this.content = content;
        this.level = level;
    }
}
