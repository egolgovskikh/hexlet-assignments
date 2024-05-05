package exercise.controller;

import exercise.dto.posts.PostPage;
import exercise.dto.posts.PostsPage;
import exercise.repository.PostRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static io.javalin.rendering.template.TemplateUtil.model;

public class PostsController {

    public static final int ROWS_PER_PAGE = 5;

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        try {
            var post = PostRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Page not found"));
            var page = new PostPage(post);
            ctx.render("posts/show.jte", model("page", page));
        } catch (NotFoundResponse e) {
            ctx.status(404);
        }
    }

    public static void index(Context ctx) {
        var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);

        int indexOfFirstElement = (page - 1) * ROWS_PER_PAGE;
        int indexOfLastElement = page * ROWS_PER_PAGE;

        var posts = PostRepository.getEntities();
        var postsPage = new PostsPage(posts.subList(indexOfFirstElement, indexOfLastElement), page);
        ctx.render("posts/index.jte", model("postsPage", postsPage));
    }
    // END
}
