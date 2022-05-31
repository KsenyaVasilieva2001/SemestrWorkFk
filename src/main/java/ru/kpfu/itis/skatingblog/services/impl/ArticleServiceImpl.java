package ru.kpfu.itis.skatingblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.skatingblog.converters.DateConverter;
import ru.kpfu.itis.skatingblog.dto.ArticleDto;
import ru.kpfu.itis.skatingblog.dto.CommentDto;
import ru.kpfu.itis.skatingblog.dto.UserDto;
import ru.kpfu.itis.skatingblog.models.Article;
import ru.kpfu.itis.skatingblog.models.User;
import ru.kpfu.itis.skatingblog.models.enums.Role;
import ru.kpfu.itis.skatingblog.models.enums.Status;
import ru.kpfu.itis.skatingblog.repositories.ArticleRepository;
import ru.kpfu.itis.skatingblog.repositories.CommentRepository;
import ru.kpfu.itis.skatingblog.services.ArticleService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<ArticleDto> getAllArticles() {
        return articleRepository
                .findAll().stream()
                .map(article -> modelMapper.map(article, ArticleDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<ArticleDto> getArticleById(Long id) {
        return articleRepository
                .findById(id)
                .map(article -> modelMapper.map(article, ArticleDto.class));
    }


    @Override
    public void createArticle(ArticleDto articleDto) {
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        article.setContent(articleDto.getContent());
        article.setVideoUrl(articleDto.getVideoUrl());

        article.setCreated((LocalDateTime.now()));
        article.setViews(0L);
        saveArticle(article);
        /*
        articleRepository.createArticle(
                articleDto.getTitle(),
                articleDto.getDescription(),
                articleDto.getContent(),
                articleDto.getVideoUrl());

         */
    }


    @Override
    public Page<CommentDto> getArticleComments(Long articleId, Pageable pageable) {
        return commentRepository
                .getAllByArticleId(articleId, pageable)
                .map(comment -> {
                    CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
                    commentDto.setUser(modelMapper.map(comment.getUser(), UserDto.class));
                    commentDto.setArticleId(articleId);
                    return commentDto;
                });
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void update(ArticleDto articleDto, Long id) {
        articleRepository.update(articleDto.getTitle(),
                articleDto.getDescription(),
                articleDto.getContent(),
                articleDto.getVideoUrl(),
                id);
    }

    /*
    @Override
    public List<ArticleDto> findAllLikes(User user) {
        return articleRepository.findAllLikes(user);
    }

     */

    @Override
    public void deleteArticle(Long id) {
        articleRepository.delete(id);
    }
}
