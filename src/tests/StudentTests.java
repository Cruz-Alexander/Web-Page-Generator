package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.TableElement;
import model.TagElement;
import model.TextElement;

public class StudentTests {
    public static final String TESTS_TAG = "\n\nEndTest";

    @Test
    public void pubTableTest1() {
        int indentation = 3;
        String attributes = "border=\"1\"", answer = "";

        TagElement.resetIds();
        TagElement.enableId(false);
        TableElement tableElement = new TableElement(2, 2, attributes);
        tableElement.addItem(0, 0, new TextElement("John"));
        tableElement.addItem(0, 1, new TextElement("Laura"));
        tableElement.addItem(1, 0, new TextElement("Rose"));

        answer += tableElement.genHTML(indentation);
        answer += TESTS_TAG;

        System.out.println(answer);
    }
}
