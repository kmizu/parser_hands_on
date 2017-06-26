package com.github.kmizu.parser_hands_on;

public interface AbstractParser<T> {
    T parse(String input);
}
