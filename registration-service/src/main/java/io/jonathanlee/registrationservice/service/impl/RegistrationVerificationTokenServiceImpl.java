package io.jonathanlee.registrationservice.service.impl;

import io.jonathanlee.registrationservice.model.RegistrationVerificationToken;
import io.jonathanlee.registrationservice.repository.RegistrationVerificationTokenRepository;
import io.jonathanlee.registrationservice.service.RegistrationVerificationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RegistrationVerificationTokenServiceImpl implements
    RegistrationVerificationTokenService {

  private final RegistrationVerificationTokenRepository registrationVerificationTokenRepository;

  @Override
  public Mono<RegistrationVerificationToken> getRegistrationVerificationTokenById(final String id) {
    return this.registrationVerificationTokenRepository.findById(id);
  }

  @Override
  public Mono<RegistrationVerificationToken> updateRegistrationVerificationToken(final String id,
      RegistrationVerificationToken registrationVerificationToken) {
    return this.registrationVerificationTokenRepository.findById(id)
        .flatMap(token ->
            this.registrationVerificationTokenRepository.save(registrationVerificationToken)
        );
  }

}
