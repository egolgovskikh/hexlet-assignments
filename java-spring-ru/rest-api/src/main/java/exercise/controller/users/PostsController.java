package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

    private List<Post> posts = new ArrayList<>();

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> show(@PathVariable int id) {
        List<Post> filteredPosts = posts.stream()
                .filter(p -> id == p.getUserId())
                .toList();
        return ResponseEntity.ok()
                .body(filteredPosts);
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> create(
            @PathVariable int id,
            @RequestBody Post data
            ) {
        var post = new Post();
        post.setUserId(id);
        post.setSlug(data.getSlug());
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        posts.add(post);
        return ResponseEntity.status(201)
                .body(post);
    }
}
// END
