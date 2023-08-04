package com.dmm.xamalanche.service;

import com.dmm.xamalanche.model.Cardapio;
import com.dmm.xamalanche.repository.CardapioRepository;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService implements BaseCrudService<Cardapio, Integer> {

    @Autowired
    public CardapioRepository cardapioRepository;

    public List<Cardapio> findAll(){
        return cardapioRepository.findAll();
    }

    public Cardapio findById(Integer id){
        return cardapioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cardápio não localizado!"));
    }

    public void delete(Integer id){
        Cardapio cardapio = findById(id);
        cardapioRepository.delete(cardapio);
    }

    public Cardapio createOrUpdate(Cardapio cardapio){
        return cardapioRepository.save(cardapio);

    }

}
