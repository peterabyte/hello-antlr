package com.peterabyte.helloantlr.context;

public interface ExpressionContext {
    void putVariable(String name, Object val);

    Object getVariable(String name);

    PrintService getPrintService();
}
