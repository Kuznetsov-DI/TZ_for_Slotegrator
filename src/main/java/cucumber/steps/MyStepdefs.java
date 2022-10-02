package cucumber.steps;

import config.BaseConfig;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import page.CasinoPage;
import page.LoginPage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class MyStepdefs {

    private WebDriver driver;
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    @When("Open casino login page")
    public void OpenCasinoLoginPage() {
        System.setProperty(config.driverProperty(), config.driverPath());
        driver = new ChromeDriver();
        driver.get(config.uiUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("Authorization like admin")
    public void authorizationLikeAdmin() {
        new LoginPage(driver)
                .inputLogin(config.uiLogin())
                .inputPassword(config.uiPassword())
                .clickSignInButton();

        assertTrue(new CasinoPage(driver).contentIsVisible(), "Панель администратора не отображается");
    }

}
