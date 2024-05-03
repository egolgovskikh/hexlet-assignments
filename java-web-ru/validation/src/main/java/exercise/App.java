package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", context -> {
            var page = new BuildArticlePage();
            context.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", context -> {
            String title = context.formParam("title");
            String content = context.formParam("content");
            try {
                title = context.formParamAsClass("title", String.class)
                        .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                        .check(value -> ArticleRepository.getEntities().stream().map(Article::getTitle).noneMatch(x -> x.equals(value)), "Статья с таким названием уже существует")
                        .get();
                content = context.formParamAsClass("content", String.class)
                        .check(value -> value.length() >= 10, "Статья должна быть не короче 10 символов")
                        .get();
                var article = new Article(title, content);
                ArticleRepository.save(article);
                context.redirect("/articles");
            } catch (ValidationException e) {
                var page = new BuildArticlePage(title, content, e.getErrors());
                context.status(422);
                context.render("articles/build.jte", model("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
