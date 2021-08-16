package com.lab.codefellowship.controllers;

import com.lab.codefellowship.models.ApplicationUser;
import com.lab.codefellowship.models.Post;
import com.lab.codefellowship.repositories.ApplicationUserRepository;
import com.lab.codefellowship.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PostController {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/post/")
    public RedirectView newPost(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "body") String body
    ) {
        ApplicationUser user = applicationUserRepository.findById(id).get();
        Post newPost = new Post(body, user);
        postRepository.save(newPost);
        System.out.println("=============" + body);
        return new RedirectView("/");
    }

    @PostMapping("/post")
    public RedirectView addpost(Principal p, String body) {
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        Post newPost = new Post(body, user);
        postRepository.save(newPost);
        return new RedirectView("/");
    }

}
