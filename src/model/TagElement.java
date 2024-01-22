package model;

public class TagElement implements Element {
    private static int nextId = 1;
    public static boolean enableId = true;

    private String tagName;
    private boolean endTag;
    private Element content;
    private String attributes;
    private int id;

    public TagElement(String tagName, boolean endTag, Element content, String attributes) {
        this.tagName = tagName;
        this.endTag = endTag;
        this.content = content;
        this.attributes = attributes;
        this.id = enableId ? nextId++ : 0;
    }

    public int getId() {
        return id;
    }

    public String getStringId() {
        return tagName + id;
    }

    public String getStartTag() {
        if (tagName.equals("img") && id > 0) {
            return "<" + tagName + " id=\"" + getStringId() + "\"";
        } else if (tagName.equals("img")) {
            return "<" + tagName;
        }

        if (enableId && id > 0 && attributes != null) {
            return "<" + tagName + " id=\"" + getStringId() + "\"" + attributes + ">";
        } else if (enableId && id > 0) {
            return "<" + tagName + " id=\"" + getStringId() + "\"" + ">";
        } else if (attributes != null) {
            return "<" + tagName + attributes + ">";
        } else {
            return "<" + tagName + ">";
        }
    }

    public String getEndTag() {
        return endTag ? "</" + tagName + ">" : "";
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public static void resetIds() {
        nextId = 1;
    }

    public static void enableId(boolean choice) {
        enableId = choice;
    }

    public String genHTML(int indentation) {
        StringBuilder html = new StringBuilder();
        String indent = " ".repeat(indentation * 4);

        html.append(indent).append(getStartTag());

        if (content != null) {
            html.append(content.genHTML(indentation + 1));
        }

        if (endTag) {
            html.append(indent).append(getEndTag());
        }

        return html.toString();
    }
}
