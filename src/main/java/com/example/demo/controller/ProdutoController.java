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
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @PatchMapping("/{id}/estoque")
    public Produto ajustarEstoque(@PathVariable Long id, @RequestParam Integer quantidade) {
        return service.atualizarEstoque(id, quantidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
