@import exercise.dto.users.UserPage
@param UserPage page

<html>
    <body>
        <p>${page.getUser().getId()}</p>
        <p>${page.getUser().getFirstName()}</p>
        <p>${page.getUser().getLastName()}</p>
        <p>${page.getUser().getEmail()}</p>
    </body>
</html>