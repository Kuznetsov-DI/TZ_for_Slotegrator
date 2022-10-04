package dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PlayerCreationRequest {

	private final String username;

	@JsonProperty("password_change")
	private final String passwordChange;

	@JsonProperty("password_repeat")
	private final String passwordRepeat;
	private final String email;
	private final String name;
	private final String surname;
}
