package com.dmm.xamalanche.repository;

import com.dmm.xamalanche.model.Promocao;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PromocaoRepository extends BaseCrudRepository<Promocao, Integer>{

}
