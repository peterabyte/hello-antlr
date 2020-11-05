package com.peterabyte.helloantlr;

public class AssignExpr extends AbstractCalculatorExpression {
    private final String name;
    private final CalculatorExpression value;

    public AssignExpr(String name, CalculatorExpression value) {
        this.name = name;
        this.value = value;
    }
}
