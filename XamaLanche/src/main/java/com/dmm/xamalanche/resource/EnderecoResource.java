package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Endereco;
import com.dmm.xamalanche.service.EnderecoService;
import com.dmm.xamalanche.service.LojaService;
import org.hibernate.type.descriptor.java.BlobJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> enderecos = enderecoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
        Endereco endereco = enderecoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody Endereco novoEndereco) {
        Endereco endereco = enderecoService.createOrUpdateEndereco(novoEndereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@RequestBody Endereco enderecoAtualizado){
        Endereco endereco = enderecoService.createOrUpdateEndereco(enderecoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Endereco> delete(@PathVariable Integer id){
        enderecoService.deleteEndereco(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
