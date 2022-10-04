package utils;

import dto.request.PlayerCreationRequest;
import dto.response.PlayerResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExpectedDataBuilder {

    public static PlayerResponse getPlayerCreationResponseByRequest(PlayerCreationRequest request){

        return PlayerResponse.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .bonusesAllowed(true)
                .isVerified(false)
                .build();
    }
}
