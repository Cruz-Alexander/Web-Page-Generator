package model;

public class AnchorElement extends TagElement {
    private String url;
    private String linkText;

    public AnchorElement(String url, String linkText, String attributes) {
        super("a", true, new TextElement(linkText), url);
        this.url = url;
        this.linkText = linkText;
    }

    public String getUrlText() {
        return url;
    }

    public String getLinkText() {
        return linkText;
    }

    @Override
    public String genHTML(int indentation) {
        StringBuilder sb = new StringBuilder();
        sb.append(getIndentation(indentation));
        sb.append("<a");
        if (TagElement.enableId == true) {
            sb.append(" id=\"" + getStringId() + "\"");
        }
        sb.append(" href=\"").append(getUrlText()).append("\"");
        sb.append(">").append(getLinkText()).append("</a>");
        return sb.toString();
    }

    private String getIndentation(int indentation) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentation; i++) {
            indent.append(" ");
        }
        return indent.toString();
    }
}
