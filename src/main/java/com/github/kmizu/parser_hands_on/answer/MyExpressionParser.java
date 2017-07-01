package com.github.kmizu.parser_hands_on.answer;

import com.github.kmizu.parser_hands_on.ParseFailure;
import com.github.kmizu.parser_hands_on.expression.AbstractExpressionParser;
import com.github.kmizu.parser_hands_on.expression.ExpressionNode;

/**
 *  算術式のパーザ
 *  - 1+2
 *  - 1-2
 *  - 1*2
 *  - 1/2
 *  - 1+2*3 ==> 1+(2*3)
 *  - (1+2)*3 ==> (1+2)*3
 *  - 1+2*3+4 ==> (1+(2*3))+4
 *  - (1+2)*(3+4)/(5+6) ==> ((1+2)*(3+4))/(5+6)
 */
public class MyExpressionParser extends AbstractExpressionParser {
    private String input;
    private int position;

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

    @Override
    public ExpressionNode parse(String input) {
        this.input = input;
        this.position = 0;
        ExpressionNode result = expression();
        if(this.position != input.length()) {
            throw new ParseFailure("unconsumed input remains: " + input.substring(position));
        } else {
            return result;
        }
    }

    // expression = additive;
    public ExpressionNode expression() {
        return additive();
    }

    // additive = multitive {'+' multitive | '-' multitive}
    public ExpressionNode additive() {
        // multitive
        ExpressionNode result = multitive();
        while(true) {
            int current = position;
            try {
                // '+' multitive
                accept('+');
                result = new ExpressionNode.Addition(result, multitive());
            } catch (ParseFailure e1) {
                position = current;
                try {
                    // '-' multitive
                    accept('-');
                    result = new ExpressionNode.Subtraction(result, multitive());
                } catch (ParseFailure e2) {
                    return result;
                }
            }
        }
    }

    // multitive = primary {'*' primary | '/' primary}
    public ExpressionNode multitive() {
        // primary
        ExpressionNode result = primary();
        while(true) {
            int current = position;
            try {
                // '*' primary
                accept('*');
                result = new ExpressionNode.Multiplication(result, primary());
            } catch (ParseFailure e1) {
                position = current;
                try {
                    // '/' primary
                    accept('/');
                    result = new ExpressionNode.Division(result, primary());
                } catch (ParseFailure e2) {
                    return result;
                }
            }
        }
    }

    // primary = '(' expression ')' | integer
    public ExpressionNode primary() {
        int current = position;
        try {
            // '(' expression ')'
            accept('(');
            ExpressionNode result = expression();
            accept(')');
            return result;
        } catch (ParseFailure e) {
            position = current;
            // integer
            return integer();
        }
    }

    public ExpressionNode integer() {
        int result = (acceptRange('0', '9') - '0');
        if(result == 0) {
            if(position >= input.length()){
                return new ExpressionNode.ValueNode(result);
            } else {
                char ch = input.charAt(position);
                if('0' <= ch && ch <= '9') {
                    throw new ParseFailure("if number starts with 0, it cannot be follow by any digit");
                }
                return new ExpressionNode.ValueNode(result);
            }
        }
        while(true) {
            try {
                result = result * 10 + (acceptRange('0', '9') - '0');
            } catch (ParseFailure e) {
                return new ExpressionNode.ValueNode(result);
            }
        }
    }
}
