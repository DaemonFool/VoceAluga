package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.rental;
import com.cefet.VoceAluga.models.rental;
import com.cefet.VoceAluga.models.rental;
import com.cefet.VoceAluga.repositories.rentalRepository;
import com.cefet.VoceAluga.services.exceptions.DatabaseException;
import com.cefet.VoceAluga.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public rental insert(rental rental){
        return repository.save(rental);
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

    public rental update(Integer id, rental rental){
        try{
            rental entity = repository.getReferenceById(id);
            updateData(entity, rental);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(rental entity, rental rental) {
        entity.setDuracao(rental.getDuracao());
        entity.setPagamento(rental.getPagamento());
    }
}