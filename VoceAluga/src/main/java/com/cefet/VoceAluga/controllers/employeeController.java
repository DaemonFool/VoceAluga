package com.cefet.VoceAluga.controllers;

import com.cefet.VoceAluga.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cefet.VoceAluga.models.employee;

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


}