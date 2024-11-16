package com.agpaz.user.controller.impl;

import com.agpaz.user.controller.UserController;
import com.agpaz.user.entity.User;
import com.agpaz.user.model.request.UserRequest;
import com.agpaz.user.model.response.UserResponse;
import com.agpaz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService service;

    @Override
    public ResponseEntity<Mono<UserResponse>> save(UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(request).flatMap(User::toResponse));
    }

    @Override
    public ResponseEntity<Mono<UserResponse>> findById(String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id).flatMap(User::toResponse));
    }

    @Override
    public ResponseEntity<Flux<UserResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll().flatMap(User::toResponse));
    }

    @Override
    public ResponseEntity<Mono<UserResponse>> update(String id, UserRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.update(id, request).flatMap(User::toResponse));
    }

    @Override
    public ResponseEntity<Mono<Void>> delete(String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }
}
