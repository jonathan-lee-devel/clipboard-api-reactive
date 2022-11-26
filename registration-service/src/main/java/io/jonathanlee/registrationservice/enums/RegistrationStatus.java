package io.jonathanlee.registrationservice.enums;

public enum RegistrationStatus {
  AWAITING_EMAIL_VERIFICATION,
  USER_ALREADY_EXISTS,
  INVALID_TOKEN,
  EMAIL_VERIFICATION_EXPIRED,
  PASSWORDS_DO_NOT_MATCH,
  FAILURE,
  SUCCESS
}
