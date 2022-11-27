package io.jonathanlee.registrationservice.service.impl;

import io.jonathanlee.registrationservice.model.User;
import io.jonathanlee.registrationservice.repository.UserRepository;
import io.jonathanlee.registrationservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public Mono<User> getUserById(final String id) {
    return this.userRepository.findById(id);
  }

  @Override
  public Mono<Boolean> getDoesUserExist(final String username) {
    return this.userRepository.findUserByUsername(username)
        .flatMap(user -> Mono.just(true)).switchIfEmpty(Mono.defer(() -> Mono.just(false)));
  }

  @Override
  public Mono<User> updateUser(final String id, final User user) {
    return this.userRepository.findById(id)
        .flatMap(userToUpdate -> this.userRepository.save(user));
  }

}
