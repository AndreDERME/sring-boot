package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.exception.RecursoNaoEncontradoException;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listaprodutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarId(long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado."));
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado.");
        }
        produtoRepository.deleteById(id);
    }
}
