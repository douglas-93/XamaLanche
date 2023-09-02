package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Endereco;
import com.dmm.xamalanche.service.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoServiceImpl enderecoServiceImpl;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> enderecos = enderecoServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
        Endereco endereco = enderecoServiceImpl.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody Endereco novoEndereco) {
        Endereco endereco = enderecoServiceImpl.save(novoEndereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@RequestBody Endereco enderecoAtualizado){
        Endereco endereco = enderecoServiceImpl.update(enderecoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @DeleteMapping
    public ResponseEntity<Endereco> delete(@RequestBody Endereco entity){
        enderecoServiceImpl.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
