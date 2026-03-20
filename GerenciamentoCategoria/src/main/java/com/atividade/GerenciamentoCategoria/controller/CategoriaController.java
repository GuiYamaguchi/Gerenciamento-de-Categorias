package com.atividade.GerenciamentoCategoria.controller;

import com.atividade.GerenciamentoCategoria.entity.Categoria;
import com.atividade.GerenciamentoCategoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){
        Categoria requeste = categoriaService.criarCategoria(categoria);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(requeste.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodasCategorias(){
        List<Categoria> requeste = categoriaService.listarTodasCategorias();
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> listarCategoriaId(@PathVariable Long id){
        Optional<Categoria> requeste = categoriaService.listarCategoriaId(id);
        return ResponseEntity.ok(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
