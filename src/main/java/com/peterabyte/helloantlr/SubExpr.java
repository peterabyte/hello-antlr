package com.peterabyte.helloantlr;

public class SubExpr extends AbstractCalculatorExpression {
    private final CalculatorExpression left;
    private final CalculatorExpression right;

    public SubExpr(CalculatorExpression left, CalculatorExpression right) {
        this.left = left;
        this.right = right;
    }
}
