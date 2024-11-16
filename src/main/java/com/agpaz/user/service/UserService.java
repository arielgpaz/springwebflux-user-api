package com.agpaz.user.service;

import com.agpaz.user.controller.exception.UserNotFoundException;
import com.agpaz.user.entity.User;
import com.agpaz.user.mapper.UserMapper;
import com.agpaz.user.model.request.UserRequest;
import com.agpaz.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }

    public Mono<User> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(
                        Mono.error(new UserNotFoundException())
                );
    }

    public Flux<User> findAll() {
        return repository.findAll();
    }

    public Mono<User> update(String id, UserRequest request) {
        return findById(id)
                .flatMap(user -> {
                    user.setName(request.name());
                    user.setEmail(request.email());
                    user.setPassword(request.password());
                    return repository.update(user);
                });
    }

    public Mono<Void> delete(String id) {
        return findById(id)
                .flatMap(user ->
                        repository.delete(user)
                                .flatMap(result -> Mono.empty())
                );
    }
}
