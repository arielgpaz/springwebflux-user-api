package com.agpaz.user.entity;

import com.agpaz.user.model.response.UserResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

@Data
@Builder
@Document
public class User {

    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String email;

    private String password;

    public Mono<UserResponse> toResponse() {
        return Mono.just(new UserResponse(id, name, email));
    }
}
