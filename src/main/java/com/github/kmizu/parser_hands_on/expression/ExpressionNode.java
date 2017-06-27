package com.github.kmizu.parser_hands_on.expression;

/*
 * 算術式の抽象構文木を表すクラス群
 */
public class ExpressionNode {
    public ExpressionNode add(ExpressionNode that) {
        return new Addition(this, that);
    }
    public ExpressionNode subtract(ExpressionNode that) {
        return new Subtraction(this, that);
    }
    public ExpressionNode multiply(ExpressionNode that) {
        return new Multiplication(this, that);
    }
    public ExpressionNode divide(ExpressionNode that) {
        return new Division(this, that);
    }
    public static class Addition extends ExpressionNode {
        public final ExpressionNode lhs, rhs;
        public Addition(ExpressionNode lhs, ExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public boolean equals(Object that) {
            if(!(that instanceof Addition)) return false;
            Addition addition = (Addition)that;
            return lhs.equals(addition.lhs) && rhs.equals(addition.rhs);
        }

        @Override
        public String toString() {
            return "Addition(" + lhs + ", " + rhs + ")";
        }
    }
    public static class Subtraction extends ExpressionNode {
        public final ExpressionNode lhs, rhs;
        public Subtraction(ExpressionNode lhs, ExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public boolean equals(Object that) {
            if(!(that instanceof Subtraction)) return false;
            Subtraction subtraction = (Subtraction)that;
            return lhs.equals(subtraction.lhs) && rhs.equals(subtraction.rhs);
        }

        @Override
        public String toString() {
            return "Subtraction(" + lhs + ", " + rhs + ")";
        }
    }
    public static class Multiplication extends ExpressionNode {
        public final ExpressionNode lhs, rhs;
        public Multiplication(ExpressionNode lhs, ExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public boolean equals(Object that) {
            if(!(that instanceof Multiplication)) return false;
            Multiplication multiplication = (Multiplication)that;
            return lhs.equals(multiplication.lhs) && rhs.equals(multiplication.rhs);
        }

        @Override
        public String toString() {
            return "Multiplication(" + lhs + ", " + rhs + ")";
        }
    }
    public static class Division extends ExpressionNode {
        public final ExpressionNode lhs, rhs;
        public Division(ExpressionNode lhs, ExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        @Override
        public boolean equals(Object that) {
            if(!(that instanceof Division)) return false;
            Division division = (Division) that;
            return lhs.equals(division.lhs) && rhs.equals(division.rhs);
        }

        @Override
        public String toString() {
            return "Division(" + lhs + ", " + rhs + ")";
        }
    }
    public static class ValueNode extends ExpressionNode {
        public final int value;
        public ValueNode(int value ) {
            this.value = value;
        }

        @Override
        public boolean equals(Object that) {
            if(that == null) return false;
            if(!(that instanceof ValueNode)) return false;
            ValueNode thatNode = (ValueNode)that;
            return this.value == thatNode.value;
        }

        @Override
        public int hashCode() {
            return value;
        }

        @Override
        public String toString() {
            return "ValueNode(" + value + ")";
        }
    }

    public static ValueNode integer(int value) {
        return new ValueNode(value);
    }
}
