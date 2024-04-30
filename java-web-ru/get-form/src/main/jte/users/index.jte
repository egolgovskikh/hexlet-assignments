@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        @if(page == null)
            <input type="search" name="term"/>
        @else
            <input type="search" name="term" value="${page.getTerm()}"/>
        @endif
        <input type="submit" value="Search"/>
    </form>
    @if(page != null && !page.getUsers().isEmpty())
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
            @for(var user : page.getUsers())
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            @endfor
        </table>
    @endif
`
)