package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postsPathByPage(Integer page) {
        return postsPathByPage(String.valueOf(page));
    }

    public static String postsPathByPage(String page) {
        return "/posts?page=" + page;
    }

    public static String postsPathById(Long id) {
        return postsPathById(String.valueOf(id));
    }

    public static String postsPathById(String id) {
        return "/posts/" + id;
    }
    // END
}
