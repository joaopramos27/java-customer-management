package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    @PatchMapping("/{id}/clientes")
    public Cliente ajustarCliente(@PathVariable Long id, @RequestParam String nome) {
        return service.atualizarCliente(id, nome);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
