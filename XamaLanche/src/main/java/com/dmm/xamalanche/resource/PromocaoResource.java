package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Promocao;
import com.dmm.xamalanche.service.PromocaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/promocao")
public class PromocaoResource {

    @Autowired
    private PromocaoServiceImpl promocaoServiceImpl;

    @GetMapping
    public ResponseEntity<List<Promocao>> findAll() {
        List<Promocao> promocao = promocaoServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(promocao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocao> findById(@PathVariable Integer id) {
        Promocao promocao = promocaoServiceImpl.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(promocao);
    }

    @PostMapping
    public ResponseEntity<Promocao> create(@RequestBody Promocao novaPromocao) {
        Promocao promocao = promocaoServiceImpl.save(novaPromocao);
        return ResponseEntity.status(HttpStatus.CREATED).body(promocao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocao> update(@RequestBody Promocao promocaoAtualizada){
        Promocao promocao = promocaoServiceImpl.update(promocaoAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(promocao);
    }

    @DeleteMapping
    public ResponseEntity<Promocao> delete(@RequestBody Promocao entity){
        promocaoServiceImpl.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
