package com.github.kmizu.parser_hands_on.answer;

import com.github.kmizu.parser_hands_on.ParseFailure;
import org.junit.Test;

import static com.github.kmizu.parser_hands_on.limited_expression.LimitedExpressionNode.*;
import static org.junit.Assert.assertEquals;

public class MyLimitedExpressionParserTest {
    MyLimitedExpressionParser parser = new MyLimitedExpressionParser();
    @Test(expected = ParseFailure.class)
    public void confirmTestFailure1() {
        parser.parse("ab");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure2() {
        parser.parse("1a");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure3() {
        parser.parse("a1");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure4() {
        parser.parse("01");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure5() {
        parser.parse("123a456");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure6() {
        parser.parse("123456a");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure7() {
        parser.parse("ab12345b");
    }

    @Test
    public void confirm0IsParsed() {
        assertEquals(v(0), parser.parse("0"));
    }

    @Test
    public void confirm1IsParsed() {
        assertEquals(v(1), parser.parse("1"));
    }

    @Test
    public void confirm9IsParsed() {
        assertEquals(v(9), parser.parse("9"));
    }

    @Test
    public void confirm10IsParsed() {
        assertEquals(v(10), parser.parse("10"));
    }

    @Test
    public void confirm11IsParsed() {
        assertEquals(v(11), parser.parse("11"));
    }

    @Test
    public void confirm19IsParsed() {
        assertEquals(v(19), parser.parse("19"));
    }

    @Test
    public void confirm20IsParsed() {
        assertEquals(v(20), parser.parse("20"));
    }

    @Test
    public void confirm90IsParsed() {
        assertEquals(v(90), parser.parse("90"));
    }

    @Test
    public void confirm91IsParsed() {
        assertEquals(v(91), parser.parse("91"));
    }

    @Test
    public void confirm99IsParsed() {
        assertEquals(v(99), parser.parse("99"));
    }

    @Test
    public void confirm100IsParsed() {
        assertEquals(v(100), parser.parse("100"));
    }

    @Test
    public void confirm101IsParsed() {
        assertEquals(v(101), parser.parse("101"));
    }

    @Test
    public void confirm109IsParsed() {
        assertEquals(v(109), parser.parse("109"));
    }

    @Test
    public void confirm110IsParsed() {
        assertEquals(v(110), parser.parse("110"));
    }

    @Test
    public void confirm111IsParsed() {
        assertEquals(v(111), parser.parse("111"));
    }

    @Test
    public void confirmAdditionIsParsed() {
        assertEquals(add(1, 0), parser.parse("1+0"));
        assertEquals(add(1, 2), parser.parse("1+2"));
        assertEquals(add(1, 8), parser.parse("1+8"));
        assertEquals(add(1, 9), parser.parse("1+9"));
    }

    @Test
    public void confirmSubtractionIsParsed() {
        assertEquals(sub(1, 0), parser.parse("1-0"));
        assertEquals(sub(1, 2), parser.parse("1-2"));
        assertEquals(sub(1, 8), parser.parse("1-8"));
        assertEquals(sub(1, 9), parser.parse("1-9"));
    }

    @Test
    public void confirmMultiplicationIsParsed() {
        assertEquals(mul(1, 0), parser.parse("1*0"));
        assertEquals(mul(1, 2), parser.parse("1*2"));
        assertEquals(mul(1, 8), parser.parse("1*8"));
        assertEquals(mul(1, 9), parser.parse("1*9"));
    }

    @Test
    public void confirmDivisionIsParsed() {
        assertEquals(div(1, 0), parser.parse("1/0"));
        assertEquals(div(1, 2), parser.parse("1/2"));
        assertEquals(div(1, 8), parser.parse("1/8"));
        assertEquals(div(1, 9), parser.parse("1/9"));
    }
}
