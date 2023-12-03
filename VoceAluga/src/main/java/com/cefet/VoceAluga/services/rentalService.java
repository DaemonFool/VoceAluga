package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.rental;
import com.cefet.VoceAluga.models.rental;
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

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public rental update(Integer id, rental rental){
        rental entity = repository.getReferenceById(id);
        updateData(entity, rental);
        return repository.save(entity);
    }

    private void updateData(rental entity, rental rental) {
        entity.setDuracao(rental.getDuracao());
        entity.setPagamento(rental.getPagamento());
    }
}