package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.client;
import com.cefet.VoceAluga.repositories.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class clientService {

    @Autowired
    private clientRepository repository;
    public List<client> FindAll(){
        return repository.findAll();
    }
    public client findByID(Integer id){
        return repository.findById(id).get();
    }
    public client insert(client client){
        return repository.save(client);
    }
}
