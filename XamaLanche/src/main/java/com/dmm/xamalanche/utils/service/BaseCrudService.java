package com.dmm.xamalanche.utils.service;

import com.dmm.xamalanche.utils.repository.BaseCrudRepository;

public interface BaseCrudService<T, ID> {

    BaseCrudRepository getRepository();
}
