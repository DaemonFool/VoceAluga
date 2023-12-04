package com.cefet.VoceAluga.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastrarCliente.html")
public class cadastrarClienteView {
    @GetMapping
    public String cadastrarCliente(){return "cadastrarCliente";}
}
