package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cliente;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service

// criando um operacao que busca um categoria por codigo
public class ClienteService {

	// Autowired instancia a dependecia automaticamente pelo spring
	@Autowired
	private ClienteRepository repo;

	/*
	 * vamos usa o objeto criado repo para busca no banco de dados uma categoria
	 * da um certo id
	 */
	public Cliente busca(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
	}

