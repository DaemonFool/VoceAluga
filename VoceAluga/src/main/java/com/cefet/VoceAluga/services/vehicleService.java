package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.vehicle;
import com.cefet.VoceAluga.models.vehicle;
import com.cefet.VoceAluga.models.vehicle;
import com.cefet.VoceAluga.repositories.vehicleRepository;
import com.cefet.VoceAluga.services.exceptions.DatabaseException;
import com.cefet.VoceAluga.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class vehicleService {

    @Autowired
    private vehicleRepository repository;
    public List<vehicle> FindAll(){
        return repository.findAll();
    }
    public vehicle findByID(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public vehicle insert(vehicle vehicle){
        return repository.save(vehicle);
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

    public vehicle update(Integer id, vehicle vehicle){
       try {
            vehicle entity = repository.getReferenceById(id);
            updateData(entity, vehicle);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(vehicle entity, vehicle vehicle) {
        entity.setCategoria(vehicle.getCategoria());
        entity.setCor(vehicle.getCor());
    }
}