package com.codeup.codeupspringblog2.controllers;

import com.codeup.codeupspringblog2.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/post")
    public String post(Model model){
        model.addAttribute("post", new Post("Hello", "Hello World"));
        return "/posts/index";
    }

    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts= new ArrayList<>();
        posts.add(new Post("Hello", "HelloWorld"));
        posts.add(new Post("Hello 2", "Hello Again"));
        model.addAttribute("posts", posts);
        return "/posts/show";
    }


//    @GetMapping()
//    @ResponseBody
//    public String viewPosts() {
//        return "<h1>This is the posts index page</h1>";
//    }

    @GetMapping("/{id}")
    @ResponseBody
    public String viewPostsById(@PathVariable long id) {

        return "<h1>View an individual post, the post id is: " + id + "</h1>";
    }

    @GetMapping("/create")
    @ResponseBody
    public String viewPostsCreate() {

        return "<form action='/posts/create' method='post'>" +
                "<input type='submit' value='submit'>" +
                "</form>";
    }

    @PostMapping("/create")
    @ResponseBody
    public String postsCreate() {

        return "A new post has been made";
    }

}