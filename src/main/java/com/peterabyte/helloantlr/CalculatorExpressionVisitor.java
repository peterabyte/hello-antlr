package com.peterabyte.helloantlr;

import java.util.ArrayList;
import java.util.List;

public class CalculatorExpressionVisitor extends CalculatorBaseVisitor<CalculatorExpression> {
    @Override
    public CalculatorExpression visitExpressions(CalculatorParser.ExpressionsContext ctx) {
        List<CalculatorExpression> expressions = new ArrayList<>();
        for (CalculatorParser.ExprContext exprCtx :ctx.expr()) {
            expressions.add(visit(exprCtx));
        }
        return new ExprSeq(expressions);
    }

    @Override
    public CalculatorExpression visitBinaryExpr(CalculatorParser.BinaryExprContext ctx) {
        switch (ctx.op.getType()) {
            case CalculatorParser.ADD:
                return new AddExpr(visit(ctx.left), visit(ctx.right));
            case CalculatorParser.SUB:
                return new SubExpr(visit(ctx.left), visit(ctx.right));
            default:
                throw new CalculatorParserException("Failed to create binary expression! Unsupported binary operation: " + ctx);
        }
    }

    @Override
    public CalculatorExpression visitNumberExpr(CalculatorParser.NumberExprContext ctx) {
        try {
            double number = Double.parseDouble(ctx.NUMBER().getText());
            return new NumberExpr(number);
        } catch (NumberFormatException ex) {
            throw new CalculatorParserException("Failed to read number! " + ctx, ex);
        }
    }

    @Override
    public CalculatorExpression visitIdExpr(CalculatorParser.IdExprContext ctx) {
        return new IdExpr(ctx.IDENTIFIER().getText());
    }

    @Override
    public CalculatorExpression visitAssignExpr(CalculatorParser.AssignExprContext ctx) {
        return new AssignExpr(ctx.IDENTIFIER().getText(), visit(ctx.value));
    }

    @Override
    public CalculatorExpression visitFunctionExpr(CalculatorParser.FunctionExprContext ctx) {
        List<CalculatorExpression> args = new ArrayList<>();
        for (CalculatorParser.ExprContext exprContext : ctx.args) {
            args.add(visit(exprContext));
        }
        switch (ctx.name.getType()) {
            case CalculatorParser.PRINT:
                return new PrintExpr(args);
            default:
                throw new CalculatorParserException("Failed to create calculator function! " + ctx);
        }
    }
}
