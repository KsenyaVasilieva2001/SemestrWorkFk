package ru.kpfu.itis.skatingblog.validation.annotations;

import ru.kpfu.itis.skatingblog.validation.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Valid;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {
    String message() default "Invalid Email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
