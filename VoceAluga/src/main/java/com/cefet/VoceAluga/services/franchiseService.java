package com.cefet.VoceAluga.services;

import com.cefet.VoceAluga.models.franchise;
import com.cefet.VoceAluga.models.franchise;
import com.cefet.VoceAluga.models.franchise;
import com.cefet.VoceAluga.repositories.franchiseRepository;
import com.cefet.VoceAluga.services.exceptions.DatabaseException;
import com.cefet.VoceAluga.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public franchise insert(franchise franchise){
        return repository.save(franchise);
    }

    public void delete(Integer id){
        try{
            repository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch(DataIntegrityViolationException er){
            throw new DatabaseException(er.getMessage());
        }
    }

    public franchise update(Integer id, franchise franchise){
        franchise entity = repository.getReferenceById(id);
        updateData(entity, franchise);
        return repository.save(entity);
    }

    private void updateData(franchise entity, franchise franchise) {
        entity.setNome(franchise.getNome());
        entity.setEndereco(franchise.getEndereco());
        entity.setEmail(franchise.getEmail());
        entity.setTelefone(franchise.getTelefone());
        entity.setHorario(franchise.getHorario());
    }
}
