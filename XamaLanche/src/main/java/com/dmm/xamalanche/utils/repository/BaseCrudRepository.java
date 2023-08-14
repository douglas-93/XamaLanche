package com.dmm.xamalanche.utils.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface BaseCrudRepository<T,ID> extends JpaRepository<T,ID> {

}
