package utils;

import dto.request.ClientCredentialsGrantRequest;
import dto.request.OwnerPasswordCredentialsGrantRequest;
import dto.response.TokenResponse;
import lombok.experimental.UtilityClass;
import service.AuthService;

import static org.apache.http.HttpStatus.SC_OK;

@UtilityClass
public class AuthHelper {

    public static String getGuestBearerToken() {
        ClientCredentialsGrantRequest request = ClientCredentialsGrantRequest.builder().build();

        TokenResponse response = new AuthService().postClientCredentialsGrant(request)
                .statusCode(SC_OK).extract().as(TokenResponse.class);

        if (response.getAccessToken() == null) {
            throw new IllegalArgumentException("Access token is null");
        }

        return response.getTokenType() + " " + response.getAccessToken();
    }

    public static String getPlayerBearerToken(String username, String password) {
        OwnerPasswordCredentialsGrantRequest request = OwnerPasswordCredentialsGrantRequest.builder()
                .username(username)
                .password(password)
                .build();

        TokenResponse response = new AuthService().postResourceOwnerPasswordCredentialsGrant(request)
                .statusCode(SC_OK).extract().as(TokenResponse.class);

        if (response.getAccessToken() == null) {
            throw new IllegalArgumentException("Access token is null");
        }

        return response.getTokenType() + " " + response.getAccessToken();
    }
}
