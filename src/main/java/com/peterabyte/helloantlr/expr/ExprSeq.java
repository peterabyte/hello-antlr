package com.peterabyte.helloantlr.expr;

import com.peterabyte.helloantlr.context.ExpressionContext;

import java.util.List;

public class ExprSeq implements Expression {
    private final List<Expression> expressions;

    public ExprSeq(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public Object exec(ExpressionContext context) {
        for (Expression expr : expressions) {
            expr.exec(context);
        }
        return null;
    }
}
