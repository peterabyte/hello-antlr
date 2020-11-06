package com.peterabyte.helloantlr.expr;

import com.peterabyte.helloantlr.context.ExpressionContext;

public interface Expression {
    Object exec(ExpressionContext context);
}
