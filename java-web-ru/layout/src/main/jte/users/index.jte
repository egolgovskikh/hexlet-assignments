@param exercise.dto.users.UsersPage page

@template.layout.page(
content = @`
    <table>
        <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>email</th>
        </tr>
        @for(var user : page.getUsers())
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
            </tr>
        @endfor
    </table>
`
)