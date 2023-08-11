package com.dmm.xamalanche.repository;

import com.dmm.xamalanche.model.Produto;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends BaseCrudRepository<Produto, Integer>{

}
