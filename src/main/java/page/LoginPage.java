package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private final SelenideElement loginInput = $("#UserLogin_username");
    private final SelenideElement passwordInput = $("#UserLogin_password");

    private final SelenideElement signInButton = $("input[value='Sign in']");

    public LoginPage openLoginPage() {
        open("/admin/login");
        return page(LoginPage.class);
    }

    @Step("Ввод логина {login}")
    public LoginPage inputLogin(String login) {
        loginInput.sendKeys(login);
        return page(LoginPage.class);
    }

    @Step("Ввод пароля")
    public LoginPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        return page(LoginPage.class);
    }

    @Step("Клик на кнопку \"Sign in\"")
    public CasinoPage clickSignInButton() {
        signInButton.click();
        return new CasinoPage();
    }
}
