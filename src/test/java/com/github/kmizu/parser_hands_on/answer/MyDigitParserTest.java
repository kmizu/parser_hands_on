package com.github.kmizu.parser_hands_on.answer;

import com.github.kmizu.parser_hands_on.ParseFailure;
import static org.junit.Assert.*;
import org.junit.Test;
import com.github.kmizu.parser_hands_on.my_parser.MyDigitParser;

public class MyDigitParserTest {
    MyDigitParser parser = new MyDigitParser();
    @Test(expected = ParseFailure.class)
    public void confirmTestFailure1() {
        parser.parse("ab");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure2() {
        parser.parse("19");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure3() {
        parser.parse("b9");
    }

    @Test(expected = ParseFailure.class)
    public void confirmSmallACannotBeParsed() {
        parser.parse("a");
    }

    @Test(expected = ParseFailure.class)
    public void confirmSmallZCannotBeParsed() {
        parser.parse("z");
    }

    @Test(expected = ParseFailure.class)
    public void confirmACannotBeParsed() {
        parser.parse("A");
    }

    @Test(expected = ParseFailure.class)
    public void confirmZCannotBeParsed() {
        parser.parse("Z");
    }

    @Test
    public void confirm0IsParsed() {
        assertEquals((Integer)0, parser.parse("0"));
    }

    @Test
    public void confirm1IsParsed() {
        assertEquals((Integer)1, parser.parse("1"));
    }

    @Test
    public void confirm9IsParsed() {
        assertSame((Integer)9, parser.parse("9"));
    }
}
