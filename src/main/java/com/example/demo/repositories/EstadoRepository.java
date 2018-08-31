package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Estado;
/* realiza operações de acesso a dados busca,salva ets referente
ao objeto estado que esta mapeado com a tabela estado no banco */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
