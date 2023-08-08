package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Entrega;
import com.dmm.xamalanche.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/entrega")
public class EntregaResource {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public ResponseEntity<List<Entrega>> findAll() {
        List<Entrega> entregas = entregaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(entregas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> findById(@PathVariable Integer id) {
        Entrega entrega = entregaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(entrega);
    }

    @PostMapping
    public ResponseEntity<Entrega> create(@RequestBody Entrega novaEntrega) {
        Entrega entrega = entregaService.createOrUpdate(novaEntrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrega> update(@RequestBody Entrega entregAtualizada){
        Entrega entrega = entregaService.createOrUpdate(entregAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(entrega);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entrega> delete(@PathVariable Integer id){
        entregaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
