@import exercise.util.NamedRoutes

@template.layout.page(
    content = @`
        <h2>Welcome to Hexlet</h2>
        <a href="${NamedRoutes.postsPath()}">Posts</a>
        <a href="${NamedRoutes.buildPostPath()}">Build post</a>
    `
)
