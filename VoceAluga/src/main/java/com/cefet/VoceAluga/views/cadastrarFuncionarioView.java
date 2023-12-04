package com.cefet.VoceAluga.views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastrarFuncionario.html")
public class cadastrarFuncionarioView {
    @GetMapping
    public String cadastrarFuncionario(){return "cadastrarFuncionario";}
}

