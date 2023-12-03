package com.cefet.VoceAluga.controllers;

import com.cefet.VoceAluga.models.employee;
import com.cefet.VoceAluga.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/employees")
public class employeeController {
    @Autowired
    private employeeService service;
    @GetMapping
    public ResponseEntity<List<employee>> findAll(){
        List<employee> list = service.FindAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<employee> findByID(@PathVariable Integer id){
        employee result = service.findByID(id);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping
    public ResponseEntity<employee> insert(@RequestBody employee employee){
        employee = service.insert(employee);
        return ResponseEntity.ok().body(employee);
    }

}