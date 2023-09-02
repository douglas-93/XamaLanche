package com.dmm.xamalanche.service;


import com.dmm.xamalanche.model.Cliente;
import com.dmm.xamalanche.repository.ClienteRepository;
import com.dmm.xamalanche.service.api.ClienteService;
import com.dmm.xamalanche.utils.CollectionMetodsUtils;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import com.dmm.xamalanche.utils.service.AbstractCrudService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends AbstractCrudService<Cliente,Integer> implements ClienteService {
    @Autowired
    private ClienteRepository repository;

    /**
     * Setando a referência do cliente no endereço
    **/
    @Override
    protected void beforeSave(Cliente entity) throws ServiceException {
        if (CollectionMetodsUtils.isNotObjectEmpty(entity)) {
            entity.getEndereco().forEach(e -> {
                e.setCliente(entity);
            });
        }
        super.beforeSave(entity);
    }

    @Override
    public BaseCrudRepository getRepository() {
        return repository;
    }
}
