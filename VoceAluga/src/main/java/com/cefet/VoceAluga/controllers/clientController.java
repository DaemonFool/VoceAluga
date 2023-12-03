package com.cefet.VoceAluga.controllers;

import com.cefet.VoceAluga.services.clientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cefet.VoceAluga.models.client;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<client> insert(@RequestBody client client){
        client = service.insert(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<client> update(@PathVariable Integer id,@RequestBody client client){
        client = service.update(id, client);
        return ResponseEntity.ok().body(client);
    }

}
