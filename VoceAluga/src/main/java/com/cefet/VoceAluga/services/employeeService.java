package com.cefet.VoceAluga.services;
import com.cefet.VoceAluga.models.employee;
import com.cefet.VoceAluga.repositories.employeeRepository;
import com.cefet.VoceAluga.services.exceptions.ResourceNotFoundException;
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
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public employee insert(employee employee){
        return repository.save(employee);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
    public employee update(Integer id, employee employee){
        employee entity = repository.getReferenceById(id);
        updateData(entity, employee);
        return repository.save(entity);
    }
    private void updateData(employee entity, employee employee) {
        entity.setCPF(employee.getCPF());
        entity.setEndereco(employee.getEndereco());
        entity.setFilial(employee.getFilial());
        entity.setFuncao(employee.getFuncao());
        entity.setDt_nasc(employee.getDt_nasc());
        entity.setHorario(employee.getHorario());
        entity.setNome(employee.getNome());
        entity.setTelefone(employee.getTelefone());
    }
}
