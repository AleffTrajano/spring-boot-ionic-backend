//classe de dominio por isso está no pacote domain.
package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//jpa faz o mapeamento  objeto relacional criando as tabelas no banco usa a anotação entity
@Entity
public class Categoria implements Serializable {
	/**
	 * Serializable é uma declaração que diz que a classe, implementa a
	 * interface e diz que os objetos podem ser gravados em sequência de byte.
	 * rede.
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nome;

	// criando a lista de produtos e Associações categoria com produto alem de
	// inicia as coleções.

	
	@JsonManagedReference//coloca essa anotação para vim os obj associados.
	//fechando o mapeamento muitos para muitos dos dois lados. produto e categoria.
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();

	// criando emcapsulamento básico.
	public Categoria() {
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	// hashCode and equals faz a comparação dos objetos com o valor nesse caso
	// usando o id para comparação.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
