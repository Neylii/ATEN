package se.aten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.aten.domain.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
