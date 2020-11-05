package com.peterabyte.helloantlr;

public class AddExpr extends AbstractCalculatorExpression {
    private final CalculatorExpression left;
    private final CalculatorExpression right;

    public AddExpr(CalculatorExpression left, CalculatorExpression right) {
        this.left = left;
        this.right = right;
    }
}
