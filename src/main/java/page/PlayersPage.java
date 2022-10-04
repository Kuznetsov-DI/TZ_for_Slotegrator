package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PlayersPage {

    private final SelenideElement playersTable = $("#payment-system-transaction-grid");
    private final SelenideElement registrationSortButton = $("#payment-system-transaction-grid_c9");
    private final ElementsCollection registrationDateList = $$(By.xpath("//tbody/tr/td[10]"));

    public PlayersPage openPlayersPage() {
        open("/user/player/admin");
        return page(PlayersPage.class);
    }

    @Step("Проверка, таблица с игроками отображается")
    public PlayersPage playersTableShouldBeVisible() {
        playersTable.shouldBe(visible);
        return page(PlayersPage.class);
    }

    @Step("Нажатие на кнопку сортировки по дате регистрации")
    public PlayersPage clickSortByRegistrationDate() {
        registrationSortButton.click();
        playersTable.shouldNotHave(attribute("class","grid-view grid-view-loading"));
        return page(PlayersPage.class);
    }

    @Step("Проверка сортировки таблицы по датам регистрации")
    public boolean checkSortRegistrationDateList() {
        List<String> list = registrationDateList.texts();
        list.sort(Comparator.naturalOrder());

        return list.equals(registrationDateList.texts());
    }
}
