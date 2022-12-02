package service;

import org.iesfm.newspaper.controllers.dto.ArticleDto;
import org.iesfm.newspaper.dao.ArticleDAO;
import org.iesfm.newspaper.dao.SectionDAO;
import org.iesfm.newspaper.entity.Article;
import org.iesfm.newspaper.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.exceptions.ArticleNotFoundException;
import service.exceptions.SectionNotFoundException;

import javax.validation.Valid;
import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionDAO sectionDAO;
    private ArticleDAO articleDAO;

    public List<Section> listSections(){
        return sectionDAO.list();
    }

    public Section getSection(int sectionId) {
        return sectionDAO.getSection(sectionId);
    }

    public boolean add(Section toEntity) {
        return sectionDAO.add(toEntity);
    }

    public boolean update(int sectionId, Section toEntity) {
        return sectionDAO.update(sectionId, toEntity);
    }

    public boolean delete(int sectionId) {
        return sectionDAO.delete(sectionId);
    }

    public List<Article> listAllArticles() {
        return articleDAO.list();
    }

    public List<Article> listArticlesBySection(int id, String autor) {
        return articleDAO.listSectionArticles(id, autor);
    }

    public void addArticle(Article article) throws SectionNotFoundException, ArticleNotFoundException {
            if (sectionDAO.getSection(article.getSectionId()) == null) {
                throw new SectionNotFoundException(article.getSectionId());
            } else if (!articleDAO.add(article)) {
                throw new ArticleNotFoundException(article.getSectionId());
            }
        }
    }

