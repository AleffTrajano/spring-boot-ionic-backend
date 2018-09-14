package com.example.demo.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.ItemPedido;
import com.example.demo.domain.PagamentoComBoleto;
import com.example.demo.domain.Pedido;
import com.example.demo.domain.enums.EstadoPagamento;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.ItemPedidoRepository;
import com.example.demo.repositories.PagamentoRepository;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service

// criando um operacao que busca um categoria por codigo
public class PedidoService {

	// Autowired instancia a dependecia automaticamente pelo spring
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private  BoletoService boletoService;
	

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired	
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private  ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	/*
	 * vamos usa o objeto criado repo para busca no banco de dados uma categoria
	 * da um certo id
	 */
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			//ip.setPreco(produtoRepository.findOne(ip.getProduto().getId().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		System.out.println(obj);
		return obj;
	}
}
