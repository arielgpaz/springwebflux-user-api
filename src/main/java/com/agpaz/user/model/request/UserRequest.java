package com.agpaz.user.model.request;

import com.agpaz.user.validator.NotBlankSpace;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(

        @Size(min = 2, max = 50)
        @NotBlank
        @NotBlankSpace
        String name,

        @Email
        String email,

        @Size(min = 4, max = 16)
        @NotBlankSpace
        String password
) {
}
