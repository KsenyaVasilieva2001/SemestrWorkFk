package ru.kpfu.itis.skatingblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.kpfu.itis.skatingblog.dto.ArticleDto;
import ru.kpfu.itis.skatingblog.dto.EditArticleDto;
import ru.kpfu.itis.skatingblog.dto.EditProfileDto;
import ru.kpfu.itis.skatingblog.models.Article;
import ru.kpfu.itis.skatingblog.models.User;
import ru.kpfu.itis.skatingblog.security.details.UserDetailsImpl;
import ru.kpfu.itis.skatingblog.services.ArticleService;

import java.util.Optional;
import java.util.Set;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article/{articleId}")
    public String articlePage(@PathVariable Long articleId, Model model) {
        Optional<ArticleDto> optionalArticleDto = articleService.getArticleById(articleId);
        if (optionalArticleDto.isPresent()) {
            model.addAttribute("article", optionalArticleDto.get());
            return "article";
        }
        model.addAttribute("error", "Статья не найдена");
        return "error_page";
    }

    /*
    @GetMapping("/article/{articleId}/like")
    public String like(@AuthenticationPrincipal UserDetails userDetails,
                       @PathVariable Long articleId,
                       RedirectAttributes redirectAttributes,
                       @RequestHeader(required = false) String referer) {
        Optional<ArticleDto> optionalArticleDto = articleService.getArticleById(articleId);
        Set<User> likes = optionalArticleDto.get().getLikes();

        if (likes.contains(userDetails)) {
            likes.remove(userDetails);
        } else {
            likes.add(userDetails);
        }

        UriComponents components = UriComponentsBuilder.fromHttpUrl(referer).build();

        components.getQueryParams()
                .entrySet()
                .forEach(pair -> redirectAttributes.addAttribute(pair.getKey(), pair.getValue()));

        return "redirect:" + components.getPath();
    }

     */

    @GetMapping("/articles")
    public String articlesPage(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "videoblog";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/articles/add")
    public String showAddArticleForm(Model model) {
        ArticleDto articleDto = new ArticleDto();
        model.addAttribute("article", articleDto);
        return "add_article";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    //добавить валидацию
    @PostMapping("/articles/add")
    public String addArticle(@ModelAttribute("article") ArticleDto articleDto, BindingResult bindingResult, ModelMap map) {
         if (bindingResult.hasErrors()) {
            return "add_article";
        }
        articleService.createArticle(articleDto);
        return "redirect:/articles";
    }

/*
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/article/{articleId}/edit")
    public String updateArticle(@PathVariable("articleId") Long articleId, BindingResult bindingResult, ModelMap map) {
        Optional<ArticleDto> optionalArticleDto = articleService.getArticleById(articleId);
        if (optionalArticleDto.isPresent()) {
            ArticleDto articleDto = optionalArticleDto.get();
            articleService.update(articleDto);
            return "redirect:/articles";
        }
        map.addAttribute("error", "Статья не найдена");
        return "error_page";

    }

 */
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/article/{articleId}/edit")
    public String getEditArticlePage(@PathVariable Long articleId, Model model) {

        Optional<ArticleDto> article = articleService.getArticleById(articleId);
        EditArticleDto editArticleDto = new EditArticleDto();
        model.addAttribute("article", editArticleDto);
        if (article.isPresent()) {
            ArticleDto article1 = article.get();
            model.addAttribute("title", article1.getTitle());
            model.addAttribute("description", article1.getDescription());
            model.addAttribute("content", article1.getContent());
            model.addAttribute("videoUrl", article1.getVideoUrl());
        }

        return "article_edit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/article/{articleId}/edit")
    public String updateArticle(@ModelAttribute("article") EditArticleDto editArticleDto,
                                @PathVariable("articleId") Long id){
        String title = editArticleDto.getTitle();
        String description = editArticleDto.getDescription();
        String content = editArticleDto.getContent();
        String videoUrl = editArticleDto.getVideoUrl();
        articleService.update(new ArticleDto(title, description, content, videoUrl), id);
        return "redirect:/articles";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/article/{articleId}/delete")
    public String deleteArticle(@PathVariable(value = "id") Long id){
        articleService.deleteArticle(id);
        return "redirect:/articles";

    }
}
