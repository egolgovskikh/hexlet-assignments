package exercise;

// BEGIN

// END

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(javalinConfig -> javalinConfig.bundledPlugins.enableDevLogging());
        app.get("/welcome", context -> context.result("Welcome to Hexlet!"));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
