package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Pedido;
/*CategoriaRepository realiza operações de acesso a dados busca,salva ets referente
ao objeto categoria que esta mapeado com a tabela categoria no banco */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
