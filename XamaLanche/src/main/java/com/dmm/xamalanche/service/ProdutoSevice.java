package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Produto;
import com.dmm.xamalanche.repository.ProdutoRepository;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoSevice implements BaseCrudService<Produto, Integer> {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não localizado!"));
    }

    public Produto createOrUpdate(Produto produto){
        return repository.save(produto);
    }

    public void delete(Integer id){
        Produto produto = this.findById(id);
        repository.delete(produto);
    }

}
