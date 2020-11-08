package com.peterabyte.helloantlr.expr;

import com.peterabyte.helloantlr.context.ExpressionContext;

public class Abs implements Expression {
    private final Expression arg;

    public Abs(Expression arg) {
        this.arg = arg;
    }

    @Override
    public Object exec(ExpressionContext context) {
        Object val = arg.exec(context);
        return val != null ? Math.abs(ExprUtil.toNumber(val)) : null;
    }
}
