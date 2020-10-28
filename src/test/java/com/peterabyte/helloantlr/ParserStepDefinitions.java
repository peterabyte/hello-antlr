package com.peterabyte.helloantlr;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ParserStepDefinitions {
    private String content;

    @Given("^calculator expressions$")
    public void given_calculator_expressions(String content) {
        this.content = content;
    }

    @Then("^calculator should return$")
    public void then_calculator_should_return(String content) throws IOException {
        try (Reader reader = new StringReader(content)) {
            CalculatorLexer lexer = new CalculatorLexer(new ANTLRInputStream(reader));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            CalculatorParser parser = new CalculatorParser(tokenStream);
            CalculatorParser.ExpressionsContext expressionsContext = parser.expressions();

        }
    }
}
