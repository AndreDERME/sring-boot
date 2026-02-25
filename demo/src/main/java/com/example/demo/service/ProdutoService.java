package com.example.demo.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.example.demo.exceptions.RecursoNaoEncontradoExceptions;
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

    public Produto buscarId (Long Id) {
        return produtoRepository.findById(Id)
            .orElseThrow(() -> new RecursoNaoEncontradoExceptions("Produto com o ID"+Id+"não encontrado" ));
    }
    
    public Produto salvarProduto (Produto produto) {
        return produtoRepository.save(produto); 
    }

    public void deletarProduto(Long id) {

        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoExceptions("Produto com ID"+id +"não encontrado");
        }
         produtoRepository.deleteById(id);
    }
}
