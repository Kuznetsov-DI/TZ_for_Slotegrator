package service;

import config.ApiConfig;
import constant.HeaderParameters;
import dto.request.PlayerCreationRequest;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class PlayerService extends ApiConfig {

    public static final String PLAYERS_PATH = "/v2/players";

    @Step("Регистрация нового игрока с именем пользователя - {request.username}")
    public ValidatableResponse postNewPlayerCreation(PlayerCreationRequest request, String token) {

        return given(getRequestSpecification())
                .header(HeaderParameters.AUTH_KEY_PARAM,token)
                .when()
                .body(request)
                .post(PLAYERS_PATH)
                .then()
                .log().all();
    }
}
