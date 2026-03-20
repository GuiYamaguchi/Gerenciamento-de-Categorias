package com.atividade.GerenciamentoCategoria.service;

import com.atividade.GerenciamentoCategoria.entity.Categoria;
import com.atividade.GerenciamentoCategoria.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarTodasCategorias(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> listarCategoriaId(Long id){
        return categoriaRepository.findById(id);
    }

    public void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
