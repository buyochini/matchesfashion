package com.cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/test/github.feature", glue = "com.cucumber.test", tags = {
        "@test" }, monochrome = true, plugin = { "pretty", "html:target/cucumber", })
public class runTest {
}