package com.peterabyte.helloantlr.expr;

import com.peterabyte.helloantlr.context.ExpressionContext;

public class Assign implements Expression {
    private final String name;
    private final Expression valueExpr;

    public Assign(String name, Expression valueExpr) {
        this.name = name;
        this.valueExpr = valueExpr;
    }

    @Override
    public Object exec(ExpressionContext context) {
        Object val = valueExpr.exec(context);
        context.putVariable(name, val);
        return val;
    }
}
