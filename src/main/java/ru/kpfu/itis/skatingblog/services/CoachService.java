package ru.kpfu.itis.skatingblog.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.kpfu.itis.skatingblog.dto.ArticleDto;
import ru.kpfu.itis.skatingblog.dto.CoachDto;
import ru.kpfu.itis.skatingblog.dto.CommentDto;
import ru.kpfu.itis.skatingblog.models.Article;
import ru.kpfu.itis.skatingblog.models.Coach;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CoachService {
    Set<CoachDto> getAllCoaches();
    Optional<CoachDto> getCoachById(Long id);
    List<Coach> findCoachesBySpeciality(String specName);

}
