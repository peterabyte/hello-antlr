package com.peterabyte.helloantlr;

import java.util.List;

public class ExprSeq extends AbstractCalculatorExpression {
    private final List<CalculatorExpression> expressions;

    public ExprSeq(List<CalculatorExpression> expressions) {
        this.expressions = expressions;
    }
}
