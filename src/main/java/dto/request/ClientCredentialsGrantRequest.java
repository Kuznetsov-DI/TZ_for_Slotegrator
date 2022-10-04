package dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClientCredentialsGrantRequest {

	@JsonProperty("grant_type")
	@Builder.Default
	private final String grantType = "client_credentials";

	@Builder.Default
	private final String scope = "guest:default";
}
