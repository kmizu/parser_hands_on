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

    @Test
    public void oneElementArrayIsParsed() {
        assertEquals(
                jarray(jarray()),
                parser.parse("[[]]")
        );
        assertEquals(
                jarray(jobject()),
                parser.parse("[{}]")
        );
        assertEquals(
                jarray(jnull()),
                parser.parse("[null]")
        );
        assertEquals(
                jarray(jnumber(1.0)),
                parser.parse("[1]")
        );
        assertEquals(
                jarray(jboolean(true)),
                parser.parse("[true]")
        );
        assertEquals(
                jarray(jboolean(false)),
                parser.parse("[false]")
        );
    }

    @Test
    public void twoElementsArrayIsParsed() {
        assertEquals(
                jarray(jarray(), jarray()),
                parser.parse("[[],[]]")
        );
        assertEquals(
                jarray(jobject(), jobject()),
                parser.parse("[{},{}]")
        );
        assertEquals(
                jarray(jnull(), jnull()),
                parser.parse("[null,null]")
        );
        assertEquals(
                jarray(jnumber(1.0), jnumber(1.0)),
                parser.parse("[1,1]")
        );
        assertEquals(
                jarray(jboolean(true), jboolean(true)),
                parser.parse("[true,true]")
        );
        assertEquals(
                jarray(jboolean(false), jboolean(false)),
                parser.parse("[false,false]")
        );
    }

    @Test
    public void onePropertyObjectIsParsed() {
        assertEquals(
                jobject(
                        p("v", jnull())
                ),
                parser.parse("{\"v\":null}")
        );
        assertEquals(
                jobject(
                        p("v", jnumber(1.0))
                ),
                parser.parse("{\"v\":1}")
        );
        assertEquals(
                jobject(
                        p("v", jarray())
                ),
                parser.parse("{\"v\":[]}")
        );
        assertEquals(
                jobject(
                        p("v", jobject())
                ),
                parser.parse("{\"v\":{}}")
        );
        assertEquals(
                jobject(
                        p("v", jstring("foo"))
                ),
                parser.parse("{\"v\":\"foo\"}")
        );
        assertEquals(
                jobject(
                        p("v", jboolean(true))
                ),
                parser.parse("{\"v\":true}")
        );
        assertEquals(
                jobject(
                        p("v", jboolean(false))
                ),
                parser.parse("{\"v\":false}")
        );
    }
}
