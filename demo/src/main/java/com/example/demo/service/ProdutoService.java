package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService (ProdutoRepository produtoRepository) {
        this.produtoRepository =produtoRepository;
    }

    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarId (Long Id) {
        return produtoRepository.findById(Id);
    }
    
    public Produto salvarProduto (Produto produto) {
        return produtoRepository.save(produto); 
    }

    public void deletarProduto(Long id) {
         produtoRepository.deleteById(id);
    }
}
