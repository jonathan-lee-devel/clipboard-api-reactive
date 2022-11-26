package io.jonathanlee.registrationservice.service;

import io.jonathanlee.registrationservice.dto.request.RegistrationDto;
import io.jonathanlee.registrationservice.dto.response.RegistrationStatusDto;
import reactor.core.publisher.Mono;

public interface RegistrationService {

  Mono<RegistrationStatusDto> register(final Mono<RegistrationDto> registrationDto);

  Mono<RegistrationStatusDto> confirm(final String tokenValue);

}
