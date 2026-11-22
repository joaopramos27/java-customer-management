package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.web.service.registry.HttpServiceGroup.ClientType;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto salvar(Produto produto) {
        if (produto.getQuantidadeEstoque() < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo!");
        }
        return repository.save(produto);
    }

    public Produto atualizarEstoque(Long id, Integer novaQuantidade) {
        Produto produto = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        produto.setQuantidadeEstoque(novaQuantidade);
        return repository.save(produto);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
