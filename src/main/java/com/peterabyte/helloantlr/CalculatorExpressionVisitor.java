package com.peterabyte.helloantlr;

import com.peterabyte.helloantlr.expr.Add;
import com.peterabyte.helloantlr.expr.Assign;
import com.peterabyte.helloantlr.expr.Expression;
import com.peterabyte.helloantlr.expr.ExprSeq;
import com.peterabyte.helloantlr.expr.Variable;
import com.peterabyte.helloantlr.expr.Number;
import com.peterabyte.helloantlr.expr.Print;
import com.peterabyte.helloantlr.expr.Sub;

import java.util.ArrayList;
import java.util.List;

public class CalculatorExpressionVisitor extends CalculatorBaseVisitor<Expression> {
    @Override
    public Expression visitExpressions(CalculatorParser.ExpressionsContext ctx) {
        List<Expression> expressions = new ArrayList<>();
        for (CalculatorParser.ExprContext exprCtx :ctx.expr()) {
            expressions.add(visit(exprCtx));
        }
        return new ExprSeq(expressions);
    }

    @Override
    public Expression visitBinaryExpr(CalculatorParser.BinaryExprContext ctx) {
        switch (ctx.op.getType()) {
            case CalculatorParser.ADD:
                return new Add(visit(ctx.left), visit(ctx.right));
            case CalculatorParser.SUB:
                return new Sub(visit(ctx.left), visit(ctx.right));
            default:
                throw new CalculatorParserException("Failed to create binary expression! Unsupported binary operation: " + ctx);
        }
    }

    @Override
    public Expression visitNumberExpr(CalculatorParser.NumberExprContext ctx) {
        try {
            double number = Double.parseDouble(ctx.NUMBER().getText());
            return new Number(number);
        } catch (NumberFormatException ex) {
            throw new CalculatorParserException("Failed to read number! " + ctx, ex);
        }
    }

    @Override
    public Expression visitIdExpr(CalculatorParser.IdExprContext ctx) {
        return new Variable(ctx.IDENTIFIER().getText());
    }

    @Override
    public Expression visitAssignExpr(CalculatorParser.AssignExprContext ctx) {
        return new Assign(ctx.IDENTIFIER().getText(), visit(ctx.value));
    }

    @Override
    public Expression visitFunctionExpr(CalculatorParser.FunctionExprContext ctx) {
        List<Expression> args = new ArrayList<>();
        for (CalculatorParser.ExprContext exprContext : ctx.args) {
            args.add(visit(exprContext));
        }
        switch (ctx.name.getType()) {
            case CalculatorParser.PRINT:
                return new Print(args);
            default:
                throw new CalculatorParserException("Failed to create calculator function! " + ctx);
        }
    }
}
