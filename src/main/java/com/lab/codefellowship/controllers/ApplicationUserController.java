package com.lab.codefellowship.controllers;

import com.lab.codefellowship.models.ApplicationUser;
import com.lab.codefellowship.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ApplicationUserController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup.html";
    }

    @GetMapping("/login")
    public String getSignInPage() {
        return "signin.html";
    }

    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value = "username") String username,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "firstName") String firstName,
                               @RequestParam(value = "lastName") String lastName,
                               @RequestParam(value = "dateOfBirth") String dateOfBirth,
                               @RequestParam(value = "bio") String bio
    ) {
        ApplicationUser newUser = new ApplicationUser(username, bCryptPasswordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);
        applicationUserRepository.save(newUser);
        return new RedirectView("/login");
    }
    @GetMapping("/users/{id}")
    public String getProfile(@PathVariable("id") Integer id, Model m) {
        ApplicationUser user = applicationUserRepository.findById(id).get();
        m.addAttribute("user", user);
        return "profile.html";
    }

        @GetMapping("/user")
    public String getProfile(Model m, Principal p) {
        if (p.getName() == null){
            return "signin.html";
        }
        m.addAttribute("user", applicationUserRepository.findByUsername(p.getName()));
        return "home.html";
    }

}
