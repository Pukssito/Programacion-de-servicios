package org.iesfm.newspaper.controllers;

import org.iesfm.newspaper.controllers.dto.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.SectionService;
import service.exceptions.ArticleNotFoundException;

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
           @PathVariable("sectionId") int sectionId
           @RequestParam(value = "author",required = false) String autor
   ) {
     try {
            return ResponseEntity.ok(
                    sectionService.listArticlesBySection(sectionId)
            );
        } catch (ArticleNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
 }

    }

