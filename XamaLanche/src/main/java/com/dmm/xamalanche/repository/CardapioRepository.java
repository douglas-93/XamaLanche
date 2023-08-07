package com.dmm.xamalanche.repository;

import com.dmm.xamalanche.model.Cardapio;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends BaseCrudRepository<Cardapio, Integer> {

}
