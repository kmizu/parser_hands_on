package com.github.kmizu.parser_hands_on.answer;

import com.github.kmizu.parser_hands_on.ParseFailure;
import static com.github.kmizu.parser_hands_on.expression.ExpressionNode.integer;

import com.github.kmizu.parser_hands_on.expression.ExpressionNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class MyExpressionParserTest {
    MyExpressionParser parser = new MyExpressionParser();
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
        assertEquals(integer(0), parser.parse("0"));
    }

    @Test
    public void confirm1IsParsed() {
        assertEquals(integer(1), parser.parse("1"));
    }

    @Test
    public void confirm9IsParsed() {
        assertEquals(integer(9), parser.parse("9"));
    }

    @Test
    public void confirm10IsParsed() {
        assertEquals(integer(10), parser.parse("10"));
    }

    @Test
    public void confirm11IsParsed() {
        assertEquals(integer(11), parser.parse("11"));
    }

    @Test
    public void confirm19IsParsed() {
        assertEquals(integer(19), parser.parse("19"));
    }

    @Test
    public void confirm20IsParsed() {
        assertEquals(integer(20), parser.parse("20"));
    }

    @Test
    public void confirm90IsParsed() {
        assertEquals(integer(90), parser.parse("90"));
    }

    @Test
    public void confirm91IsParsed() {
        assertEquals(integer(91), parser.parse("91"));
    }

    @Test
    public void confirm99IsParsed() {
        assertEquals(integer(99), parser.parse("99"));
    }

    @Test
    public void confirm100IsParsed() {
        assertEquals(integer(100), parser.parse("100"));
    }

    @Test
    public void confirm101IsParsed() {
        assertEquals(integer(101), parser.parse("101"));
    }

    @Test
    public void confirm109IsParsed() {
        assertEquals(integer(109), parser.parse("109"));
    }

    @Test
    public void confirm110IsParsed() {
        assertEquals(integer(110), parser.parse("110"));
    }

    @Test
    public void confirm111IsParsed() {
        assertEquals(integer(111), parser.parse("111"));
    }

    @Test
    public void confirmAdditionIsParsed1() {
        assertEquals(integer(1).add(integer(0)), parser.parse("1+0"));
        assertEquals(integer(1).add(integer(1)), parser.parse("1+1"));
        assertEquals(integer(1).add(integer(2)), parser.parse("1+2"));
        assertEquals(integer(1).add(integer(8)), parser.parse("1+8"));
        assertEquals(integer(1).add(integer(9)), parser.parse("1+9"));
    }

    @Test
    public void confirmSubtractionIsParsed1() {
        assertEquals(integer(1).subtract(integer(0)), parser.parse("1-0"));
        assertEquals(integer(1).subtract(integer(1)), parser.parse("1-1"));
        assertEquals(integer(1).subtract(integer(2)), parser.parse("1-2"));
        assertEquals(integer(1).subtract(integer(8)), parser.parse("1-8"));
        assertEquals(integer(1).subtract(integer(9)), parser.parse("1-9"));
    }

    @Test
    public void confirmMultiplicationIsParsed1() {
        assertEquals(integer(1).multiply(integer(0)), parser.parse("1*0"));
        assertEquals(integer(1).multiply(integer(1)), parser.parse("1*1"));
        assertEquals(integer(1).multiply(integer(2)), parser.parse("1*2"));
        assertEquals(integer(1).multiply(integer(8)), parser.parse("1*8"));
        assertEquals(integer(1).multiply(integer(9)), parser.parse("1*9"));
    }

    @Test
    public void confirmDivisionIsParsed1() {
        assertEquals(integer(1).divide(integer(0)), parser.parse("1/0"));
        assertEquals(integer(1).divide(integer(1)), parser.parse("1/1"));
        assertEquals(integer(1).divide(integer(2)), parser.parse("1/2"));
        assertEquals(integer(1).divide(integer(8)), parser.parse("1/8"));
        assertEquals(integer(1).divide(integer(9)), parser.parse("1/9"));
    }
}
