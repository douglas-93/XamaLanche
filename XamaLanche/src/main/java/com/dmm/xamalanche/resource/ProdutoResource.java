package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Produto;
import com.dmm.xamalanche.service.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = produtoServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto produto = produtoServiceImpl.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto novoProduto) {
        Produto produto = produtoServiceImpl.save(novoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto produtoAtualizado){
        Produto produto = produtoServiceImpl.update(produtoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @DeleteMapping
    public ResponseEntity<Produto> delete(@RequestBody Produto entity){
        produtoServiceImpl.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
