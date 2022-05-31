package ru.kpfu.itis.skatingblog.validation;

import ru.kpfu.itis.skatingblog.dto.UserDto;
import ru.kpfu.itis.skatingblog.validation.annotations.PasswordMatches;
import ru.kpfu.itis.skatingblog.validation.annotations.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//класс переписать под себя
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.trim().length() > 8 && value.matches(".*[A-Z].*") &&
                value.matches(".*[a-z].*") && value.matches(".*[0-9].*");
    }
}