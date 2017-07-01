package com.github.kmizu.parser_hands_on.limited_expression;

/*
 * 算術式（制限あり）の抽象構文木を表すクラス群
 */
public class LimitedExpressionNode {
    public static LimitedExpressionNode add(int lhs, int rhs) {
        return new Addition(lhs, rhs);
    }
    public static LimitedExpressionNode sub(int lhs, int rhs) {
        return new Subtraction(lhs, rhs);
    }
    public static LimitedExpressionNode mul(int lhs, int rhs) {
        return new Multiplication(lhs, rhs);
    }
    public static LimitedExpressionNode div(int lhs, int rhs) {
        return new Division(lhs, rhs);
    }
    public static LimitedExpressionNode v(int value) {
        return new ValueNode(value);
    }
    public static class Addition extends LimitedExpressionNode {
        public final int lhs, rhs;
        public Addition(int lhs, int rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
        @Override
        public boolean equals(Object that) {
            if(!(that instanceof Addition)) return false;
            Addition addition = (Addition)that;
            return lhs == addition.lhs && rhs == addition.rhs;
        }

        @Override
        public String toString() {
            return "" + lhs + "+" + lhs;
        }
    }
    public static class Subtraction extends LimitedExpressionNode {
        public final int lhs, rhs;
        public Subtraction(int lhs, int rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
        @Override
        public boolean equals(Object that) {
            if(!(that instanceof Subtraction)) return false;
            Subtraction subtraction = (Subtraction)that;
            return lhs == subtraction.lhs && rhs == subtraction.rhs;
        }

        @Override
        public String toString() {
            return "" + lhs + "-" + lhs;
        }
    }
    public static class Multiplication extends LimitedExpressionNode {
        public final int lhs, rhs;
        public Multiplication(int lhs, int rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public boolean equals(Object that) {
            if(!(that instanceof Multiplication)) return false;
            Multiplication multiplication = (Multiplication) that;
            return lhs == multiplication.lhs && rhs == multiplication.rhs;
        }

        @Override
        public String toString() {
            return "" + lhs + "*" + lhs;
        }
    }
    public static class Division extends LimitedExpressionNode {
        public final int lhs, rhs;
        public Division(int lhs, int rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public boolean equals(Object that) {
            if(!(that instanceof Division)) return false;
            Division division = (Division) that;
            return lhs == division.lhs && rhs == division.rhs;
        }

        @Override
        public String toString() {
            return "" + lhs + "/" + lhs;
        }
    }
    public static class ValueNode extends LimitedExpressionNode {
        public final int value;
        public ValueNode(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object that) {
            if(!(that instanceof ValueNode)) return false;
            ValueNode node = (ValueNode) that;
            return value == node.value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
}
