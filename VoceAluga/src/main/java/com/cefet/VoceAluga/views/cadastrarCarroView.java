package com.cefet.VoceAluga.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastrarCarro.html")
public class cadastrarCarroView {
    @GetMapping
    public String cadastrarCarro(){return "cadastrarCarro";}
}
