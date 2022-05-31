package ru.kpfu.itis.skatingblog.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EditProfileDto {
    private String firstName;
    private String lastName;
}
