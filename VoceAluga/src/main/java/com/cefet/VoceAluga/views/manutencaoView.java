package com.cefet.VoceAluga.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manutencao.html")
public class manutencaoView {
    @GetMapping
    public String manutencao(){return "manutencao";}
}