package io.jonathanlee.registrationservice.service;

import io.jonathanlee.registrationservice.model.RegistrationVerificationToken;
import reactor.core.publisher.Mono;

public interface RegistrationVerificationTokenService {

  Mono<RegistrationVerificationToken> getRegistrationVerificationTokenById(final String id);

  Mono<RegistrationVerificationToken> updateRegistrationVerificationToken(final String id,
      final RegistrationVerificationToken registrationVerificationToken);

}
