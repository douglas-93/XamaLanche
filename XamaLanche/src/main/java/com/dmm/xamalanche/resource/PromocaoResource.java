package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Promocao;
import com.dmm.xamalanche.service.PromocaoService;
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
    private PromocaoService promocaoService;

    @GetMapping
    public ResponseEntity<List<Promocao>> findAll() {
        List<Promocao> promocao = promocaoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(promocao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocao> findById(@PathVariable Integer id) {
        Promocao promocao = promocaoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(promocao);
    }

    @PostMapping
    public ResponseEntity<Promocao> create(@RequestBody Promocao novaPromocao) {
        Promocao promocao = promocaoService.createOrUpdate(novaPromocao);
        return ResponseEntity.status(HttpStatus.CREATED).body(promocao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocao> update(@RequestBody Promocao promocaoAtualizada){
        Promocao promocao = promocaoService.createOrUpdate(promocaoAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(promocao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Promocao> delete(@PathVariable Integer id){
        promocaoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
