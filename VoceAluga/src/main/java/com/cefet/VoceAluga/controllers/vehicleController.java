package com.cefet.VoceAluga.controllers;

import com.cefet.VoceAluga.models.vehicle;
import com.cefet.VoceAluga.models.vehicle;
import com.cefet.VoceAluga.services.vehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/vehicles")
public class vehicleController {
    @Autowired
    private vehicleService service;
    @GetMapping
    public ResponseEntity<List<vehicle>> findAll(){
        List<vehicle> list = service.FindAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<vehicle> findByID(@PathVariable Integer id){
        vehicle result = service.findByID(id);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping
    public ResponseEntity<vehicle> insert(@RequestBody vehicle vehicle){
        vehicle = service.insert(vehicle);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vehicle.getId()).toUri();
        return ResponseEntity.created(uri).body(vehicle);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<vehicle> update(@PathVariable Integer id, @RequestBody vehicle vehicle){
        vehicle = service.update(id, vehicle);
        return ResponseEntity.ok().body(vehicle);
    }
}
