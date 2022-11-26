package io.jonathanlee.registrationservice.repository;

import io.jonathanlee.registrationservice.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

  Mono<User> findUserByUsername(final String username);

}
