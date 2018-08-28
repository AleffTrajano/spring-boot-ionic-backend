
//para troca de porta
//server.port=${port:8080}
package com.example.demo;

import java.lang.reflect.Array;import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProdutoRepository;

@SpringBootApplication

//CommandLineRunner permite usa um metodo auxiliar para executar uma açao quando a aplicação iniciar.
public class CursomcApplication implements CommandLineRunner  {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
	/*aqui faz a instaciação automatica dos objetos no caso os objetos categorias 
	direto no banco de dados.*/
	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"computador",2000);
		Produto p2 = new Produto(null,"impressora",800);
		Produto p3 = new Produto(null,"mouse",80);
		
		
		//COLOCANDO CADA PRODUTO COM A LISTA NA QUAL ELE INTERAGE
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//FALANDO EM QUAL CATEGORIA O PRODUTO SE ENCAIXA
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		//agora usando o categoriarepository e produtoRepository para salva esses objetos no banco
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		
		
	}
}
