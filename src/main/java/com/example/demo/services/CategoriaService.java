package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service

// criando um operacao que busca um categoria por codigo
public class CategoriaService {

	// Autowired instancia a dependecia automaticamente pelo spring
	@Autowired
	private CategoriaRepository repo;

	/*
	 * vamos usa o objeto criado repo para busca no banco de dados uma categoria
	 * da um certo id
	 */
	public Categoria busca(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
	
	public Categoria insert(Categoria obj){
		obj.setId(null);
		return repo.save(obj);
	}
	}

