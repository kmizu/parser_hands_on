package com.github.kmizu.parser_hands_on.answer;

import com.github.kmizu.parser_hands_on.ParseFailure;
import org.junit.Test;

import com.github.kmizu.parser_hands_on.regular_expression.*;
import static com.github.kmizu.parser_hands_on.regular_expression.RegularExpressionNode.*;
import static org.junit.Assert.assertEquals;

public class MyRegularExpressionParserTest {
    MyRegularExpressionParser parser = new MyRegularExpressionParser();
    @Test(expected = ParseFailure.class)
    public void confirmTestFailure1() {
        parser.parse("|");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure2() {
        parser.parse("*");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure4() {
        parser.parse("|a");
    }

    @Test(expected = ParseFailure.class)
    public void confirmTestFailure5() {
        parser.parse("|a");
    }

    @Test
    public void confirmAIsParsed() {
        assertEquals(ch('a'), parser.parse("a"));
    }

    @Test
    public void confirmLargeAIsParsed() {
        assertEquals(ch('A'), parser.parse("A"));
    }

    @Test
    public void confirm0IsParsed() {
        assertEquals(ch('0'), parser.parse("0"));
    }

    @Test
    public void confirm9IsParsed() {
        assertEquals(ch('9'), parser.parse("9"));
    }

    @Test
    public void confirmZIsParsed() {
        assertEquals(ch('z'), parser.parse("z"));
    }

    @Test
    public void confirmLargeZIsParsed() {
        assertEquals(ch('Z'), parser.parse("Z"));
    }

    @Test
    public void confirmSymbolsAreParsed() {
        assertEquals(ch('#'), parser.parse("#"));
        assertEquals(ch('!'), parser.parse("!"));
        assertEquals(ch('/'), parser.parse("/"));
        assertEquals(ch('@'), parser.parse("@"));
        assertEquals(ch('{'), parser.parse("{"));
        assertEquals(ch('~'), parser.parse("~"));
    }

    @Test
    public void confirmChoiceIsParsed() {
        assertEquals(ch('a').or(ch('b')), parser.parse("a|b"));
        assertEquals(ch('b').or(ch('a')), parser.parse("b|a"));
    }

    @Test
    public void confirmSeuqenceIsParsed() {
        assertEquals(ch('a').next(ch('b')), parser.parse("ab"));
        assertEquals(ch('b').next(ch('a')), parser.parse("ba"));
    }

    @Test
    public void confirmRepetitionIsParsed() {
        assertEquals(ch('a').repeat(), parser.parse("a*"));
    }

    @Test
    public void confirmParenExpressionIsParsed() {
        assertEquals(ch('a').repeat(), parser.parse("(a)*"));
    }

    @Test
    public void combinationOfChoiceAndRepetition() {
        assertEquals(ch('a').or(ch('b').repeat()), parser.parse("a|b*"));
        assertEquals(ch('b').or(ch('a').repeat()), parser.parse("b|a*"));
        assertEquals(ch('a').or('b').repeat(), parser.parse("(a|b)*"));
        assertEquals(ch('b').or('a').repeat(), parser.parse("(b|a)*"));
    }

    @Test
    public void combinationOfChoiceAndSequence() {
        assertEquals(ch('a').or(ch('b').next(ch('c'))), parser.parse("a|bc"));
        assertEquals(ch('a').next('b').or(ch('c')), parser.parse("ab|c"));
        assertEquals(ch('a').or(ch('b')).next(ch('c')), parser.parse("(a|b)c"));
        assertEquals(ch('a').next('b').or(ch('c')), parser.parse("(ab)|c"));
    }

    @Test
    public void confirmComplexExpressionIsParsed() {
        assertEquals(
                ch('a').or('b').or('c').next(ch('d').repeat()).next(ch('e')),
                parser.parse("((a|b|c)d*)e")
        );
    }
}
