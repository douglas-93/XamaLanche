package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Produto;
import com.dmm.xamalanche.service.ProdutoSevice;
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
    private ProdutoSevice produtoSevice;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = produtoSevice.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto produto = produtoSevice.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto novoProduto) {
        Produto produto = produtoSevice.createOrUpdate(novoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto produtoAtualizado){
        Produto produto = produtoSevice.createOrUpdate(produtoAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> delete(@PathVariable Integer id){
        produtoSevice.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
