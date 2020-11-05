package com.peterabyte.helloantlr;

public class CalculatorParserException extends RuntimeException {
    public CalculatorParserException(String message) {
        super(message);
    }

    public CalculatorParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
