package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.employee;
import com.cefet.VoceAluga.repositories.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class employeeService {

    @Autowired
    private employeeRepository repository;
    public List<employee> FindAll(){
        return repository.findAll();
    }
    public employee findByID(Integer id){
        return repository.findById(id).get();
    }
    public employee insert(employee employee){
        return repository.save(employee);
    }
}
