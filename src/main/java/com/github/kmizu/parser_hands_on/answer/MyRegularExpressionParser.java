package com.github.kmizu.parser_hands_on.answer;

import com.github.kmizu.parser_hands_on.ParseFailure;
import com.github.kmizu.parser_hands_on.regular_expression.AbstractRegularExpressionParser;
import com.github.kmizu.parser_hands_on.regular_expression.RegularExpressionNode;

import java.util.HashSet;
import java.util.Set;

public class MyRegularExpressionParser extends AbstractRegularExpressionParser {
    private Set<Character> metaCharacters = new HashSet<Character>() {{
        add('(');
        add(')');
        add('|');
        add('*');
    }};
    private String input;
    private int position;

    public char accept(char ch) {
        if(position < input.length() && input.charAt(position) == ch) {
            position++;
            return ch;
        }
        throw new ParseFailure("current position is over range or current character is not " + ch);
    }

    public char accept() {
        if(position < input.length()){
            char ch = input.charAt(position);
            if(!metaCharacters.contains(ch)) {
                position++;
                return ch;
            }
            throw new ParseFailure("unexpected meta character : " + ch);
        } else {
            throw new ParseFailure("unexpected EOF");
        }
    }

    @Override
    public RegularExpressionNode parse(String input) {
        this.input = input;
        this.position = 0;
        RegularExpressionNode result = regularExpression();
        if(this.position != input.length()) {
            throw new ParseFailure("unconsumed input remains: " + input.substring(position));
        } else {
            return result;
        }
    }

    public RegularExpressionNode regularExpression() {
        return alternative();
    }

    public RegularExpressionNode alternative() {
        RegularExpressionNode result = sequencable();
        while(true) {
            int current = position;
            try {
                accept('|');
                result = new RegularExpressionNode.ChoiceNode(result, sequencable());
            } catch (ParseFailure e1) {
                return result;
            }
        }
    }

    public RegularExpressionNode sequencable() {
        RegularExpressionNode result = repeatable();
        while(true) {
            int current = position;
            try {
                result = new RegularExpressionNode.SequenceNode(result, repeatable());
            } catch (ParseFailure e1) {
                return result;
            }
        }
    }

    public RegularExpressionNode repeatable() {
        RegularExpressionNode result = primary();
        int current = position;
        try {
            accept('*');
            return new RegularExpressionNode.RepetitionNode(result);
        } catch (ParseFailure e1) {
            return result;
        }
    }

    public RegularExpressionNode primary() {
        int current = position;
        try {
            accept('(');
            RegularExpressionNode result = regularExpression();
            accept(')');
            return result;
        } catch (ParseFailure e) {
            position = current;
            return character();
        }
    }

    public RegularExpressionNode character() {
        char ch = accept();
        return new RegularExpressionNode.CharacterNode(ch);
    }
}
