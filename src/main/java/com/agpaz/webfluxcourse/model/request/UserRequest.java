package com.agpaz.webfluxcourse.model.request;

import com.agpaz.webfluxcourse.validator.TrimString;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(

        @Size(min = 2, max = 50)
        @NotBlank
        @TrimString
        String name,

        @Email
        String email,

        @Size(min = 4, max = 16)
        @TrimString
        String password
) {
}
