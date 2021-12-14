package br.org.generation.Farmacia.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.org.generation.Farmacia.model.Categoria;

@Repository
public interface CategoriaRepository {


	public List <Categoria> findAllByCategoriaContainingIgnoreCase(String categoria);

	public boolean existsById(Long id);

	public Object findAll();

	public Object findById(Long id);

}

