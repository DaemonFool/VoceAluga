package com.cefet.VoceAluga.services;

import com.cefet.VoceAluga.models.franchise;
import com.cefet.VoceAluga.repositories.franchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class franchiseService {

    @Autowired
    private franchiseRepository repository;
    public List<franchise> FindAll(){
        return repository.findAll();
    }
    public franchise findByID(Integer id){
        return repository.findById(id).get();
    }
    public franchise insert(franchise franchise){
        return repository.save(franchise);
    }
}
