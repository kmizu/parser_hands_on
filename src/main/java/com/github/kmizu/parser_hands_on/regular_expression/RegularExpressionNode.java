package com.github.kmizu.parser_hands_on.regular_expression;

/**
 * 正規表現の抽象構文木を表すクラス群
 */
public class RegularExpressionNode {
    public static class CharcterNode extends RegularExpressionNode {
        public final char ch;
        public CharcterNode(char ch) {
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
    public static class Repetition0Node extends RegularExpressionNode {
        public final RegularExpressionNode target;
        public Repetition0Node(RegularExpressionNode target) {
            this.target = target;
        }
    }
    public static class Repetition1Node extends RegularExpressionNode {
        public final RegularExpressionNode target;
        public Repetition1Node(RegularExpressionNode target) {
            this.target = target;
        }
    }
    public static class OptionNode extends RegularExpressionNode {
        public final RegularExpressionNode target;
        public OptionNode(RegularExpressionNode target) {
            this.target = target;
        }
    }
}
