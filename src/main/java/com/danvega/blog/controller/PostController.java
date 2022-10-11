package com.danvega.blog.controller;

import com.danvega.blog.model.Post;
import com.danvega.blog.model.dto.PostDetails;
import com.danvega.blog.repository.AuthorRepository;
import com.danvega.blog.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository posts;
    private final AuthorRepository authors;

    public PostController(PostRepository posts,AuthorRepository authors){
        this.posts = posts;
        this.authors = authors;
    }

    @GetMapping
    public Iterable<Post> findAll(){
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id){
        return posts.findById(id).orElse(null);
    }

    @GetMapping("/{id}/details")
    public PostDetails getPostDetails(@PathVariable Integer id){
        Post post = posts.findById(id).orElse(null);
        return new PostDetails(post, authors.findById(post.getAuthor().getId()).get());
    }
}
