package com.cucumber.test;

import cucumber.api.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pom.GitHubController;
import com.utility.WebDriverBrowser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.utility.Log;


public class GitHibStepDefinition {

    WebDriver driver;

    @Given("^I launch my a \"([^\"]*)\" browser$")
    public void iLaunchMyABrowser(String browser) {
        try {
            driver = WebDriverBrowser.getDriver(browser);
            Log.info("Browser launched");
        } catch (Exception e) {
            Log.info(e.getMessage());
            throw (e);
        }
    }

    @Given("^I navigate to the github website \"([^\"]*)\"$")
    public void iNavigateToTheGithubWebsite(String website) {
        try {
            driver.get(website);
            Log.info("Website launched");
        } catch (Exception e) {
            Log.info(e.getMessage());
            throw (e);
        }
    }

    @Then("^I should see the github homepage$")
    public void iShouldSeeTheGithubHomepage() {
        try {
            Assert.assertEquals("The world’s leading software development platform · GitHub", driver.getTitle());
            Log.info("GitHub Homepage Visible");
        } catch (Exception e) {
            Log.info(e.getMessage());
            throw (e);
        }
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iEnter(String data) {
        try {
            WebElement searchField = driver.findElement(GitHubController.enterSearchValue);
            searchField.sendKeys(data);
            WebElement search = driver.findElement(GitHubController.search);
            search.click();
            Log.info("Searching done");
        } catch (Exception e) {
            Log.info(e.getMessage());
            throw (e);
        }
    }

    @Then("^The search result should not be empty$")
    public void theSearchResultShouldNotBeEmpty() {
        try {
            Assert.assertNotEquals("We couldn’t find any repositories matching",
                    driver.findElement(GitHubController.searchResult).getText());
            Log.info("Searching result not returning an empty search");
        } catch (Exception e) {
            Log.info(e.getMessage());
            throw (e);
        }
    }

    @When("^I open the first result item$")
    public void iOpenTheFirstResultItem() {
        try {
            WebElement firstSearchItem = driver.findElement(GitHubController.firstSearchItem);
            firstSearchItem.click();
            Log.info("First result selected");
        } catch (Exception e) {
            Log.info(e.getMessage());
            throw (e);
        }
    }

    @And("^I open the the \"([^\"]*)\" file$")
    public void iOpenTheTheFile(String file) throws Throwable {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = null;
            if (file.equals("README.md")) {
                element = driver.findElement(GitHubController.readmeFile);
            }
            js.executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            Log.info("Readme file page opened");
        } catch (Exception e) {
            Log.info(e.getMessage());
            throw (e);
        }
    }

    @Then("^The title of the README.md page should be visible$")
    public void theTitleOfThePageShouldBeVisible() {
        try {
            String title = "webdriverio/README.md at master · webdriverio/webdriverio · GitHub";
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs(title));
            Assert.assertEquals(title, driver.getTitle());
            Log.info("README page title visible");

            Log.endTestCase();
            driver.quit();
        } catch (Exception e) {
            Log.info(e.getMessage());
            throw (e);
        }
    }
}
