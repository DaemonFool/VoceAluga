package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.rental;
import com.cefet.VoceAluga.repositories.rentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class rentalService {

    @Autowired
    private rentalRepository repository;
    public List<rental> FindAll(){
        return repository.findAll();
    }
    public rental findByID(Integer id){
        return repository.findById(id).get();
    }
    public rental insert(rental rental){
        return repository.save(rental);
    }
}