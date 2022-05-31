package ru.kpfu.itis.skatingblog.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.kpfu.itis.skatingblog.models.Article;
import ru.kpfu.itis.skatingblog.models.Comment;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Data
@NoArgsConstructor
public class ArticleDto {

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
    private Instant created;
    private Set<Comment> comments;
    private Long views;
    private Long likes;
    private Boolean meLiked;



    public ArticleDto(String title, String description, String content, String videoUrl){

        this.title = title;
        this.description = description;
        this.content = content;
        this.videoUrl = videoUrl;
    }


}
