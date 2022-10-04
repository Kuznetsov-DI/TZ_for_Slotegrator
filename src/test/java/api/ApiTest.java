package api;

import dto.request.PlayerCreationRequest;
import dto.response.PlayerResponse;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import service.PlayerService;

import static io.qameta.allure.Allure.step;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.AuthHelper.getGuestBearerToken;
import static utils.AuthHelper.getPlayerBearerToken;
import static utils.ExpectedDataBuilder.getPlayerCreationResponseByRequest;
import static utils.TestObjectBuilder.getRandomPlayerCreationRequest;

public class ApiTest {

    private final SoftAssert softAssert = new SoftAssert();
    private final PlayerService playerService = new PlayerService();

    @Test
    public void testApi() {

        String guestToken = getGuestBearerToken();

        PlayerCreationRequest playerCreationRequest = getRandomPlayerCreationRequest();
        PlayerResponse actualPlayerAfterCreate = playerService.postNewPlayerCreation(playerCreationRequest, guestToken)
                .statusCode(SC_CREATED).extract().as(PlayerResponse.class);

        PlayerResponse expectedPlayerAfterCreate = getPlayerCreationResponseByRequest(playerCreationRequest);

        step("Проверка тела ответа созданного нового игрока", () -> {
            softAssert.assertNotNull(actualPlayerAfterCreate.getId(), "Идентификатор нового игрока равен null");
            softAssert.assertEquals(actualPlayerAfterCreate, expectedPlayerAfterCreate, "Тело ответа не совпадает с параметрами запроса");
            softAssert.assertAll();
        });

        String playerToken = getPlayerBearerToken(playerCreationRequest.getUsername(), playerCreationRequest.getPasswordChange());

        PlayerResponse actualPlayerById = playerService.getPlayerDataById(actualPlayerAfterCreate.getId(), playerToken)
                .statusCode(SC_OK).extract().as(PlayerResponse.class);

        step("Проверка тела ответа после запроса данных профиля игрока", () -> {
            softAssert.assertEquals(actualPlayerById.getId(), actualPlayerAfterCreate.getId(), "Идентификатор игрока не совпадает с ранее созданным");
            softAssert.assertEquals(actualPlayerById, actualPlayerAfterCreate, "Тело ответа не совпадает с параметрами созданного лида");
            softAssert.assertAll();
        });

        playerService.getPlayerDataById(actualPlayerAfterCreate.getId() - 1, playerToken).statusCode(SC_NOT_FOUND);
    }
}
