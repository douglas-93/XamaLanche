package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Cardapio;
import com.dmm.xamalanche.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/cardapio")
public class CardapioResource {
    @Autowired
    private CardapioService cardapioService;

    @GetMapping
    public ResponseEntity<List<Cardapio>> findAll(){
        List<Cardapio> cardapios = cardapioService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cardapios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cardapio> findById(@PathVariable Integer id){
        Cardapio cardapio = cardapioService.findById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(cardapio);
    }

    @PostMapping
    public ResponseEntity<Cardapio> create(@RequestBody Cardapio novoCardapio){
        Cardapio cardapio = cardapioService.createOrUpdate(novoCardapio);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardapio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cardapio> update(@RequestBody Cardapio cardapioAtualizado){
        Cardapio cardapio = cardapioService.createOrUpdate(cardapioAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(cardapio);
    }

    @DeleteMapping
    public ResponseEntity<Cardapio> delete(@PathVariable Integer id){
        cardapioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
