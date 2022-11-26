package io.jonathanlee.registrationservice.repository;

import io.jonathanlee.registrationservice.model.RegistrationVerificationToken;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RegistrationVerificationTokenRepository extends
    ReactiveMongoRepository<RegistrationVerificationToken, String> {

  Mono<RegistrationVerificationToken> findRegistrationVerificationTokenByValue(final String value);

}
