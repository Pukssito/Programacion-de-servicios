package org.iesfm.newspaper.controllers;

import org.iesfm.newspaper.controllers.dto.ArticleDto;
import org.iesfm.newspaper.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SectionService;
import service.exceptions.ArticleNotFoundException;
import service.exceptions.SectionNotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArticleController {
    @Autowired
    private SectionService sectionService;


    @GetMapping(path = "/articles")
    public ResponseEntity<List<ArticleDto>> list() {
        return ResponseEntity.ok(
                sectionService.listAllArticles()
                        .stream()
                        .map(article -> ArticleDto.toDto(article))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping(path = "/section/{sectionId}/articles")
    public ResponseEntity<List<ArticleDto>> listBySection(
            @PathVariable("sectionId") int sectionId,
            @RequestParam(value = "author", required = false) String autor
    ) {
        return ResponseEntity.ok(
                sectionService.listArticlesBySection(sectionId, autor)
                        .stream()
                        .map(article -> ArticleDto.toDto(article))
                        .collect(Collectors.toList())
        );
    }

    @PostMapping(path = "/section/{sectionId}/articles")
    public ResponseEntity<Void> addArticle(
            @PathVariable("sectionId") int sectionId,
            @Valid @RequestBody Article article
    ) {
        try {
            sectionService.addArticle(article);
            return ResponseEntity.ok().build();
        } catch (SectionNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ArticleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}
