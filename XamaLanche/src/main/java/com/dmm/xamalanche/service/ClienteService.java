package com.dmm.xamalanche.service;

import com.dmm.xamalanche.model.Cliente;
import com.dmm.xamalanche.repository.ClienteRepository;
import com.dmm.xamalanche.utils.service.BaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements BaseCrudService<Cliente, Integer> {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createOrUpdate(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        Sort ordemAlfabetica = Sort.by(Sort.Direction.ASC, "nome");
        return clienteRepository.findAll(ordemAlfabetica);
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não localizado!"));
    }

    public void delete(Integer id) {
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
    }
}
