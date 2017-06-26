package com.github.kmizu.parser_hands_on.expression;

/*
 * 算術式の抽象構文木を表すクラス群
 */
public class ExpressionNode {
    public class Addition extends ExpressionNode {
        public final ExpressionNode lhs, rhs;
        public Addition(ExpressionNode lhs, ExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public class Subtraction extends ExpressionNode {
        public final ExpressionNode lhs, rhs;
        public Subtraction(ExpressionNode lhs, ExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public class Multiplication extends ExpressionNode {
        public final ExpressionNode lhs, rhs;
        public Multiplication(ExpressionNode lhs, ExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public class Division extends ExpressionNode {
        public final ExpressionNode lhs, rhs;
        public Division(ExpressionNode lhs, ExpressionNode rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }
    }
    public class ValueNode extends ExpressionNode {
        public final int value;
        public ValueNode(int value ) {
            this.value = value;
        }
    }
}
