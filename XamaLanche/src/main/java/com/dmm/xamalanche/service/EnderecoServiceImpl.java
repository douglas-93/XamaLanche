package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Endereco;
import com.dmm.xamalanche.repository.EnderecoRepository;
import com.dmm.xamalanche.service.api.EnderecoService;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import com.dmm.xamalanche.utils.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl extends AbstractCrudService<Endereco, Integer> implements EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
