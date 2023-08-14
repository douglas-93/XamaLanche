package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Venda;
import com.dmm.xamalanche.service.VendaServiceImpl;
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
    private VendaServiceImpl vendaServiceImpl;

    @GetMapping
    public ResponseEntity<List<Venda>> findAll() {
        List<Venda> vendas = vendaServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(vendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> findById(@PathVariable Integer id) {
        Venda venda = vendaServiceImpl.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(venda);
    }

    @PostMapping
    public ResponseEntity<Venda> create(@RequestBody Venda novaVenda) {
        Venda venda = vendaServiceImpl.save(novaVenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@RequestBody Venda vendaAtualizada){
        Venda venda = vendaServiceImpl.update(vendaAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(venda);
    }

    @DeleteMapping
    public ResponseEntity<Venda> delete(@RequestBody Venda entity){
        vendaServiceImpl.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
