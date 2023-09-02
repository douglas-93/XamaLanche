package com.dmm.xamalanche.resource;

import com.dmm.xamalanche.model.Cliente;
import com.dmm.xamalanche.service.ClienteServiceImpl;
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
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente cliente = clienteServiceImpl.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente novoCliente) {
        Cliente cliente = clienteServiceImpl.save(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente clienteAtualizado){
        Cliente cliente = clienteServiceImpl.update(clienteAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @DeleteMapping
    public ResponseEntity<Cliente> delete(@RequestBody Cliente entity){
        clienteServiceImpl.delete(entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
