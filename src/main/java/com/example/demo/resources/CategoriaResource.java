package com.example.demo.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Categoria;
import com.example.demo.services.CategoriaService;

/* rest controller anotação para o rest precisa ser importada
*estamos criando uma classe que vai ser um controlado rest
* que vai responde ao endpoint categorias.
*/
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	/*
	 * requestmapping verbo http para uma requisição basica get. agora o metodo
	 * vai se chama find e vai ter 2 endpoint /categorias/id ResponseEntity
	 * encapsular requisicoes automaticamente para o serviço rest
	 * 
	 * @Autowired instacia automaticamente
	 */
	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Categoria obj = service.busca(id);
		
		return ResponseEntity.ok().body(obj);

	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				  path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	}

