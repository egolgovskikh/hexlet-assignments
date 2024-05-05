@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<div>
    <p>Id: ${page.getPost().getId()}</p>
    <p>Body: ${page.getPost().getBody()}</p>
    <p>Name: ${page.getPost().getName()}</p>
    <a href="${NamedRoutes.postsPath()}">Вернуться в список всех постов</a>
</div>
</body>
</html>