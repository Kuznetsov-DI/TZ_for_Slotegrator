package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CasinoPage {

    private final SelenideElement contentSection = $("#content");

    public CasinoPage openCasinoPage() {
        open("/configurator/dashboard/index");
        return page(CasinoPage.class);
    }

    @Step("Проверка, что секция с панелью администратора отображается")
    public CasinoPage contentShouldBeVisible() {
        contentSection.shouldBe(visible);
        return page(CasinoPage.class);
    }
}
