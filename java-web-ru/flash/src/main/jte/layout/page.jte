@import exercise.dto.BasePage
@import gg.jte.Content
@param Content content
@param BasePage page = null 

<!doctype html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        @if(page != null && page.getFlash() != null)
            <p>${page.getFlash()}</p>
        @endif
        ${content}
    </body>
</html>
