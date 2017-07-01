package com.github.kmizu.parser_hands_on.answer;

import com.github.kmizu.parser_hands_on.ParseFailure;
import com.github.kmizu.parser_hands_on.integer.AbstractIntegerParser;

import java.util.Stack;

public class MyIntegerParserRevised extends AbstractIntegerParser {
    private String input;
    private int position;
    private Stack<Integer> stack = new Stack<>();

    public String accept(char ch) {
        if(position < input.length() && input.charAt(position) == ch) {
            position++;
            return ((Character)ch).toString();
        }
        throw new ParseFailure("current position is over range or current character is not " + ch);
    }

    public char acceptRange(char from, char to) {
        if(position < input.length()){
            char ch = input.charAt(position);
            if(from <= ch && ch <= to) {
                position++;
                return ch;
            } else {
                throw new ParseFailure("current character is out of range: [" + from + "..." + to + "]");
            }
        } else {
            throw new ParseFailure("unexpected EOF");
        }
    }

    public void restore() {
        position = stack.pop();
    }

    public void save() {
        stack.push(position);
    }

    private int compute(int a, int b) {
        return a * 10 + b;
    }

    private int integer() {
        try {
            save();
            return zero();
        } catch (ParseFailure e1) {
            restore();
            int result = digitFirst();
            while(true) {
                try  {
                    save();
                    result = compute(result, digitRest());
                } catch (ParseFailure e2) {
                    restore();
                    return result;
                }
            }
        }
    }

    private int zero () {
        accept('0');
        return 0;
    }

    private int digitFirst() {
        return (acceptRange('1', '9') - '0');
    }

    private int digitRest() {
        return (acceptRange('0', '9') - '0');
    }


    @Override
    public Integer parse(String input) {
        this.input = input;
        this.position = 0;
        int result = integer();
        if(position != input.length()) {
            throw new ParseFailure("input remains: " + input.substring(position));
        } else {
            return result;
        }
    }
}
