package ru.kpfu.itis.skatingblog.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.skatingblog.dto.ArticleDto;
import ru.kpfu.itis.skatingblog.dto.CommentDto;
import ru.kpfu.itis.skatingblog.models.Article;
import ru.kpfu.itis.skatingblog.models.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ArticleService {
    Set<ArticleDto> getAllArticles();
    Optional<ArticleDto> getArticleById(Long id);
    void createArticle(ArticleDto articleDto);
    Page<CommentDto> getArticleComments(Long articleId, Pageable pageable);
    void saveArticle(Article article);
    void update(ArticleDto articleDto, Long id);
   // List<ArticleDto> findAllLikes(User user);
    void deleteArticle(Long id);
}
