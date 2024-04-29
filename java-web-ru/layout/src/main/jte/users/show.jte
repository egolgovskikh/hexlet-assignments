@param exercise.dto.users.UserPage page

@template.layout.page(
content = @`
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>email</th>
        </tr>
        <tr>
            <td>${page.getUser().getId()}</td>
            <td>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</td>
            <td>${page.getUser().getEmail()}</td>
        </tr>
    </table>
`
)