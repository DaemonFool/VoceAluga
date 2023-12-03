package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.vehicle;
import com.cefet.VoceAluga.models.vehicle;
import com.cefet.VoceAluga.models.vehicle;
import com.cefet.VoceAluga.repositories.vehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return repository.findById(id).get();
    }
    public vehicle insert(vehicle vehicle){
        return repository.save(vehicle);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public vehicle update(Integer id, vehicle vehicle){
        vehicle entity = repository.getReferenceById(id);
        updateData(entity, vehicle);
        return repository.save(entity);
    }

    private void updateData(vehicle entity, vehicle vehicle) {
        entity.setCategoria(vehicle.getCategoria());
        entity.setCor(vehicle.getCor());
    }
}