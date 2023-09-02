package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Colaborador;
import com.dmm.xamalanche.service.ColaboradorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/colaborador")
public class ColaboradorResource {

    @Autowired
    private ColaboradorServiceImpl colaboradorServiceImpl;

    @GetMapping
    public ResponseEntity<List<Colaborador>> findAll() {
        List<Colaborador> colaboradores = colaboradorServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(colaboradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
        Colaborador colaborador = colaboradorServiceImpl.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(colaborador);
    }

    @PostMapping
    public ResponseEntity<Colaborador> create(@RequestBody Colaborador novoColaborador) {
        Colaborador colaborador = colaboradorServiceImpl.save(novoColaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(colaborador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> update(@RequestBody Colaborador colaboradorAtualizado){
        Colaborador colaborador = colaboradorServiceImpl.update(colaboradorAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(colaborador);
    }

    @DeleteMapping
    public ResponseEntity<Colaborador> delete(@RequestBody Colaborador entity){
        colaboradorServiceImpl.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
