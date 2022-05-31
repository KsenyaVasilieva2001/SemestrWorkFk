package ru.kpfu.itis.skatingblog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import ru.kpfu.itis.skatingblog.models.Article;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private String text;
    private Long articleId;
    private UserDto user;
    private LocalDateTime createdAt;
}
