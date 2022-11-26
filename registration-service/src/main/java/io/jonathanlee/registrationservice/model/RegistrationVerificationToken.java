package io.jonathanlee.registrationservice.model;

import java.time.ZonedDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class RegistrationVerificationToken {

  @Id
  private String id;

  private String value;

  private ZonedDateTime expiryDate;

  private String userEmail;
  
}
