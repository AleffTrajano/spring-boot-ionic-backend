package com.example.demo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* rest controller anotação para o rest precisa ser importada
*estamos criando uma classe que vai ser um controlado rest
* que vai responde ao endpoint categorias.
*/
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
/*requestmapping verbo http para uma requisição basica get. */
	@RequestMapping(method = RequestMethod.GET)
	public String lista() {
		return "rest esta funcionando";
	}
}
