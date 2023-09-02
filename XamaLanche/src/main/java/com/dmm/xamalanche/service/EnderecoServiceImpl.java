package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Endereco;
import com.dmm.xamalanche.repository.EnderecoRepository;
import com.dmm.xamalanche.service.api.EnderecoService;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import com.dmm.xamalanche.utils.service.AbstractCrudService;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl extends AbstractCrudService<Endereco, Integer> implements EnderecoService {
    @Autowired
    private EnderecoRepository repository;

//    public List<Endereco> findAll(){
//        return repository.findAll();
//    }
//
//    public Endereco findById(Integer id){
//        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Endereço não localizado!"));
//    }
//
//    public Endereco createOrUpdate(Endereco endereco){
//        return repository.save(endereco);
//    }
//
//    public void delete(Integer id){
//        Endereco endereco = this.findById(id);
//        repository.delete(endereco);
//    }

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
