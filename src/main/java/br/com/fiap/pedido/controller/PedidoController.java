package br.com.fiap.pedido.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pedido.domain.Pedido;
import br.com.fiap.pedido.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@PutMapping(path = "/addCarrinho")
	private ResponseEntity<Pedido> criaCarrinho(@RequestBody Pedido pedido) throws URISyntaxException {
		service.criaCarrinho(pedido);
		return ResponseEntity.created(new URI("/pedido/" + pedido.getId_Pedido())).build();
	}

	@GetMapping()
	public ResponseEntity<Page<Pedido>> listCarrinho() {
		final Page<Pedido> categoria = service.listCarrinho().map(Pedido::new);
		return ResponseEntity.ok(categoria);
	}

	@PostMapping(path = "/addItem")
	private ResponseEntity<Pedido> adicionaItem(@RequestBody Pedido pedido) throws URISyntaxException {
		service.adicionaItem(pedido);
		return ResponseEntity.created(new URI("/pedido/" + pedido.getId_Pedido())).build();
	}

	@PostMapping(path = "/removeItem")
	private ResponseEntity<Object> removeItem(@RequestBody Pedido pedido) throws URISyntaxException {
		service.removeItem(pedido);
		return ResponseEntity.created(new URI("/pedido/" + pedido.getId_Pedido())).build();
	}

	@PostMapping(path = "/finalizaCarrinho/{id}")
	private ResponseEntity<Integer> finalizaPedido(@PathVariable Integer id) throws URISyntaxException {
		service.finalizaPedido(id);
		return ResponseEntity.created(new URI("/pedido/" + id)).build();
	}

	@DeleteMapping(path = "/cancelarPedido/{id}")
	private ResponseEntity<Integer> cancelarPedido(@PathVariable Integer id) throws URISyntaxException {
		service.cancelarPedido(id);
		return ResponseEntity.created(new URI("/pedido/" + id)).build();
	}
}