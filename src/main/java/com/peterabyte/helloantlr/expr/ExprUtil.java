package com.peterabyte.helloantlr.expr;

public class ExprUtil {
    public static Double toNumber(Object num) {
        Double result;
        if (num instanceof Double) {
            result = (Double) num;
        } else if (num == null) {
            result = 0D;
        } else {
            try {
                result = Double.parseDouble(num.toString());
            } catch (NumberFormatException ex) {
                throw new ExpressionException(String.format("Failed to convert string '%s' to number", num), ex);
            }
        }
        return result;
    }
}
