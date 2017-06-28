package com.github.kmizu.parser_hands_on.regular_expression;

/**
 * 正規表現の抽象構文木を表すクラス群
 */
public class RegularExpressionNode {
    public static class CharacterNode extends RegularExpressionNode {
        public final char ch;
        public CharacterNode(char ch) {
            this.ch = ch;
        }
    }
    public static class SequenceNode extends RegularExpressionNode {
        public final RegularExpressionNode lhs, rhs;
        public SequenceNode(RegularExpressionNode lhs, RegularExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public static class ChoiceNode extends RegularExpressionNode {
        public final RegularExpressionNode lhs, rhs;
        public ChoiceNode(RegularExpressionNode lhs, RegularExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public static class RepetitionNode extends RegularExpressionNode {
        public final RegularExpressionNode target;
        public RepetitionNode(RegularExpressionNode target) {
            this.target = target;
        }
    }

    public RepetitionNode repeat() {
        return new RepetitionNode(this);
    }

    public CharacterNode ch(char value) {
        return new CharacterNode(value);
    }

    public ChoiceNode or(RegularExpressionNode rhs) {
        return new ChoiceNode(this, rhs);
    }

    public ChoiceNode or(char rhs) {
        return new ChoiceNode(this, new CharacterNode(rhs));
    }

    public SequenceNode next(RegularExpressionNode rhs){
        return new SequenceNode(this, rhs);
    }

    public SequenceNode next(char rhs){
        return new SequenceNode(this, new CharacterNode(rhs));
    }
}
