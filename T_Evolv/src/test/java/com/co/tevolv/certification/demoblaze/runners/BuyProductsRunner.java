package com.co.tevolv.certification.demoblaze.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/BuyProducts.feature",
                glue = "com.co.tevolv.certification.demoblaze.stepsdefinition",snippets = SnippetType.CAMELCASE,
                    dryRun = false)
public class BuyProductsRunner {
}
