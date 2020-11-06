package com.peterabyte.helloantlr;

import com.peterabyte.helloantlr.context.ExpressionContext;
import com.peterabyte.helloantlr.context.ExpressionContextBuilder;
import com.peterabyte.helloantlr.expr.Expression;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserStepDefinitions {
    private String content;

    @Given("^calculator expressions$")
    public void given_calculator_expressions(String content) {
        this.content = content;
    }

    @Then("^calculator should return$")
    public void then_calculator_should_return(String expectedOutput) throws IOException {
        SpyPrintService spyPrintService = new SpyPrintService();
        ExpressionContext exprContext = ExpressionContextBuilder.create()
                .withPrintService(spyPrintService)
                .build();

        Expression expression = createCalculatorExpression(this.content);
        expression.exec(exprContext);

        assertThat(spyPrintService.getOutString()).isEqualTo(expectedOutput);
    }

    private Expression createCalculatorExpression(String content) throws IOException {
        try (Reader reader = new StringReader(this.content)) {
            CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromReader(reader));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CalculatorParser parser = new CalculatorParser(tokenStream);
            CalculatorParser.ExpressionsContext expressionsContext = parser.expressions();
            return expressionsContext.accept(new CalculatorExpressionVisitor());
        }
    }
}
