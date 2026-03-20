package com.atividade.GerenciamentoCategoria.repository;

import com.atividade.GerenciamentoCategoria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
