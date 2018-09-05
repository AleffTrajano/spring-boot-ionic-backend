package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Cliente;
import com.example.demo.services.ClienteService;

/* rest controller anotação para o rest precisa ser importada
*estamos criando uma classe que vai ser um controlado rest
* que vai responde ao endpoint categorias.
*/
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	/*
	 * requestmapping verbo http para uma requisição basica get. agora o metodo
	 * vai se chama find e vai ter 2 endpoint /categorias/id ResponseEntity
	 * encapsular requisicoes automaticamente para o serviço rest
	 * 
	 * @Autowired instacia automaticamente
	 */
	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {

		Cliente obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);

	
	}
}
