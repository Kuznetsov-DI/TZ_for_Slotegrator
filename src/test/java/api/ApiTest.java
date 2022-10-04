package api;

import dto.request.PlayerCreationRequest;
import dto.response.PlayerCreationResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import service.PlayerService;

import static io.qameta.allure.Allure.step;
import static org.apache.http.HttpStatus.SC_CREATED;
import static utils.AuthHelper.getGuestBearerToken;
import static utils.ExpectedDataBuilder.getPlayerCreationResponseByRequest;
import static utils.TestObjectBuilder.getRandomPlayerCreationRequest;

public class ApiTest {

    private final SoftAssert softAssert = new SoftAssert();
    private final PlayerService playerService = new PlayerService();

    @Test
    public void testApi() {

        String token = getGuestBearerToken();

        PlayerCreationRequest playerCreationRequest = getRandomPlayerCreationRequest();
        PlayerCreationResponse actualPlayerAfterCreate = playerService.postNewPlayerCreation(playerCreationRequest, token)
                .statusCode(SC_CREATED).extract().as(PlayerCreationResponse.class);

        PlayerCreationResponse expectedPlayerAfterCreate = getPlayerCreationResponseByRequest(playerCreationRequest);

        step("Проверка тела ответа созданного нового игрока", () -> {
            softAssert.assertNotNull(actualPlayerAfterCreate.getId(), "Идентификатор нового игрока равен null");
            softAssert.assertEquals(actualPlayerAfterCreate, expectedPlayerAfterCreate, "Тело ответа не совпадает с параметрами запроса");
            softAssert.assertAll();
        });
    }

}
