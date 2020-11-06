package com.peterabyte.helloantlr.expr;

import com.peterabyte.helloantlr.context.ExpressionContext;

public class Number implements Expression {
    private final double number;

    public Number(double number) {
        this.number = number;
    }

    @Override
    public Object exec(ExpressionContext context) {
        return number;
    }
}
