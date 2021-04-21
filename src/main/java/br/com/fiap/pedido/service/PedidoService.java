package br.com.fiap.pedido.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.pedido.domain.Pedido;
import br.com.fiap.pedido.domain.Status;
import br.com.fiap.pedido.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public void criaCarrinho(Pedido pedido) {
		pedido.setStatus(Status.EM_ANDAMENTO);
		repository.save(pedido);
	}

	public void adicionaItem(Pedido pedido) {
		Optional<Pedido> opPedido = repository.findById(pedido.getId_Pedido());
		opPedido.get().setItens(pedido.getItens());
		repository.save(opPedido.get());
	}

	public void removeItem(Pedido pedido) {
		repository.save(pedido);
	}

	public void finalizaPedido(Integer id) {
		Optional<Pedido> pedido = repository.findById(id);
		pedido.get().setStatus(Status.FECHADO);
		repository.save(pedido.get());
	}

	public void cancelarPedido(Integer id) {
		repository.deleteById(id);
	}

	public Page<Pedido> listCarrinho() {
		return repository.findAll(PageRequest.of(0, 3));
	}
}
