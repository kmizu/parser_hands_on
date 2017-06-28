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

        @Override
        public boolean equals(Object that) {
            if(that instanceof CharacterNode) {
                return ch == ((CharacterNode)that).ch;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "" + ch;
        }
    }
    public static class SequenceNode extends RegularExpressionNode {
        public final RegularExpressionNode lhs, rhs;
        public SequenceNode(RegularExpressionNode lhs, RegularExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public boolean equals(Object that) {
            if(that instanceof SequenceNode) {
                SequenceNode seq = (SequenceNode)that;
                return lhs.equals(seq.lhs) && rhs.equals(seq.rhs);
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "(" + (lhs.toString() + rhs.toString()) + ")";
        }
    }
    public static class ChoiceNode extends RegularExpressionNode {
        public final RegularExpressionNode lhs, rhs;
        public ChoiceNode(RegularExpressionNode lhs, RegularExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public boolean equals(Object that) {
            if(that instanceof ChoiceNode) {
                ChoiceNode choice = (ChoiceNode)that;
                return lhs.equals(choice.lhs) && rhs.equals(choice.rhs);
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "(" + lhs.toString() + "|" + rhs.toString() +  ")";
        }
    }
    public static class RepetitionNode extends RegularExpressionNode {
        public final RegularExpressionNode target;
        public RepetitionNode(RegularExpressionNode target) {
            this.target = target;
        }

        @Override
        public boolean equals(Object that) {
            if(that instanceof RepetitionNode) {
                RepetitionNode repetition = (RepetitionNode)that;
                return target.equals(repetition.target);
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "(" + target + "*" + ")";
        }
    }

    public RepetitionNode repeat() {
        return new RepetitionNode(this);
    }

    public static CharacterNode ch(char value) {
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
