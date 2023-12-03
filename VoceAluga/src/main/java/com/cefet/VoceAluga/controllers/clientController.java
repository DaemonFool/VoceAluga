package com.cefet.VoceAluga.controllers;

import com.cefet.VoceAluga.services.clientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cefet.VoceAluga.models.client;

import java.util.List;


@RestController
@RequestMapping(value = "/clients")
public class clientController {
    @Autowired
    private clientService service;
    @GetMapping
    public ResponseEntity<List<client>> findAll(){
        List<client> list = service.FindAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<client> findByID(@PathVariable Integer id){
        client result = service.findByID(id);
        return ResponseEntity.ok().body(result);
    }


}
