package com.dmm.xamalanche.repository;

import com.dmm.xamalanche.model.Loja;
import com.dmm.xamalanche.repository.api.lojaRepository;
import com.dmm.xamalanche.utils.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class lojaRepositoryImpl extends AbstractCrudRepository<Loja, Integer> implements lojaRepository {
    @Override
    public List<Loja> list(Loja loja, Integer offset, Integer limit) {
        return null;
    }
}
