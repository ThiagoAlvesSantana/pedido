package br.com.fiap.pedido.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.pedido.domain.Pedido;

@Repository
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Integer> {

}
