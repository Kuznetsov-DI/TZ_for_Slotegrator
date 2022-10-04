package cucumber.steps;

import com.codeborne.selenide.Configuration;
import config.BaseConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.aeonbits.owner.ConfigFactory;
import page.LoginPage;
import page.PlayersPage;

import static org.testng.Assert.assertTrue;

public class CasinoSteps {

    private final LoginPage loginPage = new LoginPage();
    private final PlayersPage playersPage = new PlayersPage();
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    @Before
    public void setUp() {
        Configuration.baseUrl = config.uiUrl();
        Configuration.browserSize = config.browserSize();
    }

    @Then("Authorization like admin")
    public void authorizationLikeAdmin() {
        loginPage.openLoginPage()
                .inputLogin(config.uiLogin())
                .inputPassword(config.uiPassword())
                .clickSignInButton()
                .contentShouldBeVisible();
    }

    @And("Open player list")
    public void openPlayerList() {
        playersPage.openPlayersPage()
                .playersTableShouldBeVisible();
    }

    @Then("Sort by any field")
    public void sortByAnyField() {
        playersPage.clickSortByRegistrationDate();

        assertTrue(playersPage.checkSortRegistrationDateList(), "Список не был отсортирован");
    }
}
