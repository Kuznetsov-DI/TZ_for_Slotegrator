package api;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import service.AuthService;

import static utils.AuthHelper.getGuestBearerToken;

public class ApiTest {
    private final AuthService steps = new AuthService();
    private final SoftAssert softAssert = new SoftAssert();

    @Test
    public void testApi() {

        String token = getGuestBearerToken();


    }

}
