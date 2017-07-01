package com.github.kmizu.parser_hands_on;

import java.util.Stack;

public abstract class AbstractParser<T> {
    protected int position;
    protected Stack<Integer> stack = new Stack<>();
    public void save() {
        stack.push(position);
    }
    public void restore() {
        position = stack.pop();
    }
    public abstract T parse(String input);
}
