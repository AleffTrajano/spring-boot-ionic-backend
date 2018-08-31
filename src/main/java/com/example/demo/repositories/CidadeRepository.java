package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cidade;
/* realiza operações de acesso a dados busca,salva ets referente
ao objeto cidade que esta mapeado com a tabela cidade no banco */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

}
