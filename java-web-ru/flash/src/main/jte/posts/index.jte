@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
    <h1>Posts</h1>
    @if(!page.getPosts().isEmpty())
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Body</th>
            </tr>
            @for(var post : page.getPosts())
                <tr>
                    <td>${post.getId()}</td>
                    <td>${post.getName()}</td>
                    <td>${post.getBody()}</td>
                </tr>
            @endfor
        </table>
    @endif
    <a href="${NamedRoutes.buildPostPath()}">Build post</a>
    `
)