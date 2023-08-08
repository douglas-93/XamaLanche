package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Colaborador;
import com.dmm.xamalanche.service.ColaboradorService;
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
    private ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> findAll() {
        List<Colaborador> colaboradores = colaboradorService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(colaboradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
        Colaborador colaborador = colaboradorService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(colaborador);
    }

    @PostMapping
    public ResponseEntity<Colaborador> create(@RequestBody Colaborador novoColaborador) {
        Colaborador colaborador = colaboradorService.createOrUpdate(novoColaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(colaborador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> update(@RequestBody Colaborador colaboradorAtualizado){
        Colaborador colaborador = colaboradorService.createOrUpdate(colaboradorAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(colaborador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Colaborador> delete(@PathVariable Integer id){
        colaboradorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
