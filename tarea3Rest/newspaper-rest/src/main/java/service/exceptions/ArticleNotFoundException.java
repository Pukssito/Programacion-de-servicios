package service.exceptions;

public class ArticleNotFoundException extends Exception {
    private final int articleId;

    public ArticleNotFoundException(int articleId) {
        this.articleId = articleId;
    }

    public int getArticleId() {
        return articleId;
    }
}

