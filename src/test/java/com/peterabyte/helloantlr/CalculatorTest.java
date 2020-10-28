package com.peterabyte.helloantlr;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty",
        },
        glue = { "com.peterabyte.helloantlr" }
)
public class CalculatorTest {
}

