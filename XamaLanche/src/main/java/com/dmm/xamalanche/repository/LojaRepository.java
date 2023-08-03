package com.dmm.xamalanche.repository;

import com.dmm.xamalanche.model.Loja;
import com.dmm.xamalanche.utils.repository.BaseCrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LojaRepository extends BaseCrudRepository<Loja, Integer> {

    /*Deixar a query apenas de exemplo
    @Query("SELECT L FROM Loja L WHERE L.nome = :nome")
    public List<Loja> buscaPorNome(String nome);
*/
}

