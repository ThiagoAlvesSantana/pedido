package br.com.fiap.pedido.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pedido.domain.Pedido;
import br.com.fiap.pedido.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@PutMapping
	private ResponseEntity<Pedido> criaCarrinho(Pedido pedido) {
		service.criaCarrinho(pedido);
		return ResponseEntity.created(new URI("/pedido/" + pedido.getNome())).build();
	}

	@PutMapping
	private ResponseEntity<Pedido> adicionaItem(Pedido pedido) {
		service.adicionaItem(pedido);
		return ResponseEntity.created(new URI("/pedido/" + pedido.getNome())).build();
	}

	@PutMapping
	private ResponseEntity<Object> removeItem(Pedido pedido) {
		service.removeItem(pedido);
		return ResponseEntity.created(new URI("/pedido/" + pedido.getNome())).build();
	}

	@PutMapping
	private ResponseEntity<Integer> finalizaPedido(Integer id) throws URISyntaxException {
		service.finalizaPedido(id);
		return ResponseEntity.created(new URI("/pedido/" + id)).build();
	}
}