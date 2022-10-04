package utils;

import com.github.javafaker.Faker;
import dto.request.PlayerCreationRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestObjectBuilder {

    private static final Faker faker = new Faker();
    private static final String EMAIL_REGEXP = "[a-z]{10}\\@[a-z]{5}\\.[a-z]{2}";
    private static final String PASSWORD = "amFuZWRvZTEyMw==";

    public static PlayerCreationRequest getRandomPlayerCreationRequest(){


        return PlayerCreationRequest.builder()
                .username(faker.name().username())
                .passwordChange(PASSWORD)
                .passwordRepeat(PASSWORD)
                .email(faker.regexify(EMAIL_REGEXP))
                .name(faker.name().firstName())
                .surname(faker.name().lastName())
                .build();
    }
}
