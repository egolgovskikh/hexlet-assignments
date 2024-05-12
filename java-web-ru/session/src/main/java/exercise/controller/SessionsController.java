package exercise.controller;

import exercise.dto.LoginPage;
import exercise.dto.MainPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import exercise.util.Generator;
import io.javalin.http.Context;

import static exercise.util.Security.encrypt;
import static io.javalin.rendering.template.TemplateUtil.model;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        var userPassword = Generator.getUsers()
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .map(User::getPassword);
        if (userPassword.isPresent()) {
            if (userPassword.get().equals(encrypt(password))) {
                var user = new User(name, password);
                UsersRepository.save(user);
                ctx.sessionAttribute("name", name);
                ctx.redirect("/");
            } else {
                var page = new LoginPage(name, "Wrong username or password");
                ctx.render("build.jte", model("page", page));
            }
        } else {
            var page = new LoginPage(name, "Wrong username");
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect("/");
    }
    // END
}
