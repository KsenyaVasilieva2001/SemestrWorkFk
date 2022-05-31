package ru.kpfu.itis.skatingblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.skatingblog.dto.ArticleDto;
import ru.kpfu.itis.skatingblog.models.Article;
import ru.kpfu.itis.skatingblog.models.User;
import ru.kpfu.itis.skatingblog.models.enums.Role;
import ru.kpfu.itis.skatingblog.models.enums.Status;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {


    //Выбор популярной статьи, где больше всего комментариев для подзапроса!!!!

    @Transactional
    @Modifying
    @Query(value = "update article set title = :title, description = :description, " +
            "content = :content, video_url = :videoUrl " +
            "where id = :articleId", nativeQuery = true)
    void update(@Param("title") String title,
                @Param("description") String description,
                @Param("content") String content,
                @Param("videoUrl") String videoUrl,
                @Param("articleId") Long articleId);


    @Transactional
    @Modifying
    @Query(value = "delete article where id = :articleId", nativeQuery = true)
    void delete(@Param("articleId") Long articleId);

/*
    @Query("select new ru.kpfu.itis.skatingblog.dto.ArticleDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "group by m")
    List<ArticleDto> findAllLikes(@Param("user") User user);

     */


}
