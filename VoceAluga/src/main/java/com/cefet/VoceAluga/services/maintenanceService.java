package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.maintenance;
import com.cefet.VoceAluga.models.maintenance;
import com.cefet.VoceAluga.models.maintenance;
import com.cefet.VoceAluga.repositories.maintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class maintenanceService {

    @Autowired
    private maintenanceRepository repository;
    public List<maintenance> FindAll(){
        return repository.findAll();
    }
    public maintenance findByID(Integer id){
        return repository.findById(id).get();
    }
    public maintenance insert(maintenance maintenance){
        return repository.save(maintenance);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public maintenance update(Integer id, maintenance maintenance){
        maintenance entity = repository.getReferenceById(id);
        updateData(entity, maintenance);
        return repository.save(entity);
    }

    private void updateData(maintenance entity, maintenance maintenance) {
        entity.setSitveiculo(maintenance.getSitveiculo());
        entity.setValor(maintenance.getValor());
    }
}


