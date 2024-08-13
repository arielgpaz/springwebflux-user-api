package com.agpaz.webfluxcourse.service;

import com.agpaz.webfluxcourse.entity.User;
import com.agpaz.webfluxcourse.mapper.UserMapper;
import com.agpaz.webfluxcourse.model.request.UserRequest;
import com.agpaz.webfluxcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }
}
