package com.henry.joblisting.controller;

import com.henry.joblisting.repository.PostRepository;

import com.henry.joblisting.model.Post;
import com.henry.joblisting.repository.SearchRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;


    @ApiIgnore
    @RequestMapping(value="/")
    @CrossOrigin("*")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    @CrossOrigin("*")
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }

    @PostMapping("/post")
    @CrossOrigin("*")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

    @GetMapping ("/post/{_id}")
    @CrossOrigin("*")
    public Optional<Post> findSinglePostById( @PathVariable String _id)
    {return  repo.findById(_id);}

    @GetMapping ("/posts/{text}")
    @CrossOrigin("*")
    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }

    @DeleteMapping  ("/delposts/{_id}")
    @CrossOrigin("*")
    public void deletePost(@PathVariable String _id)
    {repo.deleteById(_id);}

    @PutMapping  ("/updateposts/{_id}")
    @CrossOrigin("*")
    public Post updatePost(@RequestBody Post post, @PathVariable String _id)
    {
        Post existingPost = repo.findById(_id).get();
        existingPost.setProfile(post.getProfile());
        existingPost.setDesc(post.getDesc());
        existingPost.setExp(post.getExp());
        existingPost.setTechs(post.getTechs());
        return repo.save(existingPost);
    }
}

