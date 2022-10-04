package service;

import config.ApiConfig;
import dto.request.ClientCredentialsGrantRequest;
import dto.request.OwnerPasswordCredentialsGrantRequest;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class AuthService extends ApiConfig {

    public static final String AUTH_TOKEN_PATH = "/v2/oauth2/token";

    @Step("Получение токена гостя (Client Credentials Grant, scope — {request.scope})")
    public ValidatableResponse postClientCredentialsGrant(ClientCredentialsGrantRequest request) {

        return given(getRequestSpecification())
                .auth()
                .preemptive()
                .basic(config.apiUser(), "")
                .when()
                .body(request)
                .post(AUTH_TOKEN_PATH)
                .then();
    }

    @Step("Получение токена игрока (Resource Owner Password Credentials Grant, username — {request.username})")
    public ValidatableResponse postResourceOwnerPasswordCredentialsGrant(OwnerPasswordCredentialsGrantRequest request) {

        return given(getRequestSpecification())
                .auth()
                .preemptive()
                .basic(config.apiUser(), "")
                .when()
                .body(request)
                .post(AUTH_TOKEN_PATH)
                .then();
    }
}
