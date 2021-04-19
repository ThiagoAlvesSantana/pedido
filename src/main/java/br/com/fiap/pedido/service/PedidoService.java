package br.com.fiap.pedido.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.pedido.domain.Pedido;
import br.com.fiap.pedido.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public void criaCarrinho(Pedido pedido) {
		repository.save(pedido);
	}

	public void adicionaItem(Pedido pedido) {
		repository.save(pedido);
	}

	public void removeItem(Pedido pedido) {
		repository.save(pedido);
	}

	public void finalizaPedido(Integer id) {
		Optional<Pedido> pedido = repository.findById(id);
		repository.save(pedido.get());	
	}
}
