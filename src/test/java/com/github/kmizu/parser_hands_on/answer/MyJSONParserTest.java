package com.github.kmizu.parser_hands_on.answer;

import com.github.kmizu.parser_hands_on.ParseFailure;
import org.junit.Test;

import static com.github.kmizu.parser_hands_on.json.JSONNode.*;
import static org.junit.Assert.assertEquals;

public class MyJSONParserTest {
    MyJSONParser parser = new MyJSONParser();

    @Test
    public void emptyObjectIsParsed() {
        assertEquals(
                jobject(),
                parser.parse("{}")
        );
    }

    @Test
    public void emptyArrayIsParsed() {
        assertEquals(
                jarray(),
                parser.parse("[]")
        );
    }

    @Test
    public void numberIsParsed() {
        assertEquals(
                jnumber(1.0),
                parser.parse("1")
        );
        assertEquals(
                jnumber(2.0),
                parser.parse("2")
        );
    }

    @Test
    public void nullIsParsed() {
        assertEquals(
                jnull(),
                parser.parse("null")
        );
    }

    @Test
    public void booleanIsParsed() {
        assertEquals(
                jboolean(true),
                parser.parse("true")
        );
        assertEquals(
                jboolean(false),
                parser.parse("false")
        );
    }

    @Test
    public void emptyStringIsParsed() {
        assertEquals(
                jstring(""),
                parser.parse("\"\"")
        );
    }
}
