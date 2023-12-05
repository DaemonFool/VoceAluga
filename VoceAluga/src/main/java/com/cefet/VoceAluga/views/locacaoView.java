package com.cefet.VoceAluga.views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locacao.html")
public class locacaoView {
    @GetMapping
    public String locacao(){return "locacao";}
}
