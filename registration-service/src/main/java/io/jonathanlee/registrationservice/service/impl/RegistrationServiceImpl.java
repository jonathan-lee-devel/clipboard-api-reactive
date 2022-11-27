package io.jonathanlee.registrationservice.service.impl;

import io.jonathanlee.registrationservice.dto.request.RegistrationDto;
import io.jonathanlee.registrationservice.dto.response.RegistrationStatusDto;
import io.jonathanlee.registrationservice.enums.RegistrationStatus;
import io.jonathanlee.registrationservice.service.RegistrationService;
import io.jonathanlee.registrationservice.service.RegistrationVerificationTokenService;
import io.jonathanlee.registrationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

  private final UserService userService;

  private final RegistrationVerificationTokenService registrationVerificationTokenService;

  @Override
  public Mono<RegistrationStatusDto> register(final Mono<RegistrationDto> registrationDto) {
    final var doesUserExist = registrationDto.flatMap(
        dto -> this.userService.getDoesUserExist(dto.getEmail()));

    return doesUserExist.map(doesExist -> {
      if (doesExist) {
        return new RegistrationStatusDto(RegistrationStatus.USER_ALREADY_EXISTS);
      }
      return new RegistrationStatusDto(RegistrationStatus.FAILURE);
    });
  }

  @Override
  public Mono<RegistrationStatusDto> confirm(final Mono<String> tokenValue) {
    return Mono.empty();
  }

}
