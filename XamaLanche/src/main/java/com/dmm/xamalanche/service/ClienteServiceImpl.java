package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Cliente;
import com.dmm.xamalanche.repository.ClienteRepository;
import com.dmm.xamalanche.service.api.ClienteService;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import com.dmm.xamalanche.utils.service.AbstractCrudService;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl extends AbstractCrudService<Cliente,Integer> implements ClienteService {
    @Autowired
    private ClienteRepository repository;

//    public List<Cliente> findAll(){
//        return repository.findAll();
//    }
//
//    public Cliente findById(Integer id){
//        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não localizado!"));
//    }
//
//    public Cliente createOrUpdate(Cliente cliente){
//        return repository.save(cliente);
//    }
//
//    public void delete(Integer id){
//        Cliente cliente = this.findById(id);
//        repository.delete(cliente);
//    }

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
