package com.peterabyte.helloantlr.expr;

import com.peterabyte.helloantlr.context.ExpressionContext;

import java.util.List;

public class Min implements Expression {
    private final List<Expression> args;

    public Min(List<Expression> args) {
        this.args = args;
    }

    @Override
    public Object exec(ExpressionContext context) {
        Double min = null;
        for (Expression argExpr : args) {
            Object val = argExpr.exec(context);
            if (val != null) {
                Double num = ExprUtil.toNumber(val);
                if (min == null) {
                    min = num;
                } else if (min > num) {
                    min = num;
                }
            }
        }
        return min;
    }
}
