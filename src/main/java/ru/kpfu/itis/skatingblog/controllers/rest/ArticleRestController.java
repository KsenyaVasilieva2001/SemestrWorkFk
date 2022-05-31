package ru.kpfu.itis.skatingblog.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.skatingblog.dto.CommentDto;
import ru.kpfu.itis.skatingblog.services.ArticleService;

@RestController
@RequestMapping("/api/v2/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    @Autowired
    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/{articleId}/comments")
    public Page<CommentDto> articleComments(@PathVariable Long articleId, Pageable pageable) {
        return articleService.getArticleComments(articleId, pageable);
    }
}
