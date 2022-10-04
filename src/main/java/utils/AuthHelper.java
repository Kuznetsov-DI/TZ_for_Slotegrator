package utils;

import dto.request.ClientCredentialsGrantRequest;
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
}
