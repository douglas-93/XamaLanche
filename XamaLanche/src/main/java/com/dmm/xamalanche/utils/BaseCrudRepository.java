package com.dmm.xamalanche.utils;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseCrudRepository<T,ID> extends JpaRepository<T,ID> {

    T saveOrUpdate(T entity);

    T update(T entity);

    T getById(ID id);


}
