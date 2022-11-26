package io.jonathanlee.registrationservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jonathanlee.registrationservice.enums.RegistrationStatus;
import lombok.Data;

@Data
public class RegistrationStatusDto {

  @JsonProperty("registration_status")
  private final RegistrationStatus registrationStatus;

}
