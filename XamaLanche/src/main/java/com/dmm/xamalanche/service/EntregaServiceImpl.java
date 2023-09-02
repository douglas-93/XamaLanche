package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Entrega;
import com.dmm.xamalanche.repository.EntregaRepository;
import com.dmm.xamalanche.service.api.EntregaService;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import com.dmm.xamalanche.utils.service.AbstractCrudService;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaServiceImpl extends AbstractCrudService<Entrega, Integer> implements EntregaService {
    @Autowired
    private EntregaRepository repository;

//    public List<Entrega> findAll(){
//        return repository.findAll();
//    }
//
//    public Entrega findById(Integer id){
//        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entrega não localizada!"));
//    }
//
//    public Entrega createOrUpdate(Entrega entrega){
//        return repository.save(entrega);
//    }
//
//    public void delete(Integer id){
//        Entrega entrega = this.findById(id);
//        repository.delete(entrega);
//    }

    @Override
    public BaseCrudRepository getRepository() {
        return null;
    }
}
