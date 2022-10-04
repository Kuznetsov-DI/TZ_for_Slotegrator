package utils;

import dto.request.PlayerCreationRequest;
import dto.response.PlayerCreationResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExpectedDataBuilder {

    public static PlayerCreationResponse getPlayerCreationResponseByRequest(PlayerCreationRequest request){

        return PlayerCreationResponse.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .bonusesAllowed(true)
                .isVerified(false)
                .build();
    }
}
