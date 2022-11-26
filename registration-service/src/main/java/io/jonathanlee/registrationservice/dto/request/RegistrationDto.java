package io.jonathanlee.registrationservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrationDto {

  @NotNull(message = "E-mail address cannot be null")
  private final String email;

  @JsonProperty("firstname")
  private final String firstName;

  @JsonProperty("lastname")
  private final String lastName;

  private final String password;

  @JsonProperty("confirm_password")
  private final String confirmPassword;

}
