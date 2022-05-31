package ru.kpfu.itis.skatingblog.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AuthDto {
    private String email;
    private String password;
}
