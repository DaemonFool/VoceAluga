package com.cefet.VoceAluga.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/home.html")
public class HomeView {

    @GetMapping()
    public String homePage(Model model) {
        return "home";
    }

}
