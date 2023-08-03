package com.dmm.xamalanche.service;

import com.dmm.xamalanche.model.Loja;
import com.dmm.xamalanche.repository.LojaRepository;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojaService implements BaseCrudService<Loja, Integer> {

    @Autowired
    private LojaRepository repository;

    public List<Loja> findAll() {
        return repository.findAll();
    }

    public Loja findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Loja não encontrada!"));
    }

    public Loja createOrUpdate(Loja loja) {
        return repository.save(loja);
    }

    public void delete(Integer id) {
        Loja loja = this.findById(id);
        repository.delete(loja);
    }

}