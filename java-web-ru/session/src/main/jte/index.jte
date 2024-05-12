@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
</head>
<body>
<main>
    @if(page.getName() == null)
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @else
        <p>${page.getName().toString()}</p>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @endif
</main>
</body>
</html>