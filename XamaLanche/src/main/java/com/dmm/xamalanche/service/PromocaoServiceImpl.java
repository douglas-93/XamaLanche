package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Promocao;
import com.dmm.xamalanche.repository.PromocaoRepository;
import com.dmm.xamalanche.service.api.PromocaoService;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import com.dmm.xamalanche.utils.service.AbstractCrudService;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocaoServiceImpl extends AbstractCrudService<Promocao, Integer> implements PromocaoService {
    @Autowired
    private PromocaoRepository repository;

//    public List<Promocao> findAll(){
//        return repository.findAll();
//    }
//
//    public Promocao findById(Integer id){
//        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Promocão não localizada!"));
//    }
//
//    public Promocao createOrUpdate(Promocao promocao){
//        return repository.save(promocao);
//    }
//
//    public void delete(Integer id){
//        Promocao promocao = this.findById(id);
//        repository.delete(promocao);
//    }

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
