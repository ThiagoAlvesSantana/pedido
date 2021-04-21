package br.com.fiap.pedido.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Pedido.TABLE)
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String TABLE = "TAB_PEDIDO";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_Pedido;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Status")
	private Status status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Item")
	private List<Item> itens;

	public Pedido() {
		super();
	}

	public Pedido(Integer id_Pedido, Status status, List<Item> itens) {
		super();
		this.id_Pedido = id_Pedido;
		this.status = status;
		this.itens = itens;
	}

	public Pedido(Pedido pedido) {
		super();
		this.id_Pedido = pedido.getId_Pedido();
		this.status = pedido.getStatus();
		this.itens = pedido.getItens();
	}

	public Integer getId_Pedido() {
		return id_Pedido;
	}

	public void setId_Pedido(Integer id_Pedido) {
		this.id_Pedido = id_Pedido;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Pedido == null) ? 0 : id_Pedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id_Pedido == null) {
			if (other.id_Pedido != null)
				return false;
		} else if (!id_Pedido.equals(other.id_Pedido))
			return false;
		return true;
	}

}