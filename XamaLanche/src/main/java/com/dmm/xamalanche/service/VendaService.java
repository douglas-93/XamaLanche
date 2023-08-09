package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Venda;
import com.dmm.xamalanche.repository.VendaRepository;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService implements BaseCrudService<Venda, Integer> {
    @Autowired
    private VendaRepository repository;

    public List<Venda> findAll(){
        return repository.findAll();
    }

    public Venda findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Venda não localizada!"));
    }

    public Venda createOrUpdate(Venda venda){
        return repository.save(venda);
    }

    public void delete(Integer id){
        Venda venda = this.findById(id);
        repository.delete(venda);
    }

}
