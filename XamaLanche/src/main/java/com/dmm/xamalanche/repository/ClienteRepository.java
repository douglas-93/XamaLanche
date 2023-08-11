package com.dmm.xamalanche.repository;

import com.dmm.xamalanche.model.Cliente;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseCrudRepository<Cliente, Integer> {
}
