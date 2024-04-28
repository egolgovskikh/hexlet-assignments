package exercise;

import io.javalin.Javalin;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", context -> {
            var page = context.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = context.queryParamAsClass("per", Integer.class).getOrDefault(5);
            var result = new LinkedList<>();
            int indexOfFirstElement = (page == 1) ? 0 : page * per - per;
            for (int i = indexOfFirstElement; i < USERS.size() && i < page * per; i++) {
                result.add(USERS.get(i));
            }
            context.json(result);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
