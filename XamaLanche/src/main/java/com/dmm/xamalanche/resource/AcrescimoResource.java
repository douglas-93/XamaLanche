package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Acrescimo;
import com.dmm.xamalanche.service.AcrescimoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/acrescimo")
public class AcrescimoResource {

    @Autowired
    private AcrescimoServiceImpl acrescimoServiceImpl;

    @GetMapping
    public ResponseEntity<List<Acrescimo>> findAll() {
        List<Acrescimo> acrescimos = acrescimoServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(acrescimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acrescimo> findById(@PathVariable Integer id) {
        Acrescimo acrescimo = acrescimoServiceImpl.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @PostMapping
    public ResponseEntity<Acrescimo> create(@RequestBody Acrescimo novoAcrescimo) {
        Acrescimo acrescimo = acrescimoServiceImpl.save(novoAcrescimo);
        return ResponseEntity.status(HttpStatus.CREATED).body(acrescimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acrescimo> update(@RequestBody Acrescimo acrescimoAtualizado){
        Acrescimo acrescimo = acrescimoServiceImpl.update(acrescimoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(acrescimo);
    }

    @DeleteMapping
    public ResponseEntity<Acrescimo> delete(@RequestBody Acrescimo entity){
        acrescimoServiceImpl.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
