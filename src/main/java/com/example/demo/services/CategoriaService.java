package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;

@Service

// criando um operacao que busca um categoria por codigo
public class CategoriaService {

	// Autowired instancia a dependia automaticamente pelo spring
	@Autowired
	private CategoriaRepository repo;

	/*
	 * vamos usa o objeto criado repo para busca no banco de dados uma categoria
	 * da um certo id
	 */
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		}
		
	}

