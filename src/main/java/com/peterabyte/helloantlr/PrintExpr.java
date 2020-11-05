package com.peterabyte.helloantlr;

import java.util.List;

public class PrintExpr extends AbstractCalculatorExpression {
    private final List<CalculatorExpression> args;

    public PrintExpr(List<CalculatorExpression> args) {
        this.args = args;
    }
}
