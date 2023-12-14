package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    private WebDriver driver;

    @When("User launch url")
    public void userLaunchUrl() {
        driver= new ChromeDriver();
    }
    @And("User enters credentials")
    public void userEntersCredentials() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("^User should land on home page$")
    public void userShouldLandOnHomePage() {
        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
        Assert.assertEquals(title,"Swag Labs");
    }

    @Then("User should quit browser")
    public void userShouldQuitBrowser() {
        driver.quit();
    }
}
