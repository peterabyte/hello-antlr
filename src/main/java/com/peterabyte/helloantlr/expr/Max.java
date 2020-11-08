package com.peterabyte.helloantlr.expr;

import com.peterabyte.helloantlr.context.ExpressionContext;

import java.util.List;

public class Max implements Expression {
    private final List<Expression> args;

    public Max(List<Expression> args) {
        this.args = args;
    }

    @Override
    public Object exec(ExpressionContext context) {
        Double max = null;
        for (Expression argExpr : args) {
            Object val = argExpr.exec(context);
            if (val != null) {
                Double num = ExprUtil.toNumber(val);
                if (max == null) {
                    max = num;
                } else if (max < num) {
                    max = num;
                }
            }
        }
        return max;
    }
}
