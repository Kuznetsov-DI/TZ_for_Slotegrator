package dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OwnerPasswordCredentialsGrantRequest {

	@Builder.Default
	@JsonProperty("grant_type")
	private final String grantType = "password";
	private final String username;
	private final String password;
}
