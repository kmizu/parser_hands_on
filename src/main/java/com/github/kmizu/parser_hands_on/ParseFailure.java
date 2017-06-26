package com.github.kmizu.parser_hands_on;

/**
 * 構文解析の失敗時に投げられることを想定した例外。
 * 各種 AbstractParser を継承したパーザは構文解析に失敗した場合、
 * これをthrow 「しなければならない」
 */
public class ParseFailure extends RuntimeException {
    public ParseFailure(String message) {
        super("ParseException: " + message);
    }
}
