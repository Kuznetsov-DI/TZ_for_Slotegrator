package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayersPage {

    private final WebDriver driver;

    @FindBy(id = "payment-system-transaction-grid")
    private WebElement playersTable;

    public PlayersPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка, таблица с игроками отображается")
    public boolean playersTableIsVisible() {
        return playersTable.isDisplayed();
    }
}
