package br.com.fiap.pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "br.com.fiap.pedido.controller", "br.com.fiap.pedido.service" })
@EnableJpaRepositories(basePackages = { "br.com.fiap.pedido.repository" })
@EntityScan(basePackages = { "br.com.fiap.pedido.domain" })
public class PedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class, args);
	}
}