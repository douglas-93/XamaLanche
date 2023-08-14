package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Acrescimo;
import com.dmm.xamalanche.repository.AcrescimoRepository;
import com.dmm.xamalanche.service.api.AcrescimoService;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import com.dmm.xamalanche.utils.service.AbstractCrudService;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcrescimoServiceImpl extends AbstractCrudService<Acrescimo,Integer> implements AcrescimoService {
    @Autowired
    private AcrescimoRepository repository;

//    public List<Acrescimo> findAll(){
//        return repository.findAll();
//    }
//
//    public Acrescimo findById(Integer id){
//        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Acrescimo não localizado!"));
//    }
//
//    public Acrescimo createOrUpdate(Acrescimo acrescimo){
//        return repository.save(acrescimo);
//    }
//
//    public void delete(Integer id){
//        Acrescimo acrescimo = this.findById(id);
//        repository.delete(acrescimo);
//    }

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
