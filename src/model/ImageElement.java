package model;

public class ImageElement extends TagElement {
    private String imageURL;
    private int width;
    private int height;
    private String alt;

    public ImageElement(String imageURL, int width, int height, String alt, String attributes) {
        super("img", false, null, attributes);
        this.imageURL = imageURL;
        this.width = width;
        this.height = height;
        this.alt = alt;
    }

    public String getImageURL() {
        return imageURL;
    }

    @Override
    public String genHTML(int indentation) {
        StringBuilder html = new StringBuilder();
        String indent = " ".repeat(indentation * 4);

        html.append(indent).append(getStartTag());

        // Add image-specific attributes
        html.append(" src=\"").append(imageURL).append("\"");
        html.append(" width=\"").append(width).append("\"");
        html.append(" height=\"").append(height).append("\"");
        html.append(" alt=\"").append(alt).append("\"");
        html.append(">\n");

        return html.toString();
    }
}
