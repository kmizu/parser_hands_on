package com.github.kmizu.parser_hands_on.my_parser;

import com.github.kmizu.parser_hands_on.ParseFailure;
import com.github.kmizu.parser_hands_on.digit.AbstractDigitParser;

public class MyDigitParser extends AbstractDigitParser {
    @Override
    public Integer parse(String input) {
        if(input.length() != 1) throw new ParseFailure("length must be 1");
        char ch = input.charAt(0);
        if(!('0' <= ch && ch <= '9')) throw new ParseFailure("first character is not digit");
        return ch - '0';
    }
}