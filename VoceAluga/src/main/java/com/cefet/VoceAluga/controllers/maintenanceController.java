package com.cefet.VoceAluga.controllers;

import com.cefet.VoceAluga.models.maintenance;
import com.cefet.VoceAluga.services.maintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/maintenances")
public class maintenanceController {
    @Autowired
    private maintenanceService service;
    @GetMapping
    public ResponseEntity<List<maintenance>> findAll(){
        List<maintenance> list = service.FindAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<maintenance> findByID(@PathVariable Integer id){
        maintenance result = service.findByID(id);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping
    public ResponseEntity<maintenance> insert(@RequestBody maintenance maintenance){
        maintenance = service.insert(maintenance);
        return ResponseEntity.ok().body(maintenance);
    }

}