package com.cefet.VoceAluga.controllers;

import com.cefet.VoceAluga.models.franchise;
import com.cefet.VoceAluga.services.franchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/franchises")
public class franchiseController {
    @Autowired
    private franchiseService service;
   @GetMapping
    public ResponseEntity<List<franchise>> findAll(){
       List<franchise> list = service.FindAll();
       return ResponseEntity.ok().body(list);
   }

    @GetMapping(value = "/{id}")
    public ResponseEntity<franchise> findByID(@PathVariable Integer id){
       franchise result = service.findByID(id);
       return ResponseEntity.ok().body(result);
    }
    @PostMapping
    public ResponseEntity<franchise> insert(@RequestBody franchise franchise){
        franchise = service.insert(franchise);
        return ResponseEntity.ok().body(franchise);
    }

}
