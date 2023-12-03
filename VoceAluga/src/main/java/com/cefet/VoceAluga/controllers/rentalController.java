package com.cefet.VoceAluga.controllers;

import com.cefet.VoceAluga.models.rental;
import com.cefet.VoceAluga.services.rentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/rentals")
public class rentalController {
    @Autowired
    private rentalService service;
    @GetMapping
    public ResponseEntity<List<rental>> findAll(){
        List<rental> list = service.FindAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<rental> findByID(@PathVariable Integer id){
        rental result = service.findByID(id);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping
    public ResponseEntity<rental> insert(@RequestBody rental rental){
        rental = service.insert(rental);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rental.getId()).toUri();
        return ResponseEntity.created(uri).body(rental);
    }

}