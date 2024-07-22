package com.wilker.crud_farmacia.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wilker.crud_farmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Object findAllByNomeContainingIgnoreCase(String nome);
}