package com.choucair.reto.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
 
    features = "src/test/resources/features/",
    glue = "com.choucair.reto.stepdefinitions", // Sin el tag @Compra para que corra todo
    plugin = {"pretty"},
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RegistroRunner {
}
