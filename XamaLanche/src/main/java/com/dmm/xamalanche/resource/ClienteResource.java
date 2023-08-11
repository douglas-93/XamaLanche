package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Cliente;
import com.dmm.xamalanche.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/cliente")
public class ClienteResource {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente novoCliente) {
        Cliente cliente = clienteService.createOrUpdate(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteService.createOrUpdate(clienteAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}