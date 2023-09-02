package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Entrega;
import com.dmm.xamalanche.service.EntregaServiceImpl;
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
    private EntregaServiceImpl entregaServiceImpl;

    @GetMapping
    public ResponseEntity<List<Entrega>> findAll() {
        List<Entrega> entregas = entregaServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(entregas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> findById(@PathVariable Integer id) {
        Entrega entrega = entregaServiceImpl.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(entrega);
    }

    @PostMapping
    public ResponseEntity<Entrega> create(@RequestBody Entrega novaEntrega) {
        Entrega entrega = entregaServiceImpl.save(novaEntrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrega);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrega> update(@RequestBody Entrega entregAtualizada){
        Entrega entrega = entregaServiceImpl.update(entregAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(entrega);
    }

    @DeleteMapping
    public ResponseEntity<Entrega> delete(@RequestBody Entrega entity){
        entregaServiceImpl.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
