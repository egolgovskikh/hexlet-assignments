@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage postsPage

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
@if(postsPage.getPosts().isEmpty())
    <p>Пока не добавлено ни одного курса</p>
@else
    @for(var post : postsPage.getPosts())
        <div>
            <h4><a href="${NamedRoutes.postsPathById(post.getId())}">${post.getName()}</a></h4>
            <p>${post.getBody()}</p>
        </div>
    @endfor
    <a href="${NamedRoutes.postsPathByPage(postsPage.getPage() - 1)}">Назад</a>
    <a href="${NamedRoutes.postsPathByPage(postsPage.getPage() + 1)}">Вперед</a>
@endif
</body>
</html>