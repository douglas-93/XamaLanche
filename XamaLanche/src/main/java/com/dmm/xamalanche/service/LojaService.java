package com.dmm.xamalanche.service;

import com.dmm.xamalanche.model.Loja;
import com.dmm.xamalanche.repository.LojaRepository;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService implements BaseCrudService<Loja,Integer> {

    @Autowired private LojaRepository repository;

    public List<Loja> findAll() {
        return repository.findAll();
    }

}
