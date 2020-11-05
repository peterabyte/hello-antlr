package com.peterabyte.helloantlr;

public class IdExpr extends AbstractCalculatorExpression {
    private final String name;

    public IdExpr(String name) {
        this.name = name;
    }
}
