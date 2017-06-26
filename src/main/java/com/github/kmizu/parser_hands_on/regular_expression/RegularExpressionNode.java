package com.github.kmizu.parser_hands_on.regular_expression;

/**
 * 正規表現の抽象構文木を表すクラス群
 */
public class RegularExpressionNode {
    public static class One extends RegularExpressionNode {
        public final char ch;
        public One(char ch) {
            this.ch = ch;
        }
    }
    public static class Sequence extends RegularExpressionNode {
        public final RegularExpressionNode lhs, rhs;
        public Sequence(RegularExpressionNode lhs, RegularExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public static class Choice extends RegularExpressionNode {
        public final RegularExpressionNode lhs, rhs;
        public Choice(RegularExpressionNode lhs, RegularExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public static class Repetition extends RegularExpressionNode {
        public final RegularExpressionNode target;
        public Repetition(RegularExpressionNode target) {
            this.target = target;
        }
    }
}
