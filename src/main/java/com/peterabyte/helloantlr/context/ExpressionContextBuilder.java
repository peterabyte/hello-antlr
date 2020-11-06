package com.peterabyte.helloantlr.context;

public class ExpressionContextBuilder {
    private PrintService printService = new DefaultPrintService();

    public static ExpressionContextBuilder create() {
        return new ExpressionContextBuilder();
    }

    public ExpressionContext build() {
        return new DefaultExpressionContext(printService);
    }

    public ExpressionContextBuilder withPrintService(PrintService printService) {
        this.printService = printService;
        return this;
    }
}
