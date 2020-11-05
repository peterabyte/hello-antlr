package com.peterabyte.helloantlr;

public class NumberExpr extends AbstractCalculatorExpression {
    private final double number;

    public NumberExpr(double number) {
        this.number = number;
    }
}
