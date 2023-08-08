package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Venda;
import com.dmm.xamalanche.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/venda")
public class VendaResource {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<Venda>> findAll() {
        List<Venda> vendas = vendaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(vendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> findById(@PathVariable Integer id) {
        Venda venda = vendaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(venda);
    }

    @PostMapping
    public ResponseEntity<Venda> create(@RequestBody Venda novaVenda) {
        Venda venda = vendaService.createOrUpdate(novaVenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@RequestBody Venda vendaAtualizada){
        Venda venda = vendaService.createOrUpdate(vendaAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(venda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Venda> delete(@PathVariable Integer id){
        vendaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
