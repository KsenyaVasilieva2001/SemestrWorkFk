package ru.kpfu.itis.skatingblog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.skatingblog.validation.annotations.PasswordMatches;
import ru.kpfu.itis.skatingblog.validation.annotations.ValidEmail;
import ru.kpfu.itis.skatingblog.validation.annotations.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@PasswordMatches
public class SignUpForm {
    @NotNull
    @NotEmpty
    @ValidEmail(message = "{errors.invalid.email}")
    private String email;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    @ValidPassword(message = "{errors.invalid.password}")
    private String password;
    @NotNull
    @NotEmpty
    private String confirmedPassword;
}
