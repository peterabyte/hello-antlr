package com.peterabyte.helloantlr.context;

import java.util.HashMap;
import java.util.Map;

public class DefaultExpressionContext implements ExpressionContext {
    private final PrintService printService;
    private final Map<String, Object> variables;

    DefaultExpressionContext(PrintService printService) {
        this.printService = printService;
        this.variables = new HashMap<>();
    }

    @Override
    public void putVariable(String name, Object val) {
        variables.put(name, val);
    }

    @Override
    public Object getVariable(String name) {
        return variables.get(name);
    }

    @Override
    public PrintService getPrintService() {
        return printService;
    }
}
