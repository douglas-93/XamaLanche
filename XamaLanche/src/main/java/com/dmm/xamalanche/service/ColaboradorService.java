package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Colaborador;
import com.dmm.xamalanche.repository.ColaboradorRepository;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService implements BaseCrudService<Colaborador, Integer> {
    @Autowired
    private ColaboradorRepository repository;

    public List<Colaborador> findAll(){
        return repository.findAll();
    }

    public Colaborador findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Colaborador não localizado!"));
    }

    public Colaborador createOrUpdate(Colaborador colaborador){
        return repository.save(colaborador);
    }

    public void delete(Integer id){
        Colaborador colaborador = this.findById(id);
        repository.delete(colaborador);
    }

}
