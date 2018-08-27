package com.example.demo.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Categoria;

/* rest controller anotação para o rest precisa ser importada
*estamos criando uma classe que vai ser um controlado rest
* que vai responde ao endpoint categorias.
*/
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
/*requestmapping verbo http para uma requisição basica get. */
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> lista() {
		
		Categoria cat1 = new Categoria(1,"informatica");
		Categoria cat2 = new Categoria(2,"escritorio");
		
		List<Categoria> lista  = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		return lista;//irá retorna no formato json no localhost.
		
		
		

	}
}
