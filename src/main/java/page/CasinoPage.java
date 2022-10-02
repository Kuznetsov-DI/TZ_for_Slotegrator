package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CasinoPage {

    private final WebDriver driver;

    @FindBy(id = "content")
    private WebElement contentSection;

    @FindBy(xpath = "//section[@id='content']//div[@class='col-lg-3 col-xsm-6'][3]")
    private WebElement playersButton;

    public CasinoPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Проверка, что секция с панелью администратора отображается")
    public boolean contentIsVisible() {
        return contentSection.isDisplayed();
    }

    @Step("Нажатие на кнопку \"Players\"")
    public CasinoPage clickPlayersButton() {
        playersButton.click();
        return this;
    }
}
