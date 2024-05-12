@import exercise.dto.LoginPage
@param LoginPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
</head>
<body>
<main>
    @if(page != null && page.getError() != null)
        <p>${page.getError()}</p>
    @endif

    <form action="${exercise.util.NamedRoutes.loginPath()}" method="post">
        <input type="text" placeholder="Name" name="name"/>
        <input type="password" placeholder="Password" , name="password">
        <input type="submit">
    </form>
</main>
</body>
</html>
