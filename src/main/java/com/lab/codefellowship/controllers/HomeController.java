package com.lab.codefellowship.controllers;

import com.lab.codefellowship.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @GetMapping("/")
    public String getHome(Principal p , Model m){
        if(p!=null){
            m.addAttribute("user", applicationUserRepository.findByUsername(p.getName()));
            m.addAttribute("userName", p.getName());

            return "home.html";
        }
        return "home.html";
    }
}
