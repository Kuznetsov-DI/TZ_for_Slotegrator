package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(id = "UserLogin_username")
    private WebElement loginInput;

    @FindBy(id = "UserLogin_password")
    private WebElement passwordInput;

    @FindBy(css = "input[value='Sign in']")
    private WebElement signInButton;

    public LoginPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Ввод логина {login}")
    public LoginPage inputLogin(String login){
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Ввод пароля")
    public LoginPage inputPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку \"Sign in\"")
    public CasinoPage clickSignInButton(){
        signInButton.click();
        return new CasinoPage(driver);
    }
}
