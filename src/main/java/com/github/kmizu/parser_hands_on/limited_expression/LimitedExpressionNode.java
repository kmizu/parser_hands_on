package com.github.kmizu.parser_hands_on.limited_expression;

/*
 * 算術式（制限あり）の抽象構文木を表すクラス群
 */
public class LimitedExpressionNode {
    public static class Addition extends LimitedExpressionNode {
        public final Integer lhs, rhs;
        public Addition(Integer lhs, Integer rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public static class Subtraction extends LimitedExpressionNode {
        public final Integer lhs, rhs;
        public Subtraction(Integer lhs, Integer rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public static class Multiplication extends LimitedExpressionNode {
        public final Integer lhs, rhs;
        public Multiplication(Integer lhs, Integer rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public static class Division extends LimitedExpressionNode {
        public final Integer lhs, rhs;
        public Division(Integer lhs, Integer rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
}
