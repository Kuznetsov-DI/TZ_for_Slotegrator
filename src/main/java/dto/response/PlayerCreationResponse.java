package dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class PlayerCreationResponse{

	private Integer id;

	@JsonProperty("country_id")
	private Integer countryId;

	@JsonProperty("timezone_id")
	private Integer timezoneId;
	private String username;
	private String email;
	private String name;
	private String surname;
	private String gender;

	@JsonProperty("phone_number")
	private String phoneNumber;
	private String birthdate;

	@JsonProperty("bonuses_allowed")
	private Boolean bonusesAllowed;

	@JsonProperty("is_verified")
	private Boolean isVerified;
}
