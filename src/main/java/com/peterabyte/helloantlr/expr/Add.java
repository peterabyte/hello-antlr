package com.peterabyte.helloantlr.expr;

import com.peterabyte.helloantlr.context.ExpressionContext;

public class Add implements Expression {
    private final Expression left;
    private final Expression right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object exec(ExpressionContext context) {
        double leftNum = ExprUtil.toNumber(left.exec(context));
        double rightNum = ExprUtil.toNumber(right.exec(context));
        return leftNum + rightNum;
    }
}
