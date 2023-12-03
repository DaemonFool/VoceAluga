package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.client;
import com.cefet.VoceAluga.repositories.clientRepository;
import com.cefet.VoceAluga.services.exceptions.ResourceNotFoundException;
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
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public client insert(client client){
        return repository.save(client);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public client update(Integer id, client client){
        client entity = repository.getReferenceById(id);
        updateData(entity, client);
        return repository.save(entity);
    }

    private void updateData(client entity, client client) {
        entity.setCPF(client.getCPF());
        entity.setEndereco(client.getEndereco());
        entity.setNome(client.getNome());
        entity.setTelefone(client.getTelefone());
        entity.setDt_nasc(client.getDt_nasc());
    }
}
