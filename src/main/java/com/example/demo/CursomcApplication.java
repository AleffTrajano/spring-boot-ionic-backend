
//para troca de porta
//server.port=${port:8080}
package com.example.demo;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;

@SpringBootApplication

//CommandLineRunner permite usa um metodo auxiliar para executar uma açao quando a aplicação iniciar.
public class CursomcApplication implements CommandLineRunner  {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
	/*aqui faz a instaciação automatica dos objetos no caso os objetos categorias 
	direto no banco de dados.*/
	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		//agora usando o categoriarepository para salva esses objetos no banco
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
	}
}
