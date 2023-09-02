package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Cardapio;
import com.dmm.xamalanche.service.CardapioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/cardapio")
public class CardapioResource {
    @Autowired
    private CardapioServiceImpl cardapioServiceImpl;

    @GetMapping
    public ResponseEntity<List<Cardapio>> findAll(){
        List<Cardapio> cardapios = cardapioServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cardapios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cardapio> findById(@PathVariable Integer id){
        Cardapio cardapio = cardapioServiceImpl.getById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(cardapio);
    }

    @PostMapping
    public ResponseEntity<Cardapio> create(@RequestBody Cardapio novoCardapio){
        Cardapio cardapio = cardapioServiceImpl.save(novoCardapio);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardapio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cardapio> update(@RequestBody Cardapio cardapioAtualizado){
        Cardapio cardapio = cardapioServiceImpl.update(cardapioAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(cardapio);
    }

    @DeleteMapping
    public ResponseEntity<Cardapio> delete(@RequestBody Cardapio entity){
        cardapioServiceImpl.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
