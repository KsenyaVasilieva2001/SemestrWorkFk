package ru.kpfu.itis.skatingblog.validation;

import ru.kpfu.itis.skatingblog.validation.annotations.ValidEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private Pattern pattern;
    private Matcher matcher;
    @Override
    public void initialize(ValidEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return validateEmail(s);
    }

    private boolean validateEmail(String email) {
        pattern = Pattern.compile(ConstantRegex.EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
