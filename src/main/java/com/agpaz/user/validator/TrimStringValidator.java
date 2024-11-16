package com.agpaz.user.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TrimStringValidator implements ConstraintValidator<NotBlankSpace, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || value.trim().length() == value.length();
    }

}
