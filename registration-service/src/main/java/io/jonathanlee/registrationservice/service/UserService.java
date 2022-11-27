package io.jonathanlee.registrationservice.service;

import io.jonathanlee.registrationservice.model.User;
import reactor.core.publisher.Mono;

public interface UserService {

  Mono<User> getUserById(final String id);

  Mono<Boolean> getDoesUserExist(final String username);

  Mono<User> updateUser(final String id, final User user);

}
