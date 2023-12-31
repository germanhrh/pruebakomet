package com.komet.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.komet.stepsdefinitions",
        features = "src\\test\\resources\\com.komet.features/get_komet.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class GetKomet {
}
