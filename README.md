# HTML Generation and Testing

This project includes Java classes for generating HTML content and supporting test functionalities. The code is organized into several classes that work together to create HTML elements and test their functionality.

## Classes

### 1. `AnchorElement`

- Represents an HTML anchor (`<a>`) element.
- Includes methods to get the URL and link text.
- Generates HTML for the anchor element.

### 2. `HeadingElement`

- Represents an HTML heading (`<h1>`, `<h2>`, etc.) element.
- Generates HTML for the heading element.

### 3. `ImageElement`

- Represents an HTML image (`<img>`) element.
- Includes methods to get image URL, width, height, and alt text.
- Generates HTML for the image element.

### 4. `ListElement`

- Represents an HTML list (`<ul>` or `<ol>`) element.
- Supports adding list items.
- Generates HTML for the list element.

### 5. `ParagraphElement`

- Represents an HTML paragraph (`<p>`) element.
- Supports adding elements to the paragraph.
- Generates HTML for the paragraph element.

### 6. `TableElement`

- Represents an HTML table (`<table>`) element.
- Supports adding items to table cells.
- Calculates table utilization.
- Generates HTML for the table element.

### 7. `TagElement`

- Represents a generic HTML tag.
- Handles the generation of HTML for various tags.
- Manages tag attributes and IDs.

### 8. `TextElement`

- Represents a plain text element.
- Generates HTML for the text.

### 9. `Utilities`

- Provides utility methods for the system.
- Includes a method for writing a string to a file.

### 10. `WebPage`

- Represents an HTML webpage.
- Supports adding various elements to the webpage.
- Generates HTML for the entire webpage.
- Provides methods for writing the webpage to a file and finding elements by ID.
- Includes a method for generating statistics about the webpage.

### 11. `TestsSupport`

- Provides support methods for testing.
- Includes methods for checking correctness, comparing file contents, reading file data, removing blanks, and writing to files.
- Used to generate official results for tests (optional).

## How to Use

1. **Create HTML Elements:**
   - Use the provided classes to create HTML elements (e.g., `AnchorElement`, `HeadingElement`, etc.).

2. **Build Webpage:**
   - Create a `WebPage` instance.
   - Add HTML elements to the webpage.

3. **Generate HTML:**
   - Use the `getWebPageHTML` method of the `WebPage` class to generate the entire HTML content.

4. **Write to File:**
   - Use the `writeToFile` method of the `WebPage` class to write the HTML content to a file.

5. **Run Tests:**
   - Use the `TestsSupport` class for testing, comparing results, and generating official results (optional).

## Note

- The project includes various HTML elements, and you can customize them according to your needs.
- Test files with expected results should be named starting with "studentTest" and ending with the `.txt` extension.
- Take caution when using the official results generation (`generateOfficialResults` variable) to avoid overwriting result files.

Feel free to explore and modify the code for your specific use case!
