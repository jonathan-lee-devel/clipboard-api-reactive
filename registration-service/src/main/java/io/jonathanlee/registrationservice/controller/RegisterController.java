package io.jonathanlee.registrationservice.controller;

import io.jonathanlee.registrationservice.dto.request.RegistrationDto;
import io.jonathanlee.registrationservice.dto.response.RegistrationStatusDto;
import io.jonathanlee.registrationservice.service.RegistrationService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

  private final RegistrationService registrationService;

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseEntity<RegistrationStatusDto>> register(
      @Valid @RequestBody final Mono<RegistrationDto> registrationDto
  ) {
    return this.registrationService.register(registrationDto)
        .map(registrationStatusDto -> switch (registrationStatusDto.getRegistrationStatus()) {
          case AWAITING_EMAIL_VERIFICATION ->
              ResponseEntity.status(HttpStatus.OK).body(registrationStatusDto);
          case USER_ALREADY_EXISTS ->
              ResponseEntity.status(HttpStatus.CONFLICT).body(registrationStatusDto);
          default ->
              ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(registrationStatusDto);
        });
  }

  @GetMapping(value = "/confirm/{tokenValue}",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.OK)
  public Mono<ResponseEntity<RegistrationStatusDto>> confirm(
      @PathVariable final String tokenValue
  ) {
    return this.registrationService.confirm(Mono.just(tokenValue))
        .map(registrationStatusDto -> switch (registrationStatusDto.getRegistrationStatus()) {
          case EMAIL_VERIFICATION_EXPIRED, INVALID_TOKEN ->
              ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registrationStatusDto);
          case SUCCESS -> ResponseEntity.status(HttpStatus.OK).body(registrationStatusDto);
          default ->
              ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(registrationStatusDto);
        });
  }

}
