package com.runner;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.CucumberOptions;
import courgette.api.testng.TestNGCourgette;
import org.testng.annotations.Test;

@Test
    @CourgetteOptions(
            threads = 2,
            runLevel = CourgetteRunLevel.FEATURE,
            rerunFailedScenarios = true,
            rerunAttempts = 1,
            showTestOutput = true,
            reportTargetDir = "build",
            cucumberOptions = @CucumberOptions(
                    features = {"src/test/resources/Features"},
                    glue = {"com.ui.stepdefinitions"},
                    tags = {"@parallel"},
                    plugin = {
                            "json:build/cucumber-report/cucumber.json",
                            "html:build/cucumber-report/cucumber.html"},
                    strict = true
            ))
    public class TestCourgetteRunner extends TestNGCourgette {
    }

