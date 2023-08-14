package com.dmm.xamalanche.service;

import com.dmm.xamalanche.model.Loja;
import com.dmm.xamalanche.repository.LojaRepository;
import com.dmm.xamalanche.service.api.LojaService;
import com.dmm.xamalanche.utils.exceptions.AbstractServiceError;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import com.dmm.xamalanche.utils.service.AbstractCrudService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaServiceImpl extends AbstractCrudService<Loja, Integer> implements LojaService {

    @Autowired
    private LojaRepository repository;



    @Override
    protected void validate(Loja entity) throws ServiceException {
        AbstractServiceError serviceError = new AbstractServiceError();
        if(entity != null){
            if(entity.getNome() == null){
                serviceError.addErrorMessage("O nome da Loja nao pode ser vazio");
            }
        }
        serviceError.assertEmpty();
        super.beforeSave(entity);
    }

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
