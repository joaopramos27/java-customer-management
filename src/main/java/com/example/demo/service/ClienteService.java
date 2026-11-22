package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.web.service.registry.HttpServiceGroup.ClientType;

import java.util.*;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        if (cliente.getNome().isBlank()) {
            throw new IllegalArgumentException("O cliente deve possuir um nome!");
        }
        return repository.save(cliente);
    }

    public Cliente atualizarCliente(Long id, String novoNome) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        cliente.setNome(novoNome);
        return repository.save(cliente);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
