package ru.kpfu.itis.skatingblog.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.skatingblog.models.Comment;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachDto {

    private Long id;
    @NotEmpty
    @NotNull
    private String name;
    @NotNull
    @NotEmpty
    private String content;

    @NotNull
    private LocalDateTime created;

    @NotNull
    private String photoUrl;
//специальности

}
