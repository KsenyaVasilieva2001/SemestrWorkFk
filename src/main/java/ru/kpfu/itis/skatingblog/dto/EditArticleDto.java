package ru.kpfu.itis.skatingblog.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditArticleDto {

    private Long id;
    @NotEmpty
    @NotNull
    private String title;
    @NotNull
    @NotEmpty
    //поставить сюда валидацию
    private String videoUrl;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @NotEmpty
    private String content;


}