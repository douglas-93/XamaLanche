package com.dmm.xamalanche.repository.api;

import com.dmm.xamalanche.model.Loja;
import com.dmm.xamalanche.utils.BaseCrudRepository;

import java.util.List;

public interface lojaRepository extends BaseCrudRepository<Loja, Integer> {

    List<Loja> list(Loja loja, Integer offset, Integer limit);

}
