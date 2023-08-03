package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Loja;
import com.dmm.xamalanche.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/loja")
public class LojaResource {

    @Autowired private LojaService lojaService;

    @GetMapping
    public ResponseEntity<List<Loja>> findAll(){
        List<Loja> lojas = lojaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lojas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loja> findById(@PathVariable Integer id) {
        Loja loja = lojaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(loja);
    }

    @PostMapping
    public ResponseEntity<Loja> create(@RequestBody Loja novaLoja) {
        Loja loja = lojaService.createOrUpdate(novaLoja);
        return ResponseEntity.status(HttpStatus.CREATED).body(loja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loja> update(@RequestBody Loja lojaAtualizada) {
        Loja loja = lojaService.createOrUpdate(lojaAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(loja);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        lojaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
